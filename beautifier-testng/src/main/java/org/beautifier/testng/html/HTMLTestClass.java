package org.beautifier.testng.html;

import java.util.ArrayList;
import java.util.List;

public class HTMLTestClass {
	String name;
	int passedMethodsCount, failedMethodsCount, skippedMethodsCount;
	List<HTMLTestMethod> methods = new ArrayList<>();
	
	public HTMLTestClass(String name) {
		super();
		this.name = name;
	}

	public int getPassedMethodsCount() {
		return passedMethodsCount;
	}

	public void setPassedMethodsCount(int passedMethodsCount) {
		this.passedMethodsCount = passedMethodsCount;
	}

	public int getFailedMethodsCount() {
		return failedMethodsCount;
	}

	public void setFailedMethodsCount(int failedMethodsCount) {
		this.failedMethodsCount = failedMethodsCount;
	}

	public int getSkippedMethodsCount() {
		return skippedMethodsCount;
	}

	public void setSkippedMethodsCount(int skippedMethodsCount) {
		this.skippedMethodsCount = skippedMethodsCount;
	}

	public List<HTMLTestMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<HTMLTestMethod> methods) {
		this.methods = methods;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
