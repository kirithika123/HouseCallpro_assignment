package com.house.qa.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.house.qa.base.TestBase;
import com.house.qa.pages.DashboardPage;
import com.house.qa.pages.LoginPage;
import com.house.qa.pages.NewjobsPage;
import com.house.qa.pages.SchedulePage;
import static com.house.qa.util.TestUtil.CUSTOMER_EMAIL;
import static com.house.qa.util.TestUtil.ITEM_NAME;
import static com.house.qa.util.TestUtil.MESSAGE;
public class SchedulePageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewjobsPage newjobsPage;
	SchedulePage schedulePage;
	

	public SchedulePageTest() throws IOException {
		super();
	
	}
	
	@BeforeMethod()
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginPage=new LoginPage();
		String userName=prop.getProperty("username");
	 	String password=prop.getProperty("password");
		dashboardPage=loginPage.onClickLoginPage(userName,password);
		newjobsPage=dashboardPage.onClickNewJob();
		schedulePage=newjobsPage.onClickSaveJob(CUSTOMER_EMAIL,ITEM_NAME,MESSAGE);
	}
	
	@Test(priority=2)
	public void onValidateScheduleButtonTest() {
		String value=schedulePage.onValidateScheduleButton();
		Assert.assertEquals(value, "Schedule");
	    
	}
	
	@Test(priority=1)
	public void onActivityFeedTest() {
		String activityFeedText=schedulePage.onActivityFeed();
		Assert.assertTrue(activityFeedText, true);
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
