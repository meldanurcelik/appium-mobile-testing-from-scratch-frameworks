package TestNGTutorial;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginHome {

    @Parameters({"URL"})
    @Test(groups = {"Smoke"})
    public void WebLoginHomeLoan(String urlname) {
        //selenim
        System.out.println("WebLoginHomeLoan");
        System.out.println(urlname);
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
        Assert.assertTrue(false);
    }


    @BeforeClass
    public void BeforeClass() {
        System.out.println("before executing any methods in the class");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("after executing any methods in the class");
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
        System.out.println("I am no 1");
    }

    @AfterSuite
    public void Asuite() {
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