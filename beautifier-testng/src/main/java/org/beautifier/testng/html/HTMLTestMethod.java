package org.beautifier.testng.html;

public class HTMLTestMethod {
	String methodName;
	String methodQName;
	String status;
	
	protected HTMLTestMethod(String methodName, String methogQName) {
		super();
		this.methodName = methodName;
		this.methodQName = methogQName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getMethodQName() {
		return methodQName;
	}
	public void setMethodQName(String methodQName) {
		this.methodQName = methodQName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	
	
}
