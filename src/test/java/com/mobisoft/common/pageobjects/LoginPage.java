package com.mobisoft.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	// Login Page Objects

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private final By txtUsername = By.id("user-name");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.id("login-button");
	private final By valMsgErrorLoginDetails = By
			.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']");

	public WebElement txtUsername() {

		return driver.findElement(txtUsername);
	}

	public WebElement txtPassword() {

		return driver.findElement(txtPassword);
	}

	public WebElement btnLogin() {

		return driver.findElement(btnLogin);
	}

	public WebElement valMsgErrorLoginDetails() {

		return driver.findElement(valMsgErrorLoginDetails);
	}

	public String getTitleLoginPage() {
		return driver.getTitle();
	}

}
