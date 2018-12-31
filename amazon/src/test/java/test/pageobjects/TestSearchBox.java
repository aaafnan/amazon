package test.pageobjects;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LogIn;
import page.objects.SearchBox;

public class TestSearchBox extends BrowserDriver {
    SearchBox objectOfSearchBox = null;
    LogIn objectsOfLogin = null;
    @BeforeMethod
    public void initializationOfObjects(){
        objectOfSearchBox = PageFactory.initElements(driver,SearchBox.class);
        objectsOfLogin = PageFactory.initElements(driver,LogIn.class);

    }

    @Test
    public void searchBoxTest(){

        objectOfSearchBox.dropdownselection();

    }

    @Test
    public void dropdownListTest(){
        objectOfSearchBox.listSearchBox();
    }

    @Test
    public void searchBoxTextTest(){

        objectOfSearchBox.searchTextBox("Whatever");
    }

    @Test (groups = "main")
    public void searchIconTest() throws InterruptedException {

        objectOfSearchBox.searchIcon();
    }

}
