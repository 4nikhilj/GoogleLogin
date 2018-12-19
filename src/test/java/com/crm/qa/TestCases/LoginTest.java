package com.crm.qa.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtility;

public class LoginTest extends TestBase{

	public LoginPage LP;
	public HomePage homepage;

	public LoginTest() throws FileNotFoundException  {
		super();
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException {
			initialization();
	}
	
	@DataProvider
	public Object[][] getLoginData() {
	Object data[][]=TestUtility.getTestData("Sheet1");
	System.out.println("got the data");
	return data;
		
	}
	@Test(dataProvider="getLoginData")
	public void TC1(String username,String password) throws FileNotFoundException {
		LP=new LoginPage();
		homepage =LP.login(username, password);
	}


	
	@AfterMethod
	public void stop() {
	driver.close();
	}
}
