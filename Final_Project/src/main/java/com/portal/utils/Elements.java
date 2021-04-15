package com.portal.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
	
	public WebElement getWebElement(WebDriver driver, String identifytype, String identifyvalue) {

		switch (identifytype) {

		case "ID":
			return driver.findElement(By.id(identifyvalue));
		case "NAME":
			return driver.findElement(By.name(identifyvalue));
		case "CSS":
			return driver.findElement(By.cssSelector(identifyvalue));
		case "TAGNAME":
			return driver.findElement(By.tagName(identifyvalue));
		case "CLASSNAME":
			return driver.findElement(By.className(identifyvalue));
		case "XPATH":
			return driver.findElement(By.xpath(identifyvalue));
		case "LINKTEXT":
			return driver.findElement(By.linkText(identifyvalue));
		case "PARTIALLINKTEXT":
			return driver.findElement(By.partialLinkText(identifyvalue));
		default:
			return null;

		}
	}

	public List<WebElement> getListWebElements(WebDriver driver, String identifytype, String identifyvalue) {

		switch (identifytype) {

		case "ID":
			return driver.findElements(By.id(identifyvalue));
		case "NAME":
			return driver.findElements(By.name(identifyvalue));
		case "CSS":
			return driver.findElements(By.cssSelector(identifyvalue));
		case "TAGNAME":
			return driver.findElements(By.tagName(identifyvalue));
		case "CLASSNAME":
			return driver.findElements(By.className(identifyvalue));
		case "XPATH":
			return driver.findElements(By.xpath(identifyvalue));
		case "LINKTEXT":
			return driver.findElements(By.linkText(identifyvalue));
		case "PARTIALLINKTEXT":
			return driver.findElements(By.partialLinkText(identifyvalue));
		default:
			return null;

		}
	}
}
