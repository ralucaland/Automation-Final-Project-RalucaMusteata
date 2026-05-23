package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPageOrangeHRM extends BasePageOrangeHRM {

    // Locator pentru titlul paginii PIM
    private By pimTitle =
            By.xpath("//h6[text()='PIM']");

    // Locator pentru butonul Add Employee
    private By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    // Locator pentru câmpul Employee Name din pagina PIM
    private By employeeNameInput =
            By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");

    // Locator pentru prima opțiune din autocomplete
    private By firstAutocompleteOption =
            By.xpath("//div[@role='listbox']//span");

    // Locator pentru butonul Search
    private By searchButton =
            By.xpath("//button[@type='submit']");

    // Locator pentru rezultatul căutării după numele Doru
    private By employeeNameResult =
            By.xpath("//div[@role='table']//div[contains(text(),'Doru')]");

    // Locator pentru câmpul Employee Id
    private By employeeIdInput =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");

    // Locator pentru mesajul afișat când nu există rezultate
    private By noRecordsMessage =
            By.xpath("//span[text()='No Records Found']");

    public PimPageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    // Returnează titlul paginii PIM
    public String getPimTitle() {
        return getText(pimTitle);
    }

    // Face click pe Add Employee
    public void clickAddEmployee() {
        click(addEmployeeButton);
    }

    // Introduce numele angajatului în câmpul Employee Name
    public void enterEmployeeName(String employeeName) {
        type(employeeNameInput, employeeName);
    }

    // Selectează prima opțiune din lista autocomplete
    public void selectFirstEmployeeFromAutocomplete() {
        click(firstAutocompleteOption);
    }

    // Face click pe butonul Search
    public void clickSearch() {
        click(searchButton);
    }

    // Returnează numele angajatului afișat în rezultatele căutării
    public String getEmployeeNameResult() {
        return getText(employeeNameResult);
    }

    // Introduce un Employee Id în câmpul Employee Id
    public void enterEmployeeId(String employeeId) {
        type(employeeIdInput, employeeId);
    }

    // Returnează mesajul No Records Found
    public String getNoRecordsMessage() {
        return getText(noRecordsMessage);
    }
}