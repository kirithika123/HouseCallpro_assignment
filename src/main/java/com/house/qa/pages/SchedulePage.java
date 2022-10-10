package com.house.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.house.qa.base.TestBase;

public class SchedulePage extends TestBase {
	
	//Page factory-OR
	
	@FindBy(xpath="//*[@id=\"hc-toolbar\"]/div/div/div[1]/div[1]/div/div/div/a[4]/span[1]/span/h6")
	WebElement schedule;

	

	@FindBy(xpath="//div[@class=\"MuiButtonBase-root MuiExpansionPanelSummary-root jss1680\"]")
	WebElement activityFeed;
	
	 //Initialize Page objects
	public SchedulePage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}	
		
	//Actions
	public String onValidateScheduleButton() {
		 
		 return schedule.getText();
	}
	
	public String onActivityFeed() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1500)", "");
		return activityFeed.getText();
	}

}
