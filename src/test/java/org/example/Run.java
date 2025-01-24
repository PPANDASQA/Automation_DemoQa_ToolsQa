package org.example;


public class Run {
    static String browser = "Chrome";
    static String url = "https://www.saucedemo.com/";

    public static void main(String[] args) {
        Base obj = new Base();
        obj.openBrowser(browser);
        obj.getUrl(url);

    }
}
