package com.example.appium.Tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.appium.Utils.Utilities;

import Pages.LeaguesPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LeaguesTest{
	 private static AndroidDriver driver;

	    @BeforeTest
	    public static void setUp() throws Exception {
	        // Set up desired capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appium:appPackage", "com.fivemobile.thescore");
	        caps.setCapability("appium:appActivity", ".ui.MainActivity");
	        caps.setCapability("appium:platformVersion", "13");
	        caps.setCapability("appium:automationName", "UiAutomator2");
	        caps.setCapability("autoGrantPermissions", true);
	        // Initialize the driver
	        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
	    }

	    @Test
	    public void testApp() throws InterruptedException {
	        LeaguesPage leaguesPage = new LeaguesPage(driver);
	        leaguesPage.NavigateToHomePage("Toronto Blue Jays");
	        leaguesPage.HandleLeagues("NHL");
	        leaguesPage.HandleLeaguesSubtabs("NHL", "STANDINGS");
	        leaguesPage.HandleBackNavigation();
	    }

	    @AfterTest
	    public static void tearDown() {
	        // Quit the driver
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
