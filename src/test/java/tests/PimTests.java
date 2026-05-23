package tests;

import data.UIData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LoginPageOrangeHRM;
import pages.PimPageOrangeHRM;

public class PimTests extends BaseTests {

@Test
public void navigateToPimPageTest() {

    System.out.println("Step 1: Create LoginPage object");
    LoginPageOrangeHRM loginPage =
            new LoginPageOrangeHRM(driver);

    System.out.println("Step 2: Create DashboardPage object");
    DashboardPageOrangeHRM dashboardPage =
            new DashboardPageOrangeHRM(driver);

    System.out.println("Step 3: Create PimPage object");
    PimPageOrangeHRM pimPage =
            new PimPageOrangeHRM(driver);

    System.out.println("Step 4: Open OrangeHRM login page");
    loginPage.openLoginPage();

    System.out.println("Step 5: Login with valid credentials");
    loginPage.enterUsername(UIData.VALID_USERNAME);
    loginPage.enterPassword(UIData.VALID_PASSWORD);
    loginPage.clickLogin();

    System.out.println("Step 6: Click PIM menu");
    dashboardPage.clickPimMenu();

    System.out.println("Step 7: Read PIM page title");
    String title =
            pimPage.getPimTitle();

    System.out.println("Actual PIM title: " + title);

    System.out.println("Step 8: Validate PIM page title");
    Assert.assertEquals(
            title,
            UIData.PIM_TITLE
    );

    System.out.println("Test PASSED: PIM page is displayed");
    }

}
