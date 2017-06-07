package org.beautifier.testng.html;

import java.util.ArrayList;
import java.util.List;

public class HTMLSuite {
	String name;
	List<HTMLTestClass> tests = new ArrayList<>();
	protected HTMLSuite(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<HTMLTestClass> getTests() {
		return tests;
	}

	public void setTests(List<HTMLTestClass> testClasses) {
		this.tests = testClasses;
	}

	
}
