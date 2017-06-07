package org.beautifier.testng.html;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HTMLTemplateData {
	String user, host, createdAt;
	
	List<HTMLSuite> suites = new ArrayList<>();
	
	protected HTMLTemplateData() throws UnknownHostException {
		super();
		user = System.getProperty("user.name","unknown");
		host = InetAddress.getLocalHost().getHostName();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-DD-mm HH:mm:ss");
		createdAt = format.format(new Date());
	}

	public List<HTMLSuite> getSuites() {
		return suites;
	}

	public void setSuites(List<HTMLSuite> suites) {
		this.suites = suites;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
