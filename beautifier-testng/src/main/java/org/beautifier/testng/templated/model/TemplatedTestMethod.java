package org.beautifier.testng.templated.model;

public class TemplatedTestMethod {
	String name;
	String qName;
	String status;
	
	public TemplatedTestMethod(String methodName, String methogQName) {
		super();
		this.name = methodName;
		this.qName = methogQName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
