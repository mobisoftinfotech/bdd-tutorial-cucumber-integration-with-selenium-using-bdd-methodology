package com.mobisoft.common.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mobisoft.common.utils.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public WebDriver driver;

	@Before
	public void BeforeScenario() throws IOException, InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Thread.sleep(5000);
		driver.get("https://www.saucedemo.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String readyState = js.executeScript("return document.readyState").toString();

		while (!readyState.equals("complete")) {
			readyState = js.executeScript("return document.readyState").toString();
		}

		System.out.println("Page is fully loaded!");
		BaseTest.setDriver(driver);

	}

	@After
	public void AfterScenario() throws IOException {

		driver.quit();

	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			// screenshot
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");

		}

	}

}
