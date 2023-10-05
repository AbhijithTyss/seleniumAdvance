package com.crm.generic.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	public WebDriver driver;
	public static WebDriver eDriver;
	@BeforeSuite
	public void configReports() {
		
	}
	@BeforeTest
	public void testInitialization() {
	}
	@BeforeClass
	public void browserSetup() {
		driver=new ChromeDriver();
		eDriver=driver;
	}
	@AfterSuite
	public void reportBackup() {
	}
}	
