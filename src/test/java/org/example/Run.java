package org.example;


import org.openqa.selenium.firefox.FirefoxDriver;

public class Run {
    static String browser = "Chrome";
    static String url = "https://www.google.com";

    public static void main(String[] args) {
        Base obj = new Base();
        obj.openBrowser(browser);
        obj.getUrl(url);

    }
}
