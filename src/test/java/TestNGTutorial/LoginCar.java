package TestNGTutorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginCar {

    @Parameters({"URL", "APIKey/username"})
    @Test
    public void WebLoginCarLoan(String urlname, String key) {
        //selenim
        System.out.println("WebLoginCarLoan");
        System.out.println(urlname);
        System.out.println(key);
    }

    @Test(dataProvider = "getData")
    public void MobileLoginCarLoan(String username, String password) {
        //appium
        System.out.println("MobileLoginCarLoan");
        System.out.println(username);
        System.out.println(password);
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

    @DataProvider
    public Object[][] getData() {
        //1st combination - username password - good credit history= row
        //2nd - username password  - no credit history
        //3rd - fraudulent credit history
        Object[][] data = new Object[3][2];
        //1st set
        data[0][0] = "firstsetusername";
        data[0][1] = "firstpassword";
        //columns in the row are nothing but values for that particular combination(row)

        //2nd set
        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";

        //3rd set
        data[2][0] = "thirdsetusername";
        data[2][1] = "thirdpassword";

        return data;
    }

}