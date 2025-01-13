package com.mobisoft.common.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.mobisoft.common.pageobjects.LoginPage;
import com.mobisoft.common.utils.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination {

	private SoftAssert softAssert;
	private WebDriver driver;
	private LoginPage loginPage;
	WebDriverWait wait;

	public LoginPageStepDefination() {
		softAssert = new SoftAssert();
		driver = BaseTest.getDriver();
		loginPage = new LoginPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Given("User is on saucedemo login page")
	public void userIsOnSauceDemoLoginPage() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtUsername()));

		softAssert.assertEquals(loginPage.getTitleLoginPage(), "Swag Labs");

	}

	@When("User enters username {string} and password {string} and clicks on login page")
	public void userEntersIncorrectUsernameAndPasswordAndClicksOnLoginPage(String userName, String passWord)
			throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtUsername()));

		loginPage.txtUsername().sendKeys(userName);

		wait.until(ExpectedConditions.elementToBeClickable(loginPage.txtPassword()));

		loginPage.txtPassword().sendKeys(passWord);

		wait.until(ExpectedConditions.elementToBeClickable(loginPage.btnLogin()));

		loginPage.btnLogin().click();

	}

	@Then("User should not be able to login and get error validation message")
	public void userShouldNotBeAbleToLoginAndGetValidationMessage() {

		softAssert.assertEquals(loginPage.valMsgErrorLoginDetails().getText(),
				"Epic sadface: Username and password do not match any user in this service",
				"No validation msg on entering invalid credentials");

		softAssert.assertAll();

	}

	@Then("User should be on dashboard page")
	public void userShouldBeOnDashboardPage() throws InterruptedException {

		softAssert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
				"User not able to login successfully");

		softAssert.assertAll();

	}

}
