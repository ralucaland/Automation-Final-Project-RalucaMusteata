package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeavePageOrangeHRM extends BasePageOrangeHRM {

    // Tab-ul Assign Leave
    private By assignLeaveMenu =
            By.xpath("//a[text()='Assign Leave']");

    // Câmpul Employee Name
    private By employeeNameInput =
            By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");

    // Prima opțiune din autocomplete
    private By firstAutocompleteOption =
            By.xpath("//div[@role='listbox']//span");

    // Dropdown Leave Type
    private By leaveTypeDropdown =
            By.xpath("//label[text()='Leave Type']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");

    // Prima opțiune din dropdown Leave Type
    private By firstLeaveTypeOption =
            By.xpath("//div[@role='listbox']//span");

    // From Date
    private By fromDateInput =
            By.xpath("//label[text()='From Date']/../following-sibling::div//input");

    // To Date
    private By toDateInput =
            By.xpath("//label[text()='To Date']/../following-sibling::div//input");

    // Buton Assign
    private By assignButton =
            By.xpath("//button[@type='submit']");

    // Buton OK din popup, dacă apare
    private By confirmButton =
            By.xpath("//button[contains(@class,'oxd-button') and normalize-space()='Ok']");

    // Toast message - variantă mai generală
    private By toastMessage =
            By.xpath("//div[contains(@class,'oxd-toast')]");

    public LeavePageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    public void clickAssignLeave() {
        click(assignLeaveMenu);
    }

    public void enterEmployeeName(String employeeName) {
        click(employeeNameInput);
        driver.findElement(employeeNameInput).sendKeys(employeeName);
    }

    public void selectFirstEmployeeFromAutocomplete() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstAutocompleteOption)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(firstAutocompleteOption)
        );

        click(firstAutocompleteOption);
    }

    public void openLeaveTypeDropdown() {
        click(leaveTypeDropdown);
    }

    public void selectFirstLeaveTypeOption() {
        click(firstLeaveTypeOption);
    }

    public void enterFromDate(String fromDate) {
        click(fromDateInput);
        driver.findElement(fromDateInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(fromDateInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(fromDateInput).sendKeys(fromDate);
    }

    public void enterToDate(String toDate) {
        click(toDateInput);
        driver.findElement(toDateInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(toDateInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(toDateInput).sendKeys(toDate);
    }

    public void clickAssign() {
        click(assignButton);
    }

    public void confirmAssignmentPopupIfDisplayed() {
        try {
            click(confirmButton);
        } catch (Exception e) {
            System.out.println("Popup was not displayed. Continuing test.");
        }
    }

    public String getToastMessage() {
        return getText(toastMessage);
    }
}