package page.objects;

import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static application.page.base.ApplicationPageBase.*;


public class LogInPage extends BrowserDriver {
    @FindBy(xpath = "//*[@id='nav-link-accountList']/span")
    private WebElement signIn;

    @FindBy (xpath = "//*[@tabindex='1']")
    WebElement emailBox;

    @FindBy (id="ap_password")
    private WebElement passwordBox;

    @FindBy(xpath="//*[@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(className = "a-alert-heading")
    private WebElement siginFailureAlert;
    String nameOfElemenet = null;

    @FindBy(id = "auth-captcha-guess")
    private WebElement capchafail;


    public LogInPage getlogin(){

        clickButton(signIn,"From Home Page");

        return new LogInPage();
    }






    public LogInPage login(String email, String password){


//                getlogin();


                sendKeys(emailBox, "email Adress", email);


                sendKeys(passwordBox, "password", password);



        if(siginFailureAlert.isDisplayed())

        {    sendKeys(capchafail,"Enter capcha values","5432222");
            clickButton(signInButton, "click sign In Buton");

        }

        else{
            clickButton(signInButton, "click sign In Buton");

        }


        return new LogInPage();
    }



    public boolean getErrorMeassage(){


        boolean displayed =siginFailureAlert.isDisplayed();

        testPassed("signinFailure is displayed");

        return displayed;

    }





}
