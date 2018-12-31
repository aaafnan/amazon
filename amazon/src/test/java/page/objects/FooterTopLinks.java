package page.objects;

import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import reporting.TestLogger;

public class FooterTopLinks extends BrowserDriver {

    @FindBy(partialLinkText = "Careers")
    private WebElement getToKnowUs;

    @FindBy(partialLinkText = "Sell on Amazon")
    private WebElement makeMoneyWithUs;

    @FindBy(partialLinkText = "Shop with Points")
    private WebElement amazonPaymentProducts;

    @FindBy(partialLinkText = "Amazon Prime")
    private WebElement letUsHelpYou;

    @FindBy(id= "icp-touch-link-language")
    private WebElement laguageTab;


    @FindBy(id="icp-touch-link-country")
    private WebElement countryTab;

    @FindBy (id = "icp-btn-close-announce")
    private WebElement languagePopUpDismiss;

    @FindBy(id = "icp-selected-country")
    private WebElement countryWindowPopUp;

        String nameOfElement;

        public void getToKnowUs(){
            nameOfElement = "Get to Know Us.";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        getToKnowUs.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        ApplicationPageBase.testPassed(nameOfElement);
    }


    public void makeMoneyWithUs(){
        nameOfElement = "Make Money With US";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        makeMoneyWithUs.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        Assert.assertTrue( makeMoneyWithUs.isDisplayed());
        ApplicationPageBase.testPassed(nameOfElement);

    }

    public void amazonPaymentProducts(){
        nameOfElement = "Amazon Payment Product";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        amazonPaymentProducts.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        Assert.assertTrue(amazonPaymentProducts.isEnabled());
        ApplicationPageBase.testPassed(nameOfElement);
    }


    public void letUsHelpYou(){
        nameOfElement = "Let Us Help You.";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        letUsHelpYou.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        Assert.assertTrue(letUsHelpYou.isDisplayed());
        ApplicationPageBase.testPassed(nameOfElement);
    }


    public void laguageTab() throws InterruptedException {
        nameOfElement = "Language Tab";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        laguageTab.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        Thread.sleep(2000);
        ApplicationPageBase.beforeClickLog("to dismiss Tab");
        languagePopUpDismiss.click();
        ApplicationPageBase.afterClicking("");
        Assert.assertTrue(laguageTab.isDisplayed());
        ApplicationPageBase.testPassed(nameOfElement);
    }


    public void countryTab() throws InterruptedException {
        nameOfElement = "Country Tab";

        ApplicationPageBase.beforeClickLog(nameOfElement);
        countryTab.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        Assert.assertTrue(countryTab.isDisplayed());
        Thread.sleep(2000);
        Select select = new Select(countryWindowPopUp);
        ApplicationPageBase.beforeClickLog("dropdown for Australia");
        select.selectByValue("au");

        driver.findElement(By.xpath("//button[@class='a-button-text']")).click();
        ApplicationPageBase.afterClicking("Australia");
        ApplicationPageBase.testPassed(nameOfElement);
        }



}
