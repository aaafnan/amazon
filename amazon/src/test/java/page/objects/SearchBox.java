package page.objects;

import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import reporting.TestLogger;

public class SearchBox extends BrowserDriver {


    @FindBy(how = How.ID,id = "searchDropdownBox")
    private WebElement seachBoxDropDown;
    @FindBy (xpath = "//*[@value='search-alias=amazonfresh']")
    private WebElement confirmSearchBoxdrop;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy (how = How.XPATH,xpath= "//input[@value='Go']")
    private WebElement searchIcon;

    String nameOfElement = null;

    public void dropdownselection(){
        nameOfElement= "Drop Down Selecton";
        ApplicationPageBase.beforeClickLog(nameOfElement);
        seachBoxDropDown.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        Assert.assertTrue(confirmSearchBoxdrop.isDisplayed());
        ApplicationPageBase.testPassed(nameOfElement);
    }

    public void listSearchBox() {
        nameOfElement="Amazon Device";
        Select select = new Select(seachBoxDropDown);
        ApplicationPageBase.beforeClickLog(nameOfElement);
        select.selectByVisibleText("Amazon Devices");
//        Assert.assertTrue(seachBoxDropDown.isDisplayed());
        ApplicationPageBase.testPassed(nameOfElement);
    }

    public void searchTextBox(String enterSearchWord){
        TestLogger.log("Sending KeyWord");
        searchTextBox.sendKeys(enterSearchWord);
        TestLogger.log("Keys arrived");
        searchTextBox.sendKeys(Keys.ENTER);
        TestLogger.log("Enter Pressed");

    }

    public void searchIcon() throws InterruptedException {
        nameOfElement ="Search Icon";
        searchTextBox("Something");
        Thread.sleep(2000);

        Actions mouse = new Actions(driver);
        mouse.moveToElement(searchIcon).build().perform();
        ApplicationPageBase.testPassed(nameOfElement);
        searchIcon.click();
        ApplicationPageBase.afterClicking(nameOfElement);
        ApplicationPageBase.testPassed(nameOfElement);

        }

    public WebElement getSearchTextBox(){
        return searchTextBox;
    }
    public WebElement getSearchIcon(){
        return searchIcon;
    }



}
