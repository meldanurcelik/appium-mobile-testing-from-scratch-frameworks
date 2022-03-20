package TestNGTutorial;

import org.testng.annotations.Test;

public class LoginCar {

    @Test
    public void WebLoginCarLoan() {
        //selenim
        System.out.println("WebLoginCarLoan");
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