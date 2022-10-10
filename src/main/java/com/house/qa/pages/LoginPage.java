package com.house.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.house.qa.base.TestBase;

import java.io.IOException;


public class LoginPage extends TestBase {
	
	

	//Page Factory-OR
	
	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement passwd;
	
	@FindBy(xpath="//button[starts-with(@class,'MuiButtonBase-root')]")
	@CacheLookup
	WebElement loginButton;
	
	//Initializing Page objects
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageURL() {
		return driver.getCurrentUrl();
	}
	
	public DashboardPage onClickLoginPage(String un,String pwd) throws IOException {
		email.sendKeys(un);
		passwd.sendKeys(pwd);
		loginButton.click();
		return new DashboardPage();
	}

}
