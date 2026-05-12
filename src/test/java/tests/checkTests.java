package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LoginPageOrangeHRM;

public class checkTests extends baseTests {
    @Test
    public void checkOpenOrangeHRM() {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("orangehrmlive"));
    }

    @Test
    public void checkLoginFlow() {

        LoginPageOrangeHRM loginPage = new LoginPageOrangeHRM(driver);
        DashboardPageOrangeHRM dashboardPage = new DashboardPageOrangeHRM(driver);

        loginPage.openLoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        String dashboardTitle = dashboardPage.getDashboardTitle();

        System.out.println("Dashboard title: " + dashboardTitle);

        Assert.assertEquals(dashboardTitle, "Dashboard");
    }
}

