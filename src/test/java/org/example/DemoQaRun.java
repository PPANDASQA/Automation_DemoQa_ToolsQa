package org.example;

public class DemoQaRun extends BaseDriver {
    static String browser = "Chrome";
    static String url = "https://demoqa.com/";

    public static void main(String[] args) throws InterruptedException {
        new Base().openBrowser(browser);
        new Base().getUrl(url);

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

        driver.navigate().back();
        driver.navigate().back();

        new DemoQaHome().goToAlertFrmWindPage();
        new DemoQaAlertAndFrame().alertTab();
        new DemoQaAlertAndFrame().normalAlert();
        new DemoQaAlertAndFrame().timerAlert();
        new DemoQaAlertAndFrame().confirmAlert();
        new DemoQaAlertAndFrame().promptAlert();
    }

}
