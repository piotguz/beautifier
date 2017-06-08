package org.beautifier.testng.pdf.sample;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {
	@BeforeTest
	public void beforeTest() {
		Reporter.log("beforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("beforeClass");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("beforeSuite");
	}
	
	@Test
	public void test1() throws InterruptedException {
		Reporter.log("Test1");
		Thread.sleep(2000);
		assertEquals("foobar", "foobar");
	}
	
	@Test
	public void test2() {
		Reporter.log("Test2");
		assertEquals("foobar", "foobarx");
	}
	
	@Test(expectedExceptions=FileNotFoundException.class)
	public void test3() throws FileNotFoundException {
		Reporter.log("Test3");
		throw new FileNotFoundException();
	}
}
