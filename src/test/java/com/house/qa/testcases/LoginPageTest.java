package com.house.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.house.qa.base.TestBase;
import com.house.qa.pages.DashboardPage;
import com.house.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;

	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod()
	public void setUp() throws IOException  {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void validateloginPageURLTest() {
		String url=loginPage.validateLoginPageURL();
		Assert.assertEquals(url, "https://pro.housecallpro.com/pro/log_in");
	}
	
	@Test(priority=2)
	public void onClickloginPageTest() throws IOException {
		dashboardPage=loginPage.onClickLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
