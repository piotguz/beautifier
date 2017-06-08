package org.beautifier.testng.templated.model;

import java.util.ArrayList;
import java.util.List;

public class TemplatedTestClass {
	String name, duration;
	int passedMethodsCount, failedMethodsCount, skippedMethodsCount;
	List<TemplatedTestMethod> methods = new ArrayList<>();
	
	public TemplatedTestClass(String name) {
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

	public List<TemplatedTestMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<TemplatedTestMethod> methods) {
		this.methods = methods;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
