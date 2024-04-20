package com.example.appium.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utilities {
	 
	
	public void ClickElement(AndroidDriver driver, String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); 
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(locator)));
			element.click();
		}
		catch(Exception e) {
			System.out.println("unable to click the element "+locator+" and failed with an error:"+e.getMessage());
		}
	}
	
	public void EnterText(AndroidDriver driver, String locator, String value) {
		try {
			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("unable to enter the text "+locator+" and failed with an error:"+e.getMessage());
		}
	}
	
	public boolean IsElementVisible(AndroidDriver driver, String locator){
		boolean flag = false;
		try {
		if(driver.findElement(By.xpath(locator)).isDisplayed()) {
			 flag = true;
		}
		}
		catch(Exception e) {
			System.out.println("Method cannot find element "+locator+" and failed with an error:"+e.getMessage());
			return flag;
		}
		return flag;
	}

}
