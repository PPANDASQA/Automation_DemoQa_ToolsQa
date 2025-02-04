package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class DemoQaAlertAndFrame extends Base {

    @FindBy(xpath = "//span[text() = 'Alerts']")
    private WebElement alertsTab;

    @FindBy(xpath = "//span[text() = 'Frames']")
    private WebElement frameTab;

    //All alert button element
    @FindBy(xpath = "//button[@id = 'alertButton']")
    private WebElement alertBtnEle;

    @FindBy(xpath = "//button[@id = 'timerAlertButton']")
    private WebElement timerAlertEle;

    @FindBy(xpath = "//button[@id = 'confirmButton']")
    private WebElement confirmBtnEle;

    @FindBy(xpath = "//button[@id = 'promtButton']")
    private WebElement promptBtnEle;

    //All Frame Element
    @FindBy(xpath = "//iframe[@id = 'frame1']")
    private WebElement frameOneEle;

    @FindBy(id = "sampleHeading")
    private WebElement headingEle;

    @FindBy(xpath = "//iframe[@id = 'frame2']")
    private WebElement frameTwoEle;

    @FindBy(xpath = "//span[text() = 'Nested Frames']")
    private WebElement nestedFramesEle;

    @FindBy(xpath = "//iframe[@id = 'frame1']")
    private WebElement parentFrame;

    @FindBy(xpath = "//iframe[contains(@srcdoc , 'Child Iframe')]")
    private WebElement childFrame;


    public DemoQaAlertAndFrame() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void goToAlertTab() {
        new Base().webElementClick(alertsTab, "Alerts button");
    }

    public void normalAlert() {
        new Base().webElementClick(alertBtnEle, "First Alert button ");
        System.out.println("Alert text is : " + new Base().getAlertText());
        new Base().acceptAlert();
    }

    public void timerAlert() throws InterruptedException {
        new Base().webElementClick(timerAlertEle, "Timer Alert button");
        Thread.sleep(5500);
        System.out.println(new Base().getAlertText());
        new Base().acceptAlert();
    }

    public void confirmAlert() throws InterruptedException {
        new Base().webElementClick(confirmBtnEle, "Confirm alert button");
        Thread.sleep(5000);
        System.out.println("Alert text " + new Base().getAlertText());
        new Base().dismissAlert();
    }

    public void promptAlert() throws InterruptedException {
        new Base().webElementClick(promptBtnEle, "Prompt alert button ");
        Thread.sleep(1000);
        System.out.println("Alert text " + new Base().getAlertText());
        new Base().sendKeysAlert("Priyabrata");
        new Base().acceptAlert();
    }

    public void goToFrameTab() {
        new Base().webElementClick(frameTab, "Frame tab ");
    }

    public void frame1Test(){
        new Base().switchToFrame(frameOneEle);
        System.out.println(new Base().getElementText(headingEle));
    }

    public void frame2Test(){
        new Base().switchToFrame("frame2");
        System.out.println(new Base().getElementText(headingEle));
    }

    public void goToNestedFrame(){
        new Base().webElementClick(nestedFramesEle, "Nested Frames");
    }


public void nestedFrameTest(){
        new Base().handleNestedFrames(parentFrame, childFrame);
}




}
