package com.portal.events;

import org.openqa.selenium.WebDriver;

import com.portal.objects.LoginPageElements;
import com.portal.utils.Elements;

public class LoginPageEvents {

	WebDriver driver;
	
	public LoginPageEvents(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		
		Elements elements = new Elements();
		elements.getWebElement(driver, "NAME", LoginPageElements.EmailInput).sendKeys("user@phptravels.com");
		elements.getWebElement(driver, "NAME", LoginPageElements.PasswordInput).sendKeys("demouser");
			
	}
	
}
