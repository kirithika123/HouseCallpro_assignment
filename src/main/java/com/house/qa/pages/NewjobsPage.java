package com.house.qa.pages;

import java.io.IOException;
import static com.house.qa.util.TestUtil.MESSAGE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.house.qa.base.TestBase;

public class NewjobsPage extends TestBase{
	
	
	//PageFactory-OR
	@FindBy(xpath="//input[@type='text' and starts-with(@placeholder,'Name')]")
    WebElement customer;
	
	@FindBy(id="react-autowhatever-1--item-0")
	WebElement listBox;
    
	@FindBy(id="item-name")
	WebElement itemName;
	
	
	@FindBy(xpath="//p[contains(text(),'Kirithika Morkonda Janarthanan')]")
	WebElement customerName;
	
	@FindBy(xpath="//input[@id='item-name']")
	WebElement itemValidation;

	@FindBy(xpath="//p[contains(text(),'Private notes')]")
    WebElement notesButton;

	@FindBy(xpath="//textarea[@data-testid=\"private-notes-textfield\"]")
	WebElement notesTextBox;
	
	@FindBy(xpath="//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary\"]")
	WebElement saveButton;
	
	public NewjobsPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String newJobsURL() {
		return driver.getCurrentUrl();
	}
	
	
	public String validateCustomerDetails(String cn) throws IOException, InterruptedException {
		customer.sendKeys(cn);
		listBox.click();
		String custtxt=customerName.getText();
		return custtxt;
	}
    
	public String validateItemName(String itName) throws IOException {
		itemName.sendKeys(itName);
		listBox.click();
		String itemtxt=itemValidation.getText();
		return itemtxt;
	}
	
	public NewjobsPage validatePrivateNotesButton(String msg) throws IOException, InterruptedException {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)", "");
	    notesButton.click();
		notesTextBox.sendKeys(msg);
	    return new NewjobsPage();
	}
	
	public SchedulePage onClickSaveJob(String cn,String itName,String msg) throws IOException, InterruptedException{
		customer.sendKeys(cn);
		listBox.click();
		itemName.sendKeys(itName);
		listBox.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("window.scroll(0,500)", "");
	    notesButton.click();
		notesTextBox.sendKeys(msg);
		if(saveButton.isEnabled()) {
		    saveButton.click();
		   // Thread.sleep(2000);
		    System.out.println(driver.getCurrentUrl());
		    return new SchedulePage();
		}
		
		return null;
		
	}
	
	
}
