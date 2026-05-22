package tests;

import API.data.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LoginPageOrangeHRM;
import pages.PimPageOrangeHRM;

public class SearchDoruTest extends BaseTests {

    @Test
    public void searchDoru() {

        System.out.println("TEST 1: Search existing employee Doru Labradoru");

        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        PimPageOrangeHRM pimPage =
                new PimPageOrangeHRM(driver);

        loginPage.openLoginPage();

        loginPage.enterUsername(Data.VALID_USERNAME);
        loginPage.enterPassword(Data.VALID_PASSWORD);
        loginPage.clickLogin();

        dashboardPage.clickPimMenu();

        pimPage.enterEmployeeName(Data.EMPLOYEE_FULL_NAME);
        pimPage.selectFirstEmployeeFromAutocomplete();
        pimPage.clickSearch();

        String result =
                pimPage.getEmployeeNameResult();

        System.out.println("Employee found: " + result);

        Assert.assertTrue(
                result.contains(Data.EMPLOYEE_FIRST_NAME),
                "Expected employee first name was not found"
        );

        System.out.println("TEST PASSED: Existing employee was found");
    }

    @Test
    public void searchByFirstNameOnlyTest() {

        System.out.println("TEST 2: Search employee by first name only");

        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        PimPageOrangeHRM pimPage =
                new PimPageOrangeHRM(driver);

        loginPage.openLoginPage();

        loginPage.enterUsername(Data.VALID_USERNAME);
        loginPage.enterPassword(Data.VALID_PASSWORD);
        loginPage.clickLogin();

        dashboardPage.clickPimMenu();

        pimPage.enterEmployeeName(Data.EMPLOYEE_FIRST_NAME);
        pimPage.clickSearch();

        String result =
                pimPage.getEmployeeNameResult();

        System.out.println("Employee found: " + result);

        Assert.assertTrue(
                result.contains(Data.EMPLOYEE_FIRST_NAME),
                "Expected employee first name was not found in result list"
        );

        System.out.println("TEST PASSED: Employee was found by first name");
    }

    @Test
    public void searchNonExistingEmployeeTest() {

        System.out.println("TEST 3: Search non-existing employee");

        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        PimPageOrangeHRM pimPage =
                new PimPageOrangeHRM(driver);

        loginPage.openLoginPage();

        loginPage.enterUsername(Data.VALID_USERNAME);
        loginPage.enterPassword(Data.VALID_PASSWORD);
        loginPage.clickLogin();

        dashboardPage.clickPimMenu();

        pimPage.enterEmployeeName("Ana NuExista");
        pimPage.clickSearch();

        String message =
                pimPage.getNoRecordsMessage();

        System.out.println("Search message: " + message);

        Assert.assertEquals(
                message,
                "No Records Found"
        );

        System.out.println("TEST PASSED: No records found message is displayed");
    }
}