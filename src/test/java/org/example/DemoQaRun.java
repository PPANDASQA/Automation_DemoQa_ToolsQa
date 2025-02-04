package org.example;

public class DemoQaRun extends BaseDriver {
    static String browser = "Chrome";
    static String url = "https://demoqa.com/";

    public static void main(String[] args) throws InterruptedException {
        new Base().openBrowser(browser);
        new Base().getUrl(url);

        //Calling method to automate of form page
        new DemoQaHome().goToFormPage();
        new DemoQaRegistrationForm().PracticeFormTab();
        new DemoQaRegistrationForm().registrationName();
        new DemoQaRegistrationForm().registrationEmailId();
        new DemoQaRegistrationForm().registrationGender();
        new DemoQaRegistrationForm().registrationMobileNo();
        new DemoQaRegistrationForm().registrationDOB();
        new DemoQaRegistrationForm().registrationSubject();
        new DemoQaRegistrationForm().registrationHobbies();
        new DemoQaRegistrationForm().registrationFileUpload();
        new DemoQaRegistrationForm().registrationCurrentAdd();
        new DemoQaRegistrationForm().registrationSubmitBtn();

        //Navigate back to Home page
        driver.navigate().back();
        driver.navigate().back();


        //Calling method to automate of Alerts page
        new DemoQaHome().goToAlertFrmWindPage();
        new DemoQaAlertAndFrame().goToAlertTab();
        new DemoQaAlertAndFrame().normalAlert();
        new DemoQaAlertAndFrame().timerAlert();
        new DemoQaAlertAndFrame().confirmAlert();
        new DemoQaAlertAndFrame().promptAlert();

        //Calling method to automate of Frames page
        new DemoQaAlertAndFrame().goToFrameTab();
        new DemoQaAlertAndFrame().frame1Test();
        new Base().switchToDefaultContent();  //Switch back to default  Content from frame
        new DemoQaAlertAndFrame().frame2Test();
        new Base().switchToDefaultContent(); //Switch back to default  Content from frame

        //Calling method to automate of Nested Frames page
        new DemoQaAlertAndFrame().goToNestedFrame();
        new DemoQaAlertAndFrame().nestedFrameTest();
        new Base().switchToParentFrame();

        //Switch back to default content and Navigate to home page
        new Base().switchToDefaultContent();
        driver.navigate().to("https://demoqa.com/");

        //Calling method to automate of Elements page
        new DemoQaHome().goToElementsPage();
        new DemoQaElements().textBoxTest();
        new DemoQaElements().checkBoxTest();
        new DemoQaElements().checkRadioBtn();
        new DemoQaElements().webTablesTest();
        new DemoQaElements().buttonsTest();
        new DemoQaElements().linksTest();


    }

}
