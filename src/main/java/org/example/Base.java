package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base extends BaseDriver {


    public Actions actions;
    public WebDriverWait wait;
    public Alert alert;

    //Method for open browser
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
/*
    //Method to going backward
    public void navigateBack() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method to going forward
    public void navigateForward() {
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method to Page Refresh
    public void navigateRefresh() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    } */

    // Method for Send Keys
    public void webElementSendKey(WebElement ele, String input, String elementName) {
        try {
            ele.clear();
            ele.sendKeys(input);
            System.out.println(input + " entered in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Method for Click Action
    public void webElementClick(WebElement ele, String elementName) {
        try {
            scrollToView(ele);
//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.elementToBeClickable(ele));
            Thread.sleep(600);
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

    //Method for get title of the page
    public String getPageTitle() {
        String title = "";
        try {
            title = driver.getTitle();
            System.out.println("Page title is " + title);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return title;
    }

    //Method for get URL
    public String getPageURL() {
        String URL = "";
        try {
            URL = driver.getCurrentUrl();
            System.out.println("Current URL is " + URL);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return URL;
    }

    //method for click operation in dropdown
    public void selectOption(WebElement ele, String method, String value, String elementName) {
        Select select = new Select(ele);
        String type = method.toLowerCase();
        try {
            switch (type) {

                case "value":
                    select.selectByValue(value);
                    break;
                case "visibletext":
                    select.selectByVisibleText(value);
                    break;
                case "indexnumber":
                    int index = Integer.parseInt(value);
                    select.selectByIndex(index);
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(elementName + "Is selected");
    }

    //Method for handel auto suggestion
    public void autoSuggestionHandler(WebElement ele, String inputText, String expectedText, String elementName) {
        webElementSendKey(ele, inputText, elementName);
        //ele.sendKeys(inputText);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            List<WebElement> suggestions = driver.findElements(By.xpath("//div[contains(@id, 'react-select')]"));
            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().contains(expectedText)) {
                    webElementClick(suggestion, expectedText);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    //Method for action class click
    public void actionClick(WebElement ele, String elementName) {
        try {
            actions.click(ele).perform();
            System.out.println("Action click performed in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for action class double click
    public void actionDoubleClick(WebElement ele, String elementName) {
        try {
            actions.doubleClick(ele).perform();
            System.out.println("Action Double click performed in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for action class context click
    public void actionContextClick(WebElement ele, String elementName) {
        try {
            actions.contextClick(ele).perform();
            System.out.println("Action click performed in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for action class move to element
    public void actionMoveToElement(WebElement ele, String elementName) {
        try {
            actions.moveToElement(ele).perform();
            System.out.println("Action click performed in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for Key down
    public void keyDown(String keyName) {
        try {
            switch (keyName.toLowerCase()) {

                case "enter":
                    actions.keyDown(Keys.ENTER).perform();
                    System.out.println(keyName + " key Clicked");
                case "backspace":
                    actions.keyDown(Keys.BACK_SPACE).perform();
                    System.out.println(keyName + " key Clicked");
                case "shift":
                    actions.keyDown(Keys.SHIFT).perform();
                    System.out.println(keyName + " key Clicked");
                case "ctrl":
                    actions.keyDown(Keys.CONTROL).perform();
                    System.out.println(keyName + " key Clicked");
                case "tab":
                    actions.keyDown(Keys.TAB).perform();
                    System.out.println(keyName + " key Clicked");
                default:
                    System.out.println("Enter valid key name ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for Key up
    public void keyUp(String keyName) {
        try {
            switch (keyName.toLowerCase()) {

                case "enter":
                    actions.keyUp(Keys.ENTER).perform();
                    System.out.println(keyName + " key released");
                case "backspace":
                    actions.keyUp(Keys.BACK_SPACE).perform();
                    System.out.println(keyName + " key released");
                case "shift":
                    actions.keyUp(Keys.SHIFT).perform();
                    System.out.println(keyName + " key released");
                case "ctrl":
                    actions.keyUp(Keys.CONTROL).perform();
                    System.out.println(keyName + " key released");
                case "tab":
                    actions.keyUp(Keys.TAB).perform();
                    System.out.println(keyName + " key released");
                default:
                    System.out.println("Enter valid key name ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for Scroll
    public void scroll(int xAxis, int yAxis) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("windows.scrollTo(" + xAxis + "," + yAxis + ")");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for scroll
    public void scrollToView(WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
    }

    //Method for get text from alert
    public String getAlertText() {
        try {
            alert = driver.switchTo().alert();
            return alert.getText();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //Method for accept alert
    public void acceptAlert() {
        try {
            alert = driver.switchTo().alert();
            Thread.sleep(1000);
            alert.accept();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for dismiss alert
    public void dismissAlert() {
        try {
            alert = driver.switchTo().alert();
            Thread.sleep(1000);
            alert.dismiss();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for Send keys to alert
    public void sendKeysAlert(String input) {
        try {
            alert = driver.switchTo().alert();
            Thread.sleep(500);
            alert.sendKeys(input);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
