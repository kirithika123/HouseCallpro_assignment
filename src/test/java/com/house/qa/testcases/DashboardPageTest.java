package com.house.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.house.qa.base.TestBase;
import com.house.qa.pages.DashboardPage;
import com.house.qa.pages.LoginPage;
import com.house.qa.pages.NewjobsPage;


public class DashboardPageTest extends TestBase {
	
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewjobsPage newjobsPage;

	public DashboardPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod()
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage();
		String userName=prop.getProperty("username");
	 	String password=prop.getProperty("password");
		
	 	dashboardPage=loginPage.onClickLoginPage(userName,password);
	}
	
	@Test(priority=1)
	public void validateDashboardPageTest() {
		String dashurl=dashboardPage.validateDashboardPage();
		Assert.assertEquals(dashurl, "Dash");
	}
	
	@Test(priority=2)
	public void onClickNewJobTest() throws IOException {
		newjobsPage=dashboardPage.onClickNewJob();
		
		
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
