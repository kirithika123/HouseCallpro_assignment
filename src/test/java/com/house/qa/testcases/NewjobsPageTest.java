package com.house.qa.testcases;

import java.io.IOException;

import static com.house.qa.util.TestUtil.CUSTOMER_EMAIL;
import static com.house.qa.util.TestUtil.ITEM_NAME;
import static com.house.qa.util.TestUtil.MESSAGE;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.house.qa.base.TestBase;
import com.house.qa.pages.DashboardPage;
import com.house.qa.pages.LoginPage;
import com.house.qa.pages.NewjobsPage;
import com.house.qa.pages.SchedulePage;
import com.house.qa.util.TestUtil;

public class NewjobsPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewjobsPage newjobsPage;
	SchedulePage schedulePage;
	
	String sheetName="newjob";
	public NewjobsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod()
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage();
		String userName=prop.getProperty("username");
	 	String password=prop.getProperty("password");
		
	 	dashboardPage=loginPage.onClickLoginPage(userName,password);
	 	newjobsPage=dashboardPage.onClickNewJob();
	}
	
	@Test(priority=1)
	public void newJobsURLTest() {
		String actualurl=newjobsPage.newJobsURL();
		String expectedurl="https://pro.housecallpro.com/pro/jobs/new";
		Assert.assertEquals(actualurl, expectedurl,"URL doesn't match");
	}
	
	@Test(priority=2)
	public void validateCustomerDetailsTest() throws IOException, InterruptedException {
		String custname=newjobsPage.validateCustomerDetails(CUSTOMER_EMAIL);
		Assert.assertNotNull(custname,"Please enter customer details");
	}
	
	@Test(priority=2)
	public void validateItemNameTest() throws IOException, InterruptedException {
		String itemname=newjobsPage.validateItemName(ITEM_NAME);
		Assert.assertNotNull(itemname,"Please enter item details");
	}
	
	@Test(priority=3)
	public void validatePrivateNotesButtonTest() throws IOException, InterruptedException {
		
		newjobsPage=newjobsPage.validatePrivateNotesButton(MESSAGE);
	}
	
	@DataProvider
	public Object[][] getHouseCallTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getHouseCallTestData")
	public void onClickSaveJobTest(String cinfo,String item,String privatenotes) throws IOException, InterruptedException {
		
		schedulePage=newjobsPage.onClickSaveJob(cinfo,item,privatenotes);
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
