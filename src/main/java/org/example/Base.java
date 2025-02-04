package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Base extends BaseDriver {

    public Actions actions;
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
            Thread.sleep(600);
//            highlightElement(ele);
//            Thread.sleep(500);
            ele.click();
            System.out.println(elementName + " clicked");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for get Text from element
    public String getElementText(WebElement ele) {
        try {
            // System.out.println("Text from " + elementName + ": " + text);
            return ele.getText();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }

    }

    //Method for get title of the page
    public String getPageTitle() {
        try {
            String title = driver.getTitle();
            System.out.println("Page title is " + title);
            return title;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }
    }

    //Method for get URL
    public String getPageURL() {
        try {
            String URL = driver.getCurrentUrl();
            System.out.println("Current URL is " + URL);
            return URL;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }

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
            actions = new Actions(driver);
            scrollToView(ele);
            actions.click(ele).perform();
            System.out.println("Action click performed in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for action class double click
    public void actionDoubleClick(WebElement ele, String elementName) {
        try {
            actions = new Actions(driver);
            scrollToView(ele);
            actions.doubleClick(ele).perform();
            System.out.println("Action Double click performed in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for action class context click
    public void actionContextClick(WebElement ele, String elementName) {
        try {
            actions = new Actions(driver);
            scrollToView(ele);
            actions.contextClick(ele).perform();
            System.out.println("Action click performed in " + elementName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Method for action class move to element
    public void actionMoveToElement(WebElement ele, String elementName) {
        try {
            actions = new Actions(driver);
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

    //Method for highlight an element while perform any action
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element); // Highlight with a red border
        try {
            Thread.sleep(500); // Add a small delay to make the highlight visible
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        js.executeScript("arguments[0].style.border=''", element); // Remove the highlight
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

    // Method for Frame switching Using Frame element
    public void switchToFrame(WebElement frameElement) {
        try {
            driver.switchTo().frame(frameElement);
            System.out.println("Switched to frame: " + frameElement.toString());
        } catch (Exception e) {
            System.err.println("Failed to switch to frame: " + e.getMessage());
        }
    }

    //Method for frame switching using Name or I'd
    public void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
            System.out.println("Switched to frame with name or ID: " + nameOrId);
        } catch (Exception e) {
            System.err.println("Failed to switch to frame: " + e.getMessage());
        }
    }

    //Method for switching frame using index number
    public void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
            System.out.println("Switched to frame with index: " + index);
        } catch (Exception e) {
            System.err.println("Failed to switch to frame: " + e.getMessage());
        }
    }

    //Methods for switch for default container
    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
            System.out.println("Switched back to default content");
        } catch (Exception e) {
            System.err.println("Failed to switch to default content: " + e.getMessage());
        }
    }

    //Methods for switch to parent frame
    public void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
            System.out.println("Switched to parent frame");
        } catch (Exception e) {
            System.err.println("Failed to switch to parent frame: " + e.getMessage());
        }
    }

    //Method to handel nested frames
    public void handleNestedFrames(WebElement parentFrameElement, WebElement childFrameElement) {
        try {
            // Switch to the parent frame
            switchToFrame(parentFrameElement);
            System.out.println("Switched to parent frame");

            // Switch to the child frame
            switchToFrame(childFrameElement);
            System.out.println("Switched to child frame");
        } catch (Exception e) {
            System.err.println("Failed to handle nested frames: " + e.getMessage());
        }
    }


    public boolean isLinkDisplayed(WebElement linkElement, String linkName) {
        boolean isDisplayed = false;
        try {
            isDisplayed = linkElement.isDisplayed();
            System.out.println("Link '" + linkName + "' is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            System.err.println("Failed to check if link is displayed: " + linkName);
            return isDisplayed;
        }
    }




    public String getLinkText(WebElement linkElement, String linkName) {
        try {
            String linkText = linkElement.getText();
            System.out.println("Text of link '" + linkName + "': " + linkText);
            return linkText;
        } catch (Exception e) {
            System.err.println("Failed to get text of link: " + linkName);
            return e.getMessage();
        }
    }


    public String getLinkUrl(WebElement linkElement, String linkName) {
        try {
            String linkUrl = linkElement.getDomAttribute("href");
            System.out.println("URL of link '" + linkName + "': " + linkUrl);
            return linkUrl;
        } catch (Exception e) {
            System.err.println("Failed to get URL of link:" );
            return e.getMessage();
        }
    }

    public static String switchToNewWindow(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return originalWindow;
    }
}