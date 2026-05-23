package tests;

import data.UIData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LoginPageOrangeHRM;

public class LoginTests extends BaseTests {

    @Test
    public void validLoginTest() {
//Create LoginPage object
        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);
//Create DashboardPage object
        DashboardPageOrangeHRM dashboardPage =
        new DashboardPageOrangeHRM(driver);
//Open OrangeHRM login page
        loginPage.openLoginPage();
//Enter valid credentiales
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);
//Enter valid password
        loginPage.clickLogin();
//Read Dashboard title
        String title =
                dashboardPage.getDashboardTitle();
//Validate Dashboard title
        Assert.assertEquals(
                title,
                UIData.DASHBOARD_TITLE
        );
        System.out.println("Test PASSED: Valid login successful");
    }

    @Test
    public void invalidLoginTest() {
        System.out.println("Step 1: Create LoginPage object");
        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        System.out.println("Step 2: Open OrangeHRM login page");
        loginPage.openLoginPage();

        System.out.println("Step 3: Enter invalid username");
        loginPage.enterUsername(UIData.INVALID_USERNAME);

        System.out.println("Step 4: Enter invalid password");
        loginPage.enterPassword(UIData.INVALID_PASSWORD);

        System.out.println("Step 5: Click Login button");
        loginPage.clickLogin();

        System.out.println("Step 6: Read error message");
        String error =
                loginPage.getErrorMessage();
        System.out.println("Actual error message: " + error);

        System.out.println("Step 7: Validate error message");
        Assert.assertEquals(
                error,
                UIData.INVALID_LOGIN_MESSAGE
        );
    }
}


