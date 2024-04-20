package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.example.appium.Utils.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LeaguesPage extends Utilities{
	public AndroidDriver driver;
	public LeaguesPage(AndroidDriver _driver) {
		driver = _driver;
	}
	
	
	//Locators
	public String GetStarted = "//*[@text='Get Started']";
	public String ContinueBtn = "//*[@text='Continue']";
	public String MaybeLaterBtn = "//*[@text='Maybe Later']";
	public String search = "//*[@text='Search']";
	public String favTeam = "//*[@text='FavTeam']";
	public String selectTeam = "(//*[@text='FavTeam'])[2]";
	public String DoneBtn = "//*[@text='Done']";
	public String ClosePopup = "//*[@resource-id='com.fivemobile.thescore:id/dismiss_modal']";
	public String HomepageSearch = "//*[@text='Teams, Players, and News']";
	public String LeaguesBtn = "//*[@text='Leagues']";
	public String EditBtn = "//*[@text='Edit']";
	public String BackBtn = "//*[@content-desc='Navigate up']";
	public String LeagueHeading = "(//*[@text='Leagues'])[1]";
	
	
	
	public void NavigateToHomePage(String favoriteTeams) {
		if(!IsElementVisible(driver, HomepageSearch)) {
		ClickElement(driver, GetStarted);
		ClickElement(driver, ContinueBtn);
		ClickElement(driver, MaybeLaterBtn);
		ClickElement(driver, search);
	    EnterText(driver,  search, favoriteTeams);
	    ClickElement(driver, selectTeam.replace("FavTeam", favoriteTeams));
	    ClickElement(driver, ContinueBtn);
	    ClickElement(driver, DoneBtn);
	    ClickElement(driver, MaybeLaterBtn);
	    WebElement popupElement = driver.findElement(MobileBy.xpath(ClosePopup)); 
        if (popupElement.isDisplayed()) {
            popupElement.click();
        }}
		else {
			System.out.println("User is already in Home Page.");
		}
		
	}
	
	public void HandleLeagues(String leagueName) throws InterruptedException {
		Thread.sleep(3000);
		 ClickElement(driver, LeaguesBtn);
		 ClickElement(driver, EditBtn);
		 ClickElement(driver, DoneBtn);
		 ClickElement(driver, favTeam.replace("FavTeam", leagueName));
		 if(IsElementVisible(driver, favTeam.replace("FavTeam", leagueName))) {
			 System.out.println(leagueName+" League page open sucessfully");
		 }
		 else {
			 System.out.println(leagueName+" League page open failed");
		 }
	}
	
	public void HandleLeaguesSubtabs(String leagueName, String subTabName) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 ClickElement(driver, favTeam.replace("FavTeam", subTabName));
		 if(IsElementVisible(driver, favTeam.replace("FavTeam", leagueName))) {
			 System.out.println(subTabName+" opened under "+leagueName+" League name sucessfully");
		 }
		 else {
			 System.out.println(subTabName+" opened under "+leagueName+" League name Failed");
		 }
	}
	
	public void HandleBackNavigation() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ClickElement(driver, BackBtn);
		 if(IsElementVisible(driver, LeagueHeading)) {
			 System.out.println("Navigation back to league page sucessful");
		 }
		 else {
			 System.out.println("Navigation back to league page failed");
		 }
		
	}

}
