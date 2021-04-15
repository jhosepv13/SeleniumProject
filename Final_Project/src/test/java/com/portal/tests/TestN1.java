package com.portal.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.portal.events.HomePageEvents;
import com.portal.events.LoginPageEvents;

public class TestN1 extends BaseTest{
  @Test
  public void goToLoginSection() {
	  
	  HomePageEvents homePageEvents = new HomePageEvents(getDriver());
	  homePageEvents.goToLoginInLink();
	  
	  LoginPageEvents loginPageEvents = new LoginPageEvents(getDriver());
	  loginPageEvents.login();
	  
	  
  }
}
