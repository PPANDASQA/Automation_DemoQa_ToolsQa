package org.example;

public class Run {
    static String browser = "Chrome";
    static String url = "https://demoqa.com/select-menu";

    public static void main(String[] args) throws InterruptedException {
        Base obj = new Base();
        obj.openBrowser(browser);
        obj.getUrl(url);



    }
}
