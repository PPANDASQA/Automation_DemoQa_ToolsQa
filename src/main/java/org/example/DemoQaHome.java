package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DemoQaHome extends BaseDriver {

    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][1]")
    private WebElement elementsEle;

    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][2]")
    private WebElement formsEle;

    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][3]")
    private WebElement alertFrmWindEle;

    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][4]")
    private WebElement widgetsEle;

    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][5]")
    private WebElement interactionEle;

    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][6]")
    private WebElement bookStoreAppEle;


    public DemoQaHome() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void goToElementsPage() {
        new Base().webElementClick(elementsEle, "Elements");
    }

    public void goToFormPage() {
        new Base().webElementClick(formsEle, "Forms");
    }

    public void goToAlertFrmWindPage() {
        new Base().webElementClick(alertFrmWindEle, "Alert, Frame & Windows");
    }

    public void goToInteractionsPage() {
        new Base().webElementClick(interactionEle, "Interactions ");
    }

    public void goToBookStoreAppPage() {
        new Base().webElementClick(bookStoreAppEle, "Book store application ");
    }
}
