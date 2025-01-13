package com.mobisoft.common.utils;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BaseTest.driver = driver;
	}
}