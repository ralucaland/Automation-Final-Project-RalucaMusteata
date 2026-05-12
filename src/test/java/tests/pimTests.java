package tests;

<<<<<<< HEAD
public class pimTests {
=======
import API.data.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LoginPageOrangeHRM;
import pages.PimPageOrangeHRM;

public class pimTests extends baseTests {

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
    loginPage.enterUsername(Data.VALID_USERNAME);
    loginPage.enterPassword(Data.VALID_PASSWORD);
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
            Data.PIM_TITLE
    );

    System.out.println("Test PASSED: PIM page is displayed");
    }
>>>>>>> d2b0f98 (push)
}
