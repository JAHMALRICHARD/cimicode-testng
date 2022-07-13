package com.cimicode.stepdefs;





import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	public static WebDriver driver;
	
	@Given("The user is on the login screen")
	public void the_user_is_on_the_login_screen() {
		driver = Hooks.driver;
		driver.get("http://dev.cimicode.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement usernameTextBox = driver.findElement(By.id("username"));
		assertEquals("User is on the Home Page", usernameTextBox.isDisplayed(), true);
	    
	}

	@When("the user enters {string} in username field")
	public void the_user_enters_in_username_field(String strUserNsme) {
		
		WebElement usernameTextBox = driver.findElement(By.id("username"));
		usernameTextBox.click();
		usernameTextBox.clear();
		usernameTextBox.sendKeys(strUserNsme);
	}

	@When("the user enters {string} in the password field")
	public void the_user_enters_in_the_password_field(String strPwd) {
		WebElement passwordTextBox = driver.findElement(By.id("userpassword"));
		passwordTextBox.click();
		passwordTextBox.clear();
		passwordTextBox.sendKeys(strPwd);
	}
	
	@When("the user clicks the Sign in button")
	public void the_user_clicks_the_log_in_button() {
		WebElement signInButton = driver.findElement(By.cssSelector("[class*='btn btn-success']"));
		signInButton.click();
		Wait(3000);
	}

	@Then("the dashboard page is displayed")
	public void the_dashboard_page_is_displayed() {
		//close theme customizer
	    driver.findElement(By.cssSelector("[class*='btn-close btn-close-white ms-auto'")).click();
	    WebElement pageTitle = driver.findElement(By.cssSelector("h4[class='mb-sm-0']"));
		assertEquals("User is on the Chat Page", pageTitle.getText().toLowerCase().matches("dashboard"), true);
	}
	
	@Then("the system displays an error")
	public void the_system_displays_an_error() {
		WebElement errorEle = driver.findElement(By.id("error"));
		assertEquals("Error message displayed", errorEle.getText().contains("Invalid Email or Password"), true);
	    
	}
	
	public void Wait(int ms) {
		
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
