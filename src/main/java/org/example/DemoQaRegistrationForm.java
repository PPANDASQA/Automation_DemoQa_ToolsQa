package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DemoQaRegistrationForm extends BaseDriver {

    @FindBy(xpath = "//div[@class = 'element-list collapse show']")
    private WebElement practiceFormTab;

    @FindBy(xpath = "//input[@id= 'firstName']")
    private WebElement firstNameEle;

    @FindBy(xpath = "//input[@id = 'lastName']")
    private WebElement lastNameEle;

    @FindBy(xpath = "//input[@id = 'userEmail']")
    private WebElement emailIdEle;

    @FindBy(xpath = "//label[@for = 'gender-radio-1']")
    private WebElement genderMaleEle;

    @FindBy(xpath = "//label[@for = 'gender-radio-2']")
    private WebElement genderFemaleEle;

    @FindBy(xpath = "//input[@id = 'userNumber']")
    private WebElement mobileNumberEle;

    @FindBy(xpath = "//input[@id = 'dateOfBirthInput']")
    private WebElement dobBoxEle;

    @FindBy(xpath = "//select[@class = 'react-datepicker__month-select']")
    private WebElement monthEle;

    @FindBy(xpath = "//select[@class = 'react-datepicker__year-select']")
    private WebElement yearEle;

    @FindBy(xpath = "//div[contains(@aria-label, 'August') and text() = '1']")
    private WebElement dateEle;

    @FindBy(xpath = "//input[@id = 'subjectsInput']")
    private WebElement subjectEle;

    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-2']")
    private WebElement hobbiesReadingEle;

    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-3")
    private WebElement getHobbiesMusicEle;

    @FindBy(xpath = "//label[@for = 'hobbies-checkbox-1']")
    private WebElement hobbiesSportsEle;

    @FindBy(xpath = "//input[@id= 'uploadPicture']")
    private WebElement fileUploadEle;

    @FindBy(xpath = "//textarea[@id= 'currentAddress']")
    private WebElement currentAddEle;

    @FindBy(xpath = "//input[@id = 'react-select-3-input']")
    private WebElement stateAndCityEle;

    @FindBy(xpath = "//input[@id = 'react-select-4-input']")
    private WebElement cityEle;

    @FindBy(xpath = "//button[@id = 'submit']")
    private WebElement submitButtonEle;

    public DemoQaRegistrationForm() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    //Click on Practice form Tab
    public void PracticeFormTab(){
        new Base().webElementClick(practiceFormTab, "Practice Form");
    }

    //Enter First name and Last name
    public void registrationName() {
        new Base().webElementSendKey(firstNameEle, "Priyabrata", "First Name");
        new Base().webElementSendKey(lastNameEle, "Panda", "Last name ");
    }

    //Enter email id
    public void registrationEmailId() {
        new Base().webElementSendKey(emailIdEle, "demo@gmail.com", "Email id ");
    }

    //Select Gender
    public void registrationGender() {
        new Base().webElementClick(genderMaleEle, "Male ");
        // new Base().webElementClick(genderFemale, "Female ");
    }

    //Enter mobile number
    public void registrationMobileNo() {
        new Base().webElementSendKey(mobileNumberEle, "7538086380", " Mobile number ");
    }

    //Select Date of Birth
    public void registrationDOB() {
        new Base().webElementClick(dobBoxEle, "Dob Text box");
        new Base().selectOption(monthEle, "visibletext", "August", "August month ");
        new Base().selectOption(yearEle, "value", "1947", "1947 year ");
        new Base().webElementClick(dateEle, "1");
    }

    //Select subject
    public void registrationSubject() {
        new Base().autoSuggestionHandler(subjectEle, "cs", "Economics", "Subject Text Box");
    }

    //Select hobbies
    public void registrationHobbies() {
        new Base().webElementClick(hobbiesReadingEle, "Reading");
        new Base().webElementClick(hobbiesSportsEle, "Sports");
        //  new Base().webElementClick(getHobbiesMusicEle, "Music");
    }

    //Photo upload
    public void registrationFileUpload() {
        new Base().webElementSendKey(fileUploadEle, "C:\\Users\\ppanda\\Downloads\\Object-Repository.jpg", "Picture uploaded");
    }

    //Enter current address
    public void registrationCurrentAdd() {
        new Base().webElementSendKey(currentAddEle, "Ambatur, chennai, india, 750063", "Current address");
        new Base().autoSuggestionHandler(stateAndCityEle, "NC", "NCR", "State box");
        new Base().autoSuggestionHandler(cityEle, "del", "Delhi", "City text box");
    }

    //Enter submit button
    public void registrationSubmitBtn() {
        new Base().webElementClick(submitButtonEle, "Submit button ");
    }


}

