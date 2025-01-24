package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    public WebDriver driver;

    public void openBrowser(String browser) {
        String op = browser.toLowerCase();

        switch (op) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println(" please enter valid browser name");
        }
        System.out.println("The invoke browser is " + op);
        driver.manage().window().maximize();
        System.out.println(op + " window got maximize");
    }

    //Method to get URL
    public void getUrl(String url) {
        try {
            driver.get(url);
            System.out.println("Url " + url + " opened");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    // Method for Send Keys
    public void webElementSendKey(WebElement ele, String input, String elementName) {
        try {
            ele.sendKeys(input);
            System.out.println(input + " entered in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Method for Click Action
    public void webElementClick(WebElement ele, String elementName) {
        try {
            ele.click();
            System.out.println(elementName + " clicked");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for get Text from element
    public String getElementText(WebElement ele) {
        String text = "";
        try {
            text = ele.getText();
            // System.out.println("Text from " + elementName + ": " + text);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return text;
    }


}
