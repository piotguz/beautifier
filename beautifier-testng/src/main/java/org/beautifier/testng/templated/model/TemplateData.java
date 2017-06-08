package org.beautifier.testng.templated.model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemplateData {
	String user, host, createdAt;
	
	public List<TemplatedSuite> suites = new ArrayList<>();
	
	public TemplateData() throws UnknownHostException {
		super();
		user = System.getProperty("user.name","unknown");
		host = InetAddress.getLocalHost().getHostName();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-DD-mm HH:mm:ss");
		createdAt = format.format(new Date());
	}

	public List<TemplatedSuite> getSuites() {
		return suites;
	}

	public void setSuites(List<TemplatedSuite> suites) {
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
