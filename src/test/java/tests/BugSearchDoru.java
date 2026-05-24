package tests;

import data.UIData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LeavePageOrangeHRM;
import pages.LoginPageOrangeHRM;

public class BugSearchDoru extends BaseTests {

    @Test
    public void assignLeaveToEmployeeTest() {

        System.out.println("UI-06: Adăugare concediu pentru angajat");

        System.out.println("Pasul 1: Creăm obiectele pentru pagini");
        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        LeavePageOrangeHRM leavePage =
                new LeavePageOrangeHRM(driver);

        System.out.println("Pasul 2: Deschidem pagina de login OrangeHRM");
        loginPage.openLoginPage();

        System.out.println("Pasul 3: Ne autentificăm cu username și parolă valide");
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);
        loginPage.clickLogin();

        System.out.println("Pasul 4: Deschidem meniul Leave");
        dashboardPage.clickLeaveMenu();

        System.out.println("Pasul 5: Deschidem pagina Assign Leave");
        leavePage.clickAssignLeave();

        System.out.println("Pasul 6: Introducem numele angajatului");
        leavePage.enterEmployeeName(UIData.EMPLOYEE_FULL_NAME);

        System.out.println("Pasul 7: Selectăm angajatul din lista autocomplete");
        leavePage.selectFirstEmployeeFromAutocomplete();

        System.out.println("Pasul 8: Deschidem dropdown-ul Leave Type");
        leavePage.openLeaveTypeDropdown();

        System.out.println("Pasul 9: Selectăm primul tip de concediu disponibil");
        leavePage.selectFirstLeaveTypeOption();

        System.out.println("Pasul 10: Completăm data de început pentru concediu");
        leavePage.enterFromDate(UIData.LEAVE_FROM_DATE);

        System.out.println("Pasul 11: Completăm data de sfârșit pentru concediu");
        leavePage.enterToDate(UIData.LEAVE_TO_DATE);

        System.out.println("Pasul 12: Apăsăm butonul Assign");
        leavePage.clickAssign();

        System.out.println("Pasul 13: Confirmăm popup-ul de concediu insuficient, dacă apare");
        leavePage.confirmAssignmentPopupIfDisplayed();

        System.out.println("Pasul 14: Verificăm mesajul de succes");
        String actualMessage =
                leavePage.getToastMessage();

        System.out.println("Mesaj afișat: " + actualMessage);

        Assert.assertTrue(
                actualMessage.contains(UIData.SUCCESS_MESSAGE)
                        || actualMessage.contains("Success")
                        || actualMessage.contains("Successfully"),
                "Mesajul de succes nu a fost afișat. Mesaj real: " + actualMessage
        );

        System.out.println("TEST TRECUT: Concediul a fost asignat cu succes angajatului.");
    }
}