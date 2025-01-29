package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoQaForm {
    static String browser = "Chrome";
    static String url = "https://demoqa.com/automation-practice-form";

    public static void main(String[] args) {
        Base baseObj = new Base();
        baseObj.openBrowser(browser);
        baseObj.getUrl(url);

        //  WebDriverWait wait = new WebDriverWait(baseObj.driver, Duration.ofSeconds(10));

        //Web element for first name
        WebElement firstName = baseObj.driver.findElement(By.xpath("//input[@id= 'firstName']"));
        baseObj.webElementSendKey(firstName, "Priyabrata", "First Name");

        //Web element for last name
        WebElement lastName = baseObj.driver.findElement(By.xpath("//input[@id = 'lastName']"));
        baseObj.webElementSendKey(lastName, "Panda", "Last name ");

        //Web element for email id
        WebElement emailId = baseObj.driver.findElement(By.xpath("//input[@id = 'userEmail']"));
        baseObj.webElementSendKey(emailId, "demo@gmail.com", "Email id ");

        //Web element for gender
        WebElement gender = baseObj.driver.findElement(By.xpath("//label[@for = 'gender-radio-1']"));
        baseObj.webElementClick(gender, "Male ");

        //Wen element for mobile number
        WebElement tel = baseObj.driver.findElement(By.xpath("//input[@id = 'userNumber']"));
        baseObj.webElementSendKey(tel, "7538086380", " Mobile number ");

        //Element for DOB
        WebElement dobBox = baseObj.driver.findElement(By.xpath("//input[@id = 'dateOfBirthInput']"));
        baseObj.webElementClick(dobBox, "Dob Text box");

        //Web element for Month
        WebElement monthEle = baseObj.driver.findElement(By.xpath("//select[@class = 'react-datepicker__month-select']"));
        baseObj.selectOption(monthEle, "visibletext", "August", "August month ");

        //Wen element for year
        WebElement yearEle = baseObj.driver.findElement(By.xpath("//select[@class = 'react-datepicker__year-select']"));
        baseObj.selectOption(yearEle, "value", "1947", "1947 year ");

        //Web element for date
        WebElement dateEle = baseObj.driver.findElement(By.xpath("//div[contains(@aria-label, 'August') and text() = '1']"));
        baseObj.webElementClick(dateEle, "1");

        //Web element for subject field
        WebElement subEle = baseObj.driver.findElement(By.xpath("//input[@id = 'subjectsInput']"));
        baseObj.autoSuggestionHandler(subEle, "cs", "Economics", "Subject Text Box");


        //Web element for hobbies
        WebElement hobbies1 = baseObj.driver.findElement(By.xpath("//label[@for = 'hobbies-checkbox-2']"));
        baseObj.webElementClick(hobbies1, "Reading");
        WebElement hobbies2 = baseObj.driver.findElement(By.xpath("//label[@for = 'hobbies-checkbox-1']"));
        baseObj.webElementClick(hobbies2, "Sports");

        //Wen element for file upload
        WebElement fileUpload = baseObj.driver.findElement(By.xpath("//input[@id= 'uploadPicture']"));
        baseObj.webElementSendKey(fileUpload, "C:\\Users\\ppanda\\Downloads\\Object-Repository.jpg", "Picture uploaded");

        //Wen element for current address field
        WebElement currentAddress = baseObj.driver.findElement(By.xpath("//textarea[@id= 'currentAddress']"));
        baseObj.webElementSendKey(currentAddress, "Ambatur, chennai, india, 750063", "Current address");

        //Web element for State
        WebElement stateAndCity = baseObj.driver.findElement(By.xpath("//input[@id = 'react-select-3-input']"));
        baseObj.autoSuggestionHandler(stateAndCity, "NC", "NCR", "State box");

        //Web element for City
        WebElement city = baseObj.driver.findElement(By.xpath("//input[@id = 'react-select-4-input']"));
        baseObj.autoSuggestionHandler(city, "del", "Delhi", "City text box");

        //Web Element for submit button
        WebElement submitButton = baseObj.driver.findElement(By.xpath("//button[@id = 'submit']"));
        baseObj.webElementClick(submitButton, "Submit button ");


    }
}
