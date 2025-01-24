package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {
    static String browser = "Chrome";
    static String url = "https://www.bigbasket.com/";

    public static void main(String[] args) {
        Base baseObj = new Base();
        baseObj.openBrowser(browser);
        baseObj.getUrl(url);

        WebElement item = baseObj.driver.findElement(By.xpath("//h3[contains(text(), 'Capsicum')]//following::button[contains(text(), 'Add')][1]"));


         Actions actions = new Actions(baseObj.driver);
         actions.moveToElement(item).click().perform();


      //  baseObj.webElementClick(item,"Add button");

    }
}
