package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DemoQaElements extends BaseDriver {

    //Text Box all elements
    @FindBy(xpath = "//span[contains(text(), 'Text Box')]")
    private WebElement textBoxTab;

    @FindBy(xpath = "//input[@id = 'userName']")
    private WebElement fullName;

    @FindBy(xpath = "//input[@id = 'userEmail']")
    private WebElement emailEle;

    @FindBy(xpath = "//textarea[@id = 'currentAddress']")
    private WebElement currentAddEle;

    @FindBy(xpath = "//textarea[@id = 'permanentAddress']")
    private WebElement permanentAddEle;

    @FindBy(xpath = "//button[@id = 'submit']")
    private WebElement submitBtn;

    //Check Box all element
    @FindBy(xpath = "//span[contains(text(), 'Check Box')]")
    private WebElement checkBoxTab;

    @FindBy(xpath = "//button[@class = 'rct-collapse rct-collapse-btn']")
    private WebElement expandBtnEle;

    @FindBy(xpath = "//label[@for = 'tree-node-desktop']")
    private WebElement desktopEle;

    @FindBy(xpath = "(//button[@class = 'rct-collapse rct-collapse-btn'])[4]")
    private WebElement downloadExpandEle;

    @FindBy(xpath = "//label[@for = 'tree-node-wordFile']")
    private WebElement wordFileEle;

    @FindBy(xpath = "//button[@class = 'rct-option rct-option-expand-all']")
    private WebElement expandAllEle;


    //Radio Button all elements
    @FindBy(xpath = "//span[contains(text(), 'Radio Button')]")
    private WebElement radioBtnTab;

    @FindBy(xpath = "//label[@for= 'yesRadio']")
    private WebElement yesRadioBtn;


    //Web table all elements
    @FindBy(xpath = "//span[contains(text(), 'Web Tables')]")
    private WebElement webTablesTab;

    @FindBy(id = "addNewRecordButton")
    private WebElement addNewBtnEle;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameEle;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameEle;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailIdEle;

    @FindBy(xpath = "//input[@id='age']")
    private WebElement ageEle;

    @FindBy(xpath = "//input[@id='salary']")
    private WebElement salaryEle;

    @FindBy(xpath = "//input[@id='department']")
    private WebElement departmentEle;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement tableSubmitBtn;

    @FindBy(xpath = "//span[@id='delete-record-1']")
    private WebElement deleteBtnEle;

    // All buttons elements
    @FindBy(xpath = "//span[contains(text(), 'Buttons')]")
    private WebElement buttonsTab;

    @FindBy(xpath = "//button[text() = 'Double Click Me']")
    private WebElement doubleClickBtnEle;

    @FindBy(xpath = "//button[@id='rightClickBtn']")
    private WebElement rightClickBtnEle;

    @FindBy(xpath = "//button[text() = 'Click Me']")
    private WebElement singleClickBtnEle;

    //Links page elements
    @FindBy(xpath = "//li[@id='item-6']/span[contains(text(), 'Links')]")
    private WebElement LinksTab;

    public DemoQaElements() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void textBoxTest() {
        new Base().webElementClick(textBoxTab, "Text Box");
        new Base().webElementSendKey(fullName, "Priyabrata Panda", "Full name ");
        new Base().webElementSendKey(emailEle, "demo@gmail.com", "Email id ");
        new Base().webElementSendKey(currentAddEle, "Ambatur, Chennai", "Current Address ");
        new Base().webElementSendKey(permanentAddEle, "Bhadarak, Odisha", "Permanent Address");
        new Base().webElementClick(submitBtn, "Submit button ");
    }


    public void checkBoxTest() {
        new Base().webElementClick(checkBoxTab, "Check Box ");
        new Base().webElementClick(expandBtnEle, "Home expand Button ");
        new Base().webElementClick(desktopEle, "Desktop");
        new Base().webElementClick(downloadExpandEle, "Download Expand ");
        new Base().webElementClick(wordFileEle, "Word File.doc ");
        new Base().webElementClick(expandAllEle, "Expand all ");
    }


    public void checkRadioBtn() {
        new Base().webElementClick(radioBtnTab, "Radio button tab ");
        new Base().webElementClick(yesRadioBtn, "Yes Radio Button ");
    }

    public void webTablesTest() {
        new Base().webElementClick(webTablesTab, "Web Tables");
        new Base().webElementClick(addNewBtnEle, "Add ");
        new Base().webElementSendKey(firstNameEle, "Priyabrata", "First name ");
        new Base().webElementSendKey(lastNameEle, "Panda", "Last Name ");
        new Base().webElementSendKey(emailIdEle, "demo@gmail.com", "Email id box ");
        new Base().webElementSendKey(ageEle, "26", "Age box");
        new Base().webElementSendKey(salaryEle, "000000", "Salary box ");
        new Base().webElementSendKey(departmentEle, "Testing", "Department");
        new Base().webElementClick(tableSubmitBtn, "Submit button ");
        new Base().webElementClick(deleteBtnEle, "Record 1 delete ");
    }

    public void buttonsTest() {
        new Base().webElementClick(buttonsTab, "Button tab ");
        new Base().actionDoubleClick(doubleClickBtnEle, "Double Click button");
        new Base().actionContextClick(rightClickBtnEle, "Right click button ");
        new Base().webElementClick(singleClickBtnEle, "Single click");
    }

}
