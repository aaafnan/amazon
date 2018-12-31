package page.objects;

import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static application.page.base.ApplicationPageBase.getText;

public class LogIn extends BrowserDriver {

    @FindBy(xpath = "//*[@id='nav-link-accountList']/span")
    private WebElement login;

    @FindBy (xpath = "//*[@tabindex='1']")
    WebElement email;

    @FindBy (id="ap_password")
    private WebElement password;

    @FindBy(xpath="//input[@class='a-button-input']")
    private WebElement signInButton;

    @FindBy(className = "a-alert-heading")
    private WebElement siginFailureAlert;
    String nameOfElemenet = null;



    public void login(){
         nameOfElemenet = "Log In";
        String forTest =  login.getText();
        ApplicationPageBase.beforeClickLog(nameOfElemenet);
        login.click();
        ApplicationPageBase.afterClicking(nameOfElemenet);
        Assert.assertEquals("Hello. Sign in",forTest);

    }


    public void email(String emailinput)  {
        nameOfElemenet = "Email";
        ApplicationPageBase.beforeClickLog(nameOfElemenet);
        login.click();
        ApplicationPageBase.afterClicking(nameOfElemenet);

        email.sendKeys(emailinput);

        String adreesConfirm = email.getText();
        Assert.assertTrue(email.isDisplayed());
        ApplicationPageBase.testPassed("Email");
    }

    public void password(String enterpassword){
       nameOfElemenet = "Password";
        ApplicationPageBase.beforeClickLog(nameOfElemenet);
        login.click();
        ApplicationPageBase.afterClicking(nameOfElemenet);
        password.sendKeys(enterpassword);
        boolean passwordenter = password.isDisplayed();
        Assert.assertTrue(passwordenter);
        ApplicationPageBase.testPassed(nameOfElemenet);

    }

    public void pressSigninButton(){
        nameOfElemenet = "Sign In Button";
        ApplicationPageBase.beforeClickLog(nameOfElemenet);
        login.click();
        ApplicationPageBase.afterClicking(nameOfElemenet);
       Assert.assertTrue(signInButton.isEnabled());
        signInButton.submit();


    }


    public void signInComplete(String emailaddress, String enterpassword) {

        //ApplicationPageBase.beforeClickLog(nameOfElemenet);
        login.click();
        //ApplicationPageBase.afterClicking(nameOfElemenet);
        email.sendKeys(emailaddress);
        password.sendKeys(enterpassword);
        signInButton.submit();

/*
        Thread.sleep(3000);
        Assert.assertTrue(siginFailureAlert.isDisplayed());

        ApplicationPageBase.testPassed(nameOfElemenet);*/

    }

    public LogIn getloginPage(){
        login.click();
        return  new LogIn();
    }
    public String getErroMessage(){

        String actualText = getText(siginFailureAlert,"errorMessage");

        return actualText;
    }

}
