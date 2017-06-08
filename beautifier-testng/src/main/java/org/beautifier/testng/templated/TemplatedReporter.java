package org.beautifier.testng.templated;

import java.io.FileWriter;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.beautifier.testng.templated.model.TemplateData;
import org.beautifier.testng.templated.model.TemplatedSuite;
import org.beautifier.testng.templated.model.TemplatedTestClass;
import org.beautifier.testng.templated.model.TemplatedTestMethod;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class TemplatedReporter implements IReporter {
	private static final String W3C_HTML_FTL = "org/beautifier/testng/templates/W3C_HTML.ftl";
	Logger log = Logger.getLogger(getClass().getSimpleName());

	public void generateReport(List<XmlSuite> xsuites, List<ISuite> suites, String output) {
		try {
			TemplateData templateData = new TemplateData();

			Configuration cfg = new Configuration(new Version(2, 3, 20));
			cfg.setClassForTemplateLoading(getClass(), "/");

			Template template = cfg.getTemplate(getFonfigParam("template", W3C_HTML_FTL));

			suites.forEach(suite -> {
				log.info(String.format("%s, %d", suite.getName(), suite.getResults().size()));

				TemplatedSuite tSuite = new TemplatedSuite(suite.getName());

				suite.getResults().values().forEach(suiteResult -> {
					ITestContext testContext = suiteResult.getTestContext();
					DateTime startDate = new DateTime(testContext.getStartDate());
					DateTime endDate = new DateTime(testContext.getEndDate());
					Period duration = new Period(startDate, endDate);

					PeriodFormatter fmt = new PeriodFormatterBuilder().appendHours()
							.appendSuffix(" h ").appendMinutes()
							.appendSuffix(" min ").appendSeconds()
							.appendSuffix(" sec ").appendMillis().appendSuffix(" ms ").toFormatter();

					String print = fmt.print(duration);
					log.info(print);
					
					TemplatedTestClass tTestClass = new TemplatedTestClass(testContext.getName());
					tTestClass.setDuration(print);
					tTestClass.setFailedMethodsCount(testContext.getFailedTests().size());
					tTestClass.setPassedMethodsCount(testContext.getPassedTests().size());
					tTestClass.setSkippedMethodsCount(testContext.getSkippedTests().size());

					testContext.getFailedTests().getAllMethods().forEach(testMethod -> {
						handleTestMethod(tTestClass, testMethod, "Failed");
					});
					testContext.getPassedTests().getAllMethods().forEach(testMethod -> {
						handleTestMethod(tTestClass, testMethod, "Passed");
					});
					testContext.getSkippedTests().getAllMethods().forEach(testMethod -> {
						handleTestMethod(tTestClass, testMethod, "Skipped");
					});

					tSuite.getTests().add(tTestClass);

				});

				templateData.suites.add(tSuite);
			});

			FileWriter fileWriter = new FileWriter(String.format("%s/tescik.html", output));
			template.process(templateData, fileWriter);

			fileWriter.flush();
			fileWriter.close();

		} catch (Exception e) {
			log.severe(ExceptionUtils.getMessage(e));
			log.severe(ExceptionUtils.getStackTrace(e));
		}
	}

	private String getFonfigParam(String param, String defaultValue) {
		return System.getProperty(String.format("%s.%s", getClass().getPackage().getName(), param), defaultValue);
	}

	private void handleTestMethod(TemplatedTestClass tTestClass, ITestNGMethod testMethod, String status) {
		TemplatedTestMethod tTestMethod = new TemplatedTestMethod(testMethod.getMethodName(),
				testMethod.getQualifiedName());
		tTestMethod.setName(testMethod.getMethodName());
		tTestMethod.setqName(testMethod.getQualifiedName());
		tTestMethod.setStatus(status);
		tTestClass.getMethods().add(tTestMethod);

	}

}
