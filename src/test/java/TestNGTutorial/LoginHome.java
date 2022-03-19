package TestNGTutorial;

import org.testng.annotations.*;

public class LoginHome {

    @Test
    public void WebLoginHomeLoan() {
        //selenim
        System.out.println("WebLoginHomeLoan");
    }

    @Test
    public void MobileLoginHomeLoan() {
        //appium
        System.out.println("MobileLoginHomeLoan");
    }

    @Test
    public void LoginAPIHomeLoan() {
        //rest API automation
        System.out.println("LoginAPIHomeLoan");
    }


    @BeforeTest
    public void Prerequisite() {
        System.out.println("I will execute first");
    }

    @AfterTest
    public void LastExecution() {
        System.out.println("I will execute last");
    }

    @BeforeSuite
    public void Bsuite() {
        //appium
        System.out.println("I am no 1");
    }

    @AfterSuite
    public void Asuite() {
        //appium
        System.out.println("I am no 1 from last");
    }

    @BeforeMethod
    public void BeforeEvery() {
        System.out.println("I will execute before every test method in LoginHome class");
    }

    @AfterMethod
    public void AfterEvery() {
        System.out.println("I will execute after every test method in LoginHome class");
    }

}