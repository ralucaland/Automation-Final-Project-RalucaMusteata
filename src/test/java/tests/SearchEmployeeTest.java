package tests;

import data.UIData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPageOrangeHRM;
import pages.LoginPageOrangeHRM;
import pages.PimPageOrangeHRM;

public class SearchEmployeeTest extends BaseTests {

    @Test
    public void searchExistingEmployeeTest() {

        // Scopul testului:
        // Verificăm că un angajat existent în OrangeHRM poate fi căutat
        // folosind câmpul Employee Name din modulul PIM.
        // Pentru stabilitate, folosim un angajat deja existent: Amelia Brown.

        System.out.println("TEST 1: Căutare angajat existent - Amelia Brown");

        // Creăm obiectele pentru paginile folosite în test.
        // Aceste obiecte ne permit să folosim metodele definite în Page Object Model.
        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        PimPageOrangeHRM pimPage =
                new PimPageOrangeHRM(driver);

        // Deschidem pagina de login OrangeHRM.
        loginPage.openLoginPage();

        // Introducem credențiale valide.
        // Acest pas este necesar deoarece modulul PIM este accesibil doar după autentificare.
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);

        // Apăsăm butonul Login.
        loginPage.clickLogin();

        // Accesăm meniul PIM din dashboard.
        // PIM este modulul unde se gestionează angajații.
        dashboardPage.clickPimMenu();

        // Introducem numele angajatului existent în câmpul Employee Name.
        // Folosim date stabile din UIData, nu un angajat creat într-un alt test.
        pimPage.enterEmployeeName(UIData.EXISTING_EMPLOYEE_FULL_NAME);

        // Selectăm prima opțiune afișată în autocomplete.
        // Acest pas confirmă că aplicația a găsit angajatul introdus.
        pimPage.selectFirstEmployeeFromAutocomplete();

        // Apăsăm butonul Search pentru a executa căutarea.
        pimPage.clickSearch();

        // Citim rezultatul afișat în tabelul de rezultate.
        // Metoda primește numele căutat, ca să nu avem locator hardcodat pe Doru.
        String result =
                pimPage.getEmployeeNameResult(UIData.EXISTING_EMPLOYEE_FIRST_NAME);

        System.out.println("Angajat găsit: " + result);

        // Validăm că rezultatul conține prenumele angajatului căutat.
        // Dacă Amelia apare în tabel, considerăm că funcția de căutare merge corect.
        Assert.assertTrue(
                result.contains(UIData.EXISTING_EMPLOYEE_FIRST_NAME),
                "Prenumele angajatului căutat nu a fost găsit în rezultatele afișate."
        );

        System.out.println("TEST TRECUT: Angajatul existent a fost găsit cu succes.");
    }

    @Test
    public void searchByFirstNameOnlyTest() {

        // Scopul testului:
        // Verificăm dacă putem căuta un angajat folosind doar prenumele.
        // Acesta este un caz pozitiv, dar mai puțin exact decât căutarea cu nume complet.

        System.out.println("TEST 2: Căutare angajat după prenume");

        // Creăm obiectele pentru paginile necesare testului.
        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        PimPageOrangeHRM pimPage =
                new PimPageOrangeHRM(driver);

        // Deschidem pagina de login.
        loginPage.openLoginPage();

        // Ne autentificăm cu username și parolă valide.
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);
        loginPage.clickLogin();

        // Deschidem modulul PIM.
        dashboardPage.clickPimMenu();

        // Introducem doar prenumele angajatului.
        // Testăm că aplicația poate găsi rezultate și cu o valoare parțială.
        pimPage.enterEmployeeName(UIData.EXISTING_EMPLOYEE_FIRST_NAME);

        // Apăsăm Search.
        pimPage.clickSearch();

        // Citim rezultatul din tabel.
        String result =
                pimPage.getEmployeeNameResult(UIData.EXISTING_EMPLOYEE_FIRST_NAME);

        System.out.println("Angajat găsit: " + result);

        // Verificăm dacă rezultatul conține prenumele căutat.
        Assert.assertTrue(
                result.contains(UIData.EXISTING_EMPLOYEE_FIRST_NAME),
                "Prenumele angajatului nu a fost găsit în lista de rezultate."
        );

        System.out.println("TEST TRECUT: Angajatul a fost găsit după prenume.");
    }

    @Test
    public void searchNonExistingEmployeeTest() {

        // Scopul testului:
        // Verificăm comportamentul aplicației când se caută un angajat care nu există.
        // Acesta este un test negativ.

        System.out.println("TEST 3: Căutare angajat inexistent");

        // Creăm obiectele pentru paginile necesare.
        LoginPageOrangeHRM loginPage =
                new LoginPageOrangeHRM(driver);

        DashboardPageOrangeHRM dashboardPage =
                new DashboardPageOrangeHRM(driver);

        PimPageOrangeHRM pimPage =
                new PimPageOrangeHRM(driver);

        // Deschidem pagina de login.
        loginPage.openLoginPage();

        // Ne autentificăm cu credențiale valide.
        loginPage.enterUsername(UIData.VALID_USERNAME);
        loginPage.enterPassword(UIData.VALID_PASSWORD);
        loginPage.clickLogin();

        // Deschidem pagina PIM.
        dashboardPage.clickPimMenu();

        // Introducem un nume care nu ar trebui să existe în aplicație.
        // Folosim acest pas pentru a testa mesajul de "No Records Found".
        pimPage.enterEmployeeName("Ana NuExista");

        // Executăm căutarea.
        pimPage.clickSearch();

        // Citim mesajul afișat când nu există rezultate.
        String message =
                pimPage.getNoRecordsMessage();

        System.out.println("Mesaj afișat la căutare: " + message);

        // Validăm că aplicația afișează mesajul corect pentru căutare fără rezultate.
        Assert.assertEquals(
                message,
                "No Records Found"
        );

        System.out.println("TEST TRECUT: Mesajul 'No Records Found' este afișat corect.");
    }
}