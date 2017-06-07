package org.beautifier.testng.html;

import java.io.FileWriter;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class HTMLReporter implements IReporter {
	Logger log = Logger.getLogger(getClass().getSimpleName());

	public void generateReport(List<XmlSuite> xsuites, List<ISuite> suites, String output) {
		try {
			HTMLTemplateData templateData = new HTMLTemplateData();

			Configuration cfg = new Configuration(new Version(2, 3, 20));
			cfg.setClassForTemplateLoading(getClass(), "/");

			Template template = cfg.getTemplate("org/beautifier/testng/html/HTMLReporter.ftl");

			suites.forEach(suite -> {
				log.info(String.format("%s, %d", suite.getName(), suite.getResults().size()));
				
				HTMLSuite htmlSuite = new HTMLSuite(suite.getName());
				
				suite.getResults().values().forEach(suiteResult -> {
					ITestContext testContext = suiteResult.getTestContext();
					
					HTMLTestClass htmlTestClass = new HTMLTestClass(testContext.getName());
					htmlTestClass.setFailedMethodsCount(testContext.getFailedTests().size());
					htmlTestClass.setPassedMethodsCount(testContext.getPassedTests().size());
					htmlTestClass.setSkippedMethodsCount(testContext.getSkippedTests().size());
					
					testContext.getFailedTests().getAllMethods().forEach(testMethod -> {
						handleTestMethod(htmlTestClass, testMethod, "Failed");
					});
					testContext.getPassedTests().getAllMethods().forEach(testMethod -> {
						handleTestMethod(htmlTestClass, testMethod, "Passed");
					});
					testContext.getSkippedTests().getAllMethods().forEach(testMethod -> {
						handleTestMethod(htmlTestClass, testMethod, "Skipped");
					});
					
					htmlSuite.getTests().add(htmlTestClass);
					
				});
				
				templateData.suites.add(htmlSuite);
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

	private void handleTestMethod(HTMLTestClass htmlTestClass, ITestNGMethod testMethod, String status) {
		HTMLTestMethod htmlTestMethod = new HTMLTestMethod(testMethod.getMethodName(), testMethod.getQualifiedName());
		htmlTestMethod.setMethodName(testMethod.getMethodName());
		htmlTestMethod.setMethodQName(testMethod.getQualifiedName());
		htmlTestMethod.setStatus(status);
		htmlTestClass.getMethods().add(htmlTestMethod);
	}

}
