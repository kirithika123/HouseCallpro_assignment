package com.house.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.house.qa.base.TestBase;

public class DashboardPage extends TestBase{
	
	//Page factory-OR
	@FindBy(xpath="//*[@id=\"hc-toolbar\"]/div[2]/div/div[1]/div[1]/div/div/div/a[3]/span[1]/span/h6")
	WebElement dashboard;
	
	@FindBy(xpath="//header/div[2]/div[1]/div[2]")
	@CacheLookup
	WebElement newButton;
	
	
	@FindBy(xpath="//li[@role='menuitem' and @tabindex='0']")
	@CacheLookup
	WebElement job;

	
    //Initialize Page objects
	public DashboardPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateDashboardPage() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hc-toolbar\"]"
				+ "/div[2]/div/div[1]/div[1]/div/div/div/a[3]/span[1]/span/h6")));
		return dashboard.getText();
	}
	
	
	public NewjobsPage onClickNewJob() throws IOException {
		newButton.click();
		job.click();
	    return new NewjobsPage();
	}

}
