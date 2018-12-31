package test.pageobjects;

import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.ShoppingCart;

public class TestShoppingCart extends BrowserDriver {

    ShoppingCart objectOfShoppingCart = null;
    String macBook = "MacBook Air";


    @BeforeMethod
    public void initializationOfObject(){
        objectOfShoppingCart = PageFactory.initElements(driver,ShoppingCart.class);
    }
    @Test (priority = 1)
    public void searchBoxTest(){
        objectOfShoppingCart.productsearch(macBook);
    // A test is not a test without ..........Verification

        Assert.assertEquals(objectOfShoppingCart.getVerifyComputers(),"Computers & Accessories"); //need to change computer
        ApplicationPageBase.testPassed("searchBox");
    }


    @Test (priority = 2)
    public void selectLaptopTest(){
        objectOfShoppingCart.productsearch(macBook);

        objectOfShoppingCart.clickamazonChoice();
        Assert.assertEquals(objectOfShoppingCart.checkAmazonChoice(),"Amazon's");
        ApplicationPageBase.testPassed("selectLaptopTest");
    }

    @Test (priority = 3)
    public void addToCartTest(){
        objectOfShoppingCart.productsearch(macBook);

        objectOfShoppingCart.clickamazonChoice();

        objectOfShoppingCart.clickAddToCart();

        Assert.assertTrue(objectOfShoppingCart.checkAddToCartButton());
        ApplicationPageBase.testPassed("addToCart");
    }




}
