package com.cimicode.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChatStepDefs {

	public static WebDriver driver;

	@Given("The user is on the dashboard screen")
	public void the_user_is_on_the_dashboard_screen() {
		driver = Hooks.driver;
		driver.get("http://test.cimicode.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement signInButton = driver.findElement(By.cssSelector("[class*='btn btn-success']"));
		signInButton.click();
		//close theme customizer
		driver.findElement(By.cssSelector("[class*='btn-close btn-close-white ms-auto'")).click();
		Wait(5000);
	}

	@When("the user click {string} in the navigation menu")
	public void the_user_click_in_the_navigation_menu(String navlink) {
		Actions actions = new Actions(driver);
		
		WebElement sideBar = driver.findElement(By.cssSelector("[class='app-menu navbar-menu']"));
		actions.moveToElement(sideBar).perform();
		switch (navlink) {
		case "Apps":
			driver.findElement(By.cssSelector("[data-key='t-apps']")).click();
			assertTrue("User clicked " + navlink, true);
			break;
		default:
			System.out.println(navlink + " - The link/button you trying to click is not defined.");
		}

	}

	@When("the user click {string} in the dropdown list")
	public void the_user_click_in_the_dropdown_list(String sublink) {
		switch (sublink) {
		case "Chat":
			driver.findElement(By.cssSelector("[data-key='t-chat']")).click();
			assertTrue("User clicked " + sublink, true);
			break;
		default:
			System.out.println(sublink + " - The link/button you trying to click is not defined.");
		}

	}

	@When("the chat page displays")
	public void the_chat_page_displays() {
		WebElement chatTitle = driver.findElement(By.cssSelector("h4[class='mb-sm-0']"));
		assertEquals("User is on the Chat Page", chatTitle.getText().toLowerCase().matches("chat"), true);

	}

	@Then("the user enters {string}")
	public void the_user_enters(String chatMessageString) {
		WebElement chatMessageBox = driver.findElement(By.cssSelector("#chat-input"));
		chatMessageBox.click();
		chatMessageBox.clear();
		chatMessageBox.sendKeys(chatMessageString);
		assertTrue("User entered " + chatMessageString + " in the chatbox.", true);

	}

	@Then("the user clicks the send button")
	public void the_user_clicks_the_send_button() {
		
		WebElement chatSendIcon = driver.findElement(By.cssSelector("button.btn.btn-success.chat-send.waves-effect.waves-light"));
		chatSendIcon.submit();
		assertTrue("User clicked the send button", true);
		Wait(3000);
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
