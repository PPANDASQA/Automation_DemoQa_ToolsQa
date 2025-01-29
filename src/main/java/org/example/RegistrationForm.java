package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.xml.xpath.XPath;

public class RegistrationForm extends Base {

    @FindBy(xpath = "//input[@id= 'firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id = 'lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id = 'userEmail']")
    private WebElement emailId;

    @FindBy(xpath = "//label[@for = 'gender-radio-1']")
    private WebElement genderMale;

    @FindBy(xpath = "//label[@for = 'gender-radio-2']")
    private WebElement genderFemale;

    @FindBy(xpath = "//input[@id = 'userNumber']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//input[@id = 'dateOfBirthInput']")
    private WebElement dobBox;

    @FindBy(xpath = "//select[@class = 'react-datepicker__month-select']")
    private WebElement monthEle;

    @FindBy(xpath = "//select[@class = 'react-datepicker__year-select']")
    private WebElement yearEle;

    @FindBy(xpath = "//div[contains(@aria-label, 'August') and text() = '1']")
    private WebElement dateEle;

    @FindBy(xpath = "//input[@id = 'subjectsInput']")
    private WebElement subjectEle;


    public RegistrationForm() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
}
