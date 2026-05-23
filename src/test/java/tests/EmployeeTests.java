package tests;

import data.UIData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.EmployeePage;
import pages.LoginPageOrangeHRM;
import pages.PimPageOrangeHRM;

public class EmployeeTests extends BaseTests {

    @Test
    public void EmployeeTest() {

        System.out.println("Step 1: Create page objects");

        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        PimPageOrangeHRM pimPage =
                new PimPageOrangeHRM(driver);

        EmployeePage employeePage =
                new EmployeePage(driver);

        System.out.println("Step 2: Open OrangeHRM login page");
        loginPage.openLoginPage();

        System.out.println("Step 3: Login with valid credentials");
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);
        loginPage.clickLogin();

        System.out.println("Step 4: Open PIM page");
        dashboardPage.clickPimMenu();

        System.out.println("Step 5: Click Add Employee");
        pimPage.clickAddEmployee();

        System.out.println("Step 6: Enter employee first name");
        employeePage.enterFirstName(UIData.EMPLOYEE_FIRST_NAME);

        System.out.println("Step 7: Enter employee last name");
        employeePage.enterLastName(UIData.EMPLOYEE_LAST_NAME);

        System.out.println("Step 8: Click Save");
        employeePage.clickSave();

        System.out.println("Step 9: Read saved employee first name");
        String firstName =
                employeePage.getFirstNameValue();

        System.out.println("Step 10: Read saved employee last name");
        String lastName =
                employeePage.getLastNameValue();

        String fullName =
                firstName + " " + lastName;

        System.out.println(
                "New employee created: " + fullName
        );

        Assert.assertEquals(
                fullName,
                UIData.EMPLOYEE_FIRST_NAME + " " + UIData.EMPLOYEE_LAST_NAME
        );

        System.out.println("Test PASSED: Add employee flow executed successfully");

    }
}


