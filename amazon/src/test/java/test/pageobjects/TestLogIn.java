package test.pageobjects;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LogIn;

public class TestLogIn extends BrowserDriver {
    LogIn objectsOfLogin = null;


        @Test
        public void loginTest(){
            objectsOfLogin.login();
        }


        @Test
        public void emailTest(){
            //passing email as a parameter
            objectsOfLogin.email("afsaegdsae@hotmail.com");
        }

        @Test
        public void passwordTest(){
            objectsOfLogin.password("NYEEEE");

        }

        @Test
        public void signInButtonTest(){
            objectsOfLogin.pressSigninButton();
        }


    @Test (groups = "main")

    public void completeLoginTest() throws InterruptedException {
        objectsOfLogin.signInComplete("gafgbgrefw@hotmail.ocm","34567890fghjk");
    }

    @BeforeMethod
    public void initializationOfObject(){

        objectsOfLogin = PageFactory.initElements(driver,LogIn.class);
    }



}
