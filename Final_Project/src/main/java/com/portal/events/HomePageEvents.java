package com.portal.events;

import org.openqa.selenium.WebDriver;

import com.portal.objects.HomePageElements;
import com.portal.utils.Elements;

public class HomePageEvents {

	WebDriver driver;
	
	public HomePageEvents(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToLoginInLink() {
			
		Elements elements = new Elements();
		elements.getWebElement(driver, "XPATH", HomePageElements.MyaAccountButton).click();
		elements.getWebElement(driver, "XPATH", HomePageElements.LoginButton).click();
			
	}
}
