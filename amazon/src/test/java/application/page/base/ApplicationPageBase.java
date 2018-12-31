package application.page.base;

import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import reporting.TestLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPageBase extends BrowserDriver {


    //Common method for inserting data into searchBox
    //making static method so we dont need to create object



    public static void searchProduct(WebElement webElementName,String productName){


        TestLogger.log("sending Keys to SearchBox");
        webElementName.sendKeys(productName);
        TestLogger.log("Keys Received");
    }

    public static void clickButton(WebElement webElementName,String nameOfEleement){
       beforeClickLog(nameOfEleement);
        webElementName.click();
        afterClicking(nameOfEleement);
    }

    public static String getText(WebElement webElementName){
        TestLogger.log("getting : "+webElementName);
        return webElementName.getText();

    }

    public static void beforeClickLog(String nameOfElement){

        TestLogger.log("Clicking :" +nameOfElement);
    }

    public static void afterClicking(String nameOfElement){

        TestLogger.log("Clicked :"+nameOfElement);
    }



    public static void testPassed(String nameOfElement){
        System.out.println("Confirming Passed :"+ nameOfElement);
    }

    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        File filepath = new File(System.getProperty("user.dir") +  "/src/test/resources/secret.properties");
        InputStream ism = new FileInputStream(filepath.getAbsoluteFile());
        prop.load(ism);
        ism.close();
        return prop;
    }


    public static String getText(WebElement webElement, String webElementName){

        TestLogger.log("Getting Text from " + webElementName);
        String actualText =  webElement.getText();
        TestLogger.log("Actual text: " + actualText);

        return actualText;

    }


    //for dataProvider method


    public static void sendKeys(WebElement webElement,String nameOfElement, String keys){

        webElement.clear();
        TestLogger.log("Sending "+keys+" to "+nameOfElement);
        webElement.sendKeys(keys);
        TestLogger.log("enter "+keys+" to "+ nameOfElement);
    }

}
