package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwageLab {


    static String browser = "Chrome";
    static String url = "https://www.saucedemo.com/";

    public static void main(String[] args) {
        Base baseObj = new Base();
        baseObj.openBrowser(browser);
        baseObj.getUrl(url);

        baseObj.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(baseObj.driver, Duration.ofSeconds(10));

        //Web Element for the UserName
        WebElement userName = baseObj.driver.findElement(By.id("user-name"));
        baseObj.webElementSendKey(userName, "standard_user", "Username Textbox");

        //Web element for password
        WebElement password = baseObj.driver.findElement(By.name("password"));
        baseObj.webElementSendKey(password, "secret_sauce", "Password Textbox");

        //Web element for Login Button
        WebElement loginBtn = baseObj.driver.findElement(By.xpath("//input[@id = 'login-button']"));
        baseObj.webElementClick(loginBtn, "Login Button");

        //Total inventory
        List<WebElement> totalInventory = baseObj.driver.findElements(By.xpath("//button[@class = 'btn btn_primary btn_small btn_inventory ']"));
        System.out.println("Total item in the inventory : " + totalInventory.size());

        //Web element for sauce labs backpack item
        WebElement inventoryItem = baseObj.driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
        baseObj.webElementClick(inventoryItem, "Sauce Labs Backpack");

        //Web element add to cart
        WebElement addToCart = baseObj.driver.findElement(By.xpath("//button[@id = 'add-to-cart']"));
        baseObj.webElementClick(addToCart, "Add to cart");



        //Web element to go to the cart
        WebElement cart = baseObj.driver.findElement(By.xpath("//div[@id = 'shopping_cart_container']"));
        baseObj.webElementClick(cart, "Cart icon");

        //Cart item count
        WebElement cartBadge = baseObj.driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']"));
        String count = baseObj.getElementText(cartBadge);
        System.out.println("Item in the cart: " + count);


    }
}
