package page.objects;

import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class NavigationBarLink extends BrowserDriver {

    // used different locator to find elements
    // realtive xpath used
    @FindBy(xpath = "//*[@id='nav-your-amazon']")
    private WebElement yourAmazon;

    @FindBy(xpath = "//a[@tabindex='48']")
    private WebElement yearEndDeals;
    //used how with FindBy, we can use both ways

    @FindBy(how = How.PARTIAL_LINK_TEXT,partialLinkText = "Gift Cards")
    private WebElement giftCards;

    @FindBy(xpath = "//*[@tabindex='50']")
    private WebElement wholeFoods;

    //using css selector
    @FindBy(how= How.CSS,css = "a.nav-a:nth-child(6)")
    private WebElement registry;

    //using text() in xpath : difference in contains() and text() is of , and =
    @FindBy(how= How.ID,xpath = "//*[text()='Sell']")
    private WebElement sell;

    @FindBy(linkText = "Help")
    private WebElement help;


    @FindBy (xpath = "//a[@tabindex = '66']")
    private WebElement yearEndconfirmation;
    Wait wait = null;

    @FindBy (xpath = "//*[@alt='Register with Amazon']")
    WebElement confirmationForRegistry;

    String nameOfElement = null;

    public void yearEndDeals(){

        nameOfElement= "Year End Deals";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        yearEndDeals.click();
        ApplicationPageBase.afterClicking(nameOfElement);


        Assert.assertEquals(true,yearEndconfirmation.isEnabled());

        ApplicationPageBase.testPassed(nameOfElement);
    }

    public void giftcards(){
        String testOfGiftCard = giftCards.getText();

        nameOfElement= "Gift Card";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        giftCards.click();
        ApplicationPageBase.afterClicking(nameOfElement);



        Assert.assertEquals("Gift Cards",testOfGiftCard);
        ApplicationPageBase.testPassed(nameOfElement);
    }


    public void wholeFoods(){
        nameOfElement= "Whole Foods";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        wholeFoods.click();
        ApplicationPageBase.afterClicking(nameOfElement);


        Assert.assertTrue(yourAmazon.isDisplayed());
        ApplicationPageBase.testPassed(nameOfElement);
    }

    public void yourAmazon(){
        nameOfElement= "Your Amazon";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        Assert.assertTrue(yourAmazon.isEnabled());
        yourAmazon.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        ApplicationPageBase.testPassed(nameOfElement);
    }

    public void registry(){

        nameOfElement= "Registry";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        registry.click();
        ApplicationPageBase.afterClicking(nameOfElement);

        Assert.assertTrue(confirmationForRegistry.isDisplayed());
        ApplicationPageBase.testPassed(nameOfElement);    }


    public void sell(){
        nameOfElement= "Sell";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        sell.click();
        ApplicationPageBase.afterClicking(nameOfElement);

        Assert.assertTrue(sell.isEnabled());
        ApplicationPageBase.testPassed(nameOfElement);
        }

    public void help(){
        nameOfElement= "Help";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        help.click();
        ApplicationPageBase.afterClicking(nameOfElement);

        ApplicationPageBase.testPassed(nameOfElement);

    }




}
