package com.aut.tests;

import com.utilities.DriverManager;
import com.utilities.DriverManagerFactory;
import com.utilities.DriverType;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactoryPatternTest {

    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1,groups = "google,smoke,tests",description = "launches google and check for title")
    public void launchGoogleTest() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2,groups = "yahoo,regression,tests",description = "launches yahoo and check for title")
    public void launchYahooTest() {
        driver.get("https://www.yahoo.com");
        Assert.assertEquals("Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment", driver.getTitle());
    }

}