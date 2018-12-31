package test.pageobjects;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.FooterTopLinks;


public class TestFooterTopLinks extends BrowserDriver{

    FooterTopLinks objectOfFooterTopLinks = null;

    @BeforeMethod
    public void initializationOfObjects(){
        objectOfFooterTopLinks = PageFactory.initElements(driver,FooterTopLinks.class);
        driver.manage().window().maximize();
    }

    @Test
    public void amazonPaymentProductsTest(){
        objectOfFooterTopLinks.amazonPaymentProducts();
    }



    @Test (priority = 5)
    public void countryTabTest() throws InterruptedException {
        objectOfFooterTopLinks.countryTab();
    }


    @Test
    public void getToKnowUsTest(){
        objectOfFooterTopLinks.getToKnowUs();

    }


    @Test
    public void letUsHelpYouTest(){
        objectOfFooterTopLinks.letUsHelpYou();
    }

    @Test
    public void makeMoneyWithUsTest(){
        objectOfFooterTopLinks.makeMoneyWithUs();
    }


    @Test
    public void laguageTabTest() throws InterruptedException {
        objectOfFooterTopLinks.laguageTab();
    }





}
