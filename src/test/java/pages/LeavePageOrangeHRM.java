package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePageOrangeHRM extends BasePageOrangeHRM {

    // Locator pentru tab-ul Assign Leave
    private By assignLeaveMenu =
            By.xpath("//a[text()='Assign Leave']");

    // Locator pentru câmpul Employee Name
    private By employeeNameInput =
            By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");

    // Locator pentru prima opțiune din autocomplete
    private By firstAutocompleteOption =
            By.xpath("//div[@role='listbox']//span");

    // Locator pentru dropdown-ul Leave Type
    private By leaveTypeDropdown =
            By.xpath("//label[text()='Leave Type']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");

    // Locator pentru prima opțiune disponibilă din dropdown-ul Leave Type
    private By firstLeaveTypeOption =
            By.xpath("//div[@role='listbox']//span");

    // Locator pentru câmpul From Date
    private By fromDateInput =
            By.xpath("//label[text()='From Date']/../following-sibling::div//input");

    // Locator pentru câmpul To Date
    private By toDateInput =
            By.xpath("//label[text()='To Date']/../following-sibling::div//input");

    // Locator pentru butonul Assign
    private By assignButton =
            By.xpath("//button[@type='submit']");

    // Locator pentru butonul Ok din popup-ul de concediu insuficient
    private By confirmButton =
            By.xpath("//button[normalize-space()='Ok']");

    // Locator pentru mesajul toast afișat după asignare/salvare
    private By successMessage =
            By.cssSelector(".oxd-toast-content");

    public LeavePageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    // Deschide tab-ul Assign Leave
    public void clickAssignLeave() {
        click(assignLeaveMenu);
    }

    // Introduce numele angajatului
    public void enterEmployeeName(String employeeName) {
        type(employeeNameInput, employeeName);
    }

    // Selectează primul angajat din lista autocomplete
    public void selectFirstEmployeeFromAutocomplete() {
        click(firstAutocompleteOption);
    }

    // Deschide dropdown-ul Leave Type
    public void openLeaveTypeDropdown() {
        click(leaveTypeDropdown);
    }

    // Selectează prima opțiune disponibilă din Leave Type
    public void selectFirstLeaveTypeOption() {
        click(firstLeaveTypeOption);
    }

    // Completează From Date fără să dubleze valoarea existentă
    public void enterFromDate(String fromDate) {
        clearAndType(fromDateInput, fromDate);
    }

    // Completează To Date fără să dubleze valoarea existentă
    public void enterToDate(String toDate) {
        clearAndType(toDateInput, toDate);
    }

    // Apasă butonul Assign
    public void clickAssign() {
        waitForPageLoaderToDisappear();
        click(assignButton);
    }

    // Apasă Ok în popup-ul de confirmare
    public void confirmAssignmentPopup() {
        click(confirmButton);
    }

    // Returnează mesajul complet din toast
    public String getSuccessMessage() {
        return getText(successMessage);
    }
}