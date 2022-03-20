package TestNGTutorial;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginCar {

    @Parameters({"URL"})
    @Test
    public void WebLoginCarLoan(String urlname) {
        //selenim
        System.out.println("WebLoginCarLoan");
        System.out.println(urlname);
    }

    @Test
    public void MobileLoginCarLoan() {
        //appium
        System.out.println("MobileLoginCarLoan");
    }

    @Test(timeOut = 4000)
    public void MobileSigninCarLoan() {
        //appium
        System.out.println("MobileSigninCarLoan");
    }

    @Test(enabled = false)
    public void MobileSignoutCarLoan() {
        //appium
        System.out.println("MobileSignoutCarLoan");
    }

    @Test(dependsOnMethods = {"WebLoginCarLoan"})
    public void LoginAPICarLoan() {
        //rest API automation
        System.out.println("LoginAPICarLoan");
    }

}