package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BigBasket {
    static String browser = "Chrome";
    static String url = "https://www.bigbasket.com/";

    public static void main(String[] args) {
        Base baseObj = new Base();
        baseObj.openBrowser(browser);
        baseObj.getUrl(url);

       // baseObj.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(baseObj.driver, Duration.ofSeconds(10));

        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'Carrot')]//following::button[text()= 'Add'][1]")));
//         Actions actions = new Actions(baseObj.driver);
//         actions.moveToElement(item).click().perform();

          baseObj.webElementClick(item,"Add button");

        System.out.println(baseObj.driver.getTitle());


    }
}
