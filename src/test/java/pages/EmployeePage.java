package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BasePageOrangeHRM {

    // Locator pentru câmpul First Name din formularul Add Employee
    private By firstNameInput =
            By.name("firstName");

    // Locator pentru câmpul Last Name din formularul Add Employee
    private By lastNameInput =
            By.name("lastName");

    // Locator pentru butonul Save
    private By saveButton =
            By.cssSelector("button[type='submit']");

    // Constructorul primește driverul din test și îl trimite către BasePageOrangeHRM
    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    // Completează câmpul First Name cu prenumele angajatului
    public void enterFirstName(String firstName) {
        type(firstNameInput, firstName);
    }

    // Completează câmpul Last Name cu numele angajatului
    public void enterLastName(String lastName) {
        type(lastNameInput, lastName);
    }

    // Apasă butonul Save după ce așteaptă ca loaderul paginii să dispară
    public void clickSave() {
        waitForPageLoaderToDisappear();
        click(saveButton);
    }

    // Returnează valoarea salvată în câmpul First Name
    // Pentru input-uri folosim getAttribute("value"), nu getText()
    public String getFirstNameValue() {
        return waitForVisible(firstNameInput)
                .getAttribute("value");
    }

    // Returnează valoarea salvată în câmpul Last Name
    // Pentru input-uri folosim getAttribute("value"), nu getText()
    public String getLastNameValue() {
        return waitForVisible(lastNameInput)
                .getAttribute("value");
    }
}