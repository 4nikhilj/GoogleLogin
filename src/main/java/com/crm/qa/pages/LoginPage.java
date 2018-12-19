package com.crm.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//a[@id='gb_70']")
	WebElement signinBtn;

	@FindBy(xpath="//input[@type='email' and @id='identifierId']")
	WebElement username;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextBtn;

	@FindBy(xpath="//input[@type='password' and @name='password']")
	WebElement Password;
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextBtn2;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement Loginbtn;
	
	public HomePage login(String uname, String pwd) {
		signinBtn.click();
		username.sendKeys(uname);
		nextBtn.click();
		Password.sendKeys(pwd);

		try {nextBtn.click();}
		catch (StaleElementReferenceException e)
		{
			WebElement nextBtn = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
			nextBtn.click();
		}

		return new HomePage();
	}
	
	public LoginPage() throws FileNotFoundException {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	
	

}
