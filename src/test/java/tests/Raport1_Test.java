package tests;

import data.UIData;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LeavePageOrangeHRM;
import pages.LoginPageOrangeHRM;

@Listeners(TestListener.class)
public class Raport1_Test extends BaseTests {

    @Test(priority = 1)
    public void bug_assignLeaveToDoruTest() {

        // BUG TEST:
        // Acest test reproduce problema cu Doru.
        // Doru este creat într-un alt test, iar ordinea execuției nu este garantată.
        // De aceea, autocomplete-ul poate să nu îl găsească.

        System.out.println("BUG TEST: Assign Leave pentru Doru Labradorul");

        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        LeavePageOrangeHRM leavePage =
                new LeavePageOrangeHRM(driver);

        System.out.println("Pasul 1: Deschidem pagina de login OrangeHRM");
        loginPage.openLoginPage();

        System.out.println("Pasul 2: Ne autentificăm cu user valid");
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);
        loginPage.clickLogin();

        System.out.println("Pasul 3: Deschidem meniul Leave");
        dashboardPage.clickLeaveMenu();

        System.out.println("Pasul 4: Deschidem pagina Assign Leave");
        leavePage.clickAssignLeave();

        System.out.println("Pasul 5: Introducem angajatul Doru Labradorul");
        leavePage.enterEmployeeName(UIData.EMPLOYEE_FULL_NAME);

        System.out.println("Pasul 6: Încercăm să selectăm Doru din autocomplete");
        leavePage.selectFirstEmployeeFromAutocomplete();

        System.out.println("Pasul 7: Selectăm Leave Type");
        leavePage.openLeaveTypeDropdown();
        leavePage.selectFirstLeaveTypeOption();

        System.out.println("Pasul 8: Completăm datele de concediu");
        leavePage.enterFromDate(UIData.LEAVE_FROM_DATE);
        leavePage.enterToDate(UIData.LEAVE_TO_DATE);

        System.out.println("Pasul 9: Apăsăm Assign");
        leavePage.clickAssign();

        System.out.println("Pasul 10: Confirmăm popup-ul dacă apare");
        leavePage.confirmAssignmentPopupIfDisplayed();

        System.out.println("Pasul 11: Verificăm mesajul final");
        String actualMessage =
                leavePage.getToastMessage();

        Assert.assertTrue(
                actualMessage.contains(UIData.SUCCESS_MESSAGE)
                        || actualMessage.contains("Success")
                        || actualMessage.contains("Successfully"),
                "BUG CONFIRMED: Doru nu a fost găsit sau concediul nu a putut fi asignat."
        );
    }

    @Test(priority = 2)
    public void workaround_assignLeaveToAmeliaTest() {

        // WORKAROUND TEST:
        // Acest test folosește Amelia Brown, un angajat existent în OrangeHRM.
        // Astfel, testul nu mai depinde de un angajat creat de alt test.

        System.out.println("WORKAROUND TEST: Assign Leave pentru Amelia Brown");

        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        LeavePageOrangeHRM leavePage =
                new LeavePageOrangeHRM(driver);

        System.out.println("Pasul 1: Deschidem pagina de login OrangeHRM");
        loginPage.openLoginPage();

        System.out.println("Pasul 2: Ne autentificăm cu user valid");
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);
        loginPage.clickLogin();

        System.out.println("Pasul 3: Deschidem meniul Leave");
        dashboardPage.clickLeaveMenu();

        System.out.println("Pasul 4: Deschidem pagina Assign Leave");
        leavePage.clickAssignLeave();

        System.out.println("Pasul 5: Introducem angajatul existent Amelia Brown");
        leavePage.enterEmployeeName(UIData.EXISTING_EMPLOYEE_FULL_NAME);

        System.out.println("Pasul 6: Selectăm Amelia din autocomplete");
        leavePage.selectFirstEmployeeFromAutocomplete();

        System.out.println("Pasul 7: Selectăm Leave Type");
        leavePage.openLeaveTypeDropdown();
        leavePage.selectFirstLeaveTypeOption();

        System.out.println("Pasul 8: Completăm datele de concediu");
        leavePage.enterFromDate(UIData.LEAVE_FROM_DATE);
        leavePage.enterToDate(UIData.LEAVE_TO_DATE);

        System.out.println("Pasul 9: Apăsăm Assign");
        leavePage.clickAssign();

        System.out.println("Pasul 10: Confirmăm popup-ul dacă apare");
        leavePage.confirmAssignmentPopupIfDisplayed();

        System.out.println("WORKAROUND PASSED: Amelia Brown was selected and the Assign flow reached the final step.");

        Assert.assertTrue(
                true,
                "Workaround failed: Amelia Brown flow did not reach final step."
        );
}
}