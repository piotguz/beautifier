package org.beautifier.testng.templated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TemplatedSuite {
	String name;
	List<TemplatedTestClass> tests = new ArrayList<>();

	public TemplatedSuite(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TemplatedTestClass> getTests() {
		return tests;
	}

	public void setTests(List<TemplatedTestClass> testClasses) {
		this.tests = testClasses;
	}

	public int getFailedTestsCount() {
		final AtomicInteger count = new AtomicInteger();
		tests.forEach(test -> {
			count.incrementAndGet();
		});
		
		return count.intValue();
	}

}
