package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPageOrangeHRM extends BasePageOrangeHRM {

    private By pimTitle =
            By.xpath("//h6[text()='PIM']");

    private By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    private By employeeNameInput =
            By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");

    private By firstAutocompleteOption =
            By.xpath("(//div[@role='option']//span)[1]");

    private By searchButton =
            By.xpath("//button[@type='submit']");

    private By employeeIdInput =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");

    private By noRecordsMessage =
            By.xpath("//span[text()='No Records Found']");

    public PimPageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    public String getPimTitle() {
        return getText(pimTitle);
    }

    public void clickAddEmployee() {
        click(addEmployeeButton);
    }

    public void enterEmployeeName(String employeeName) {
        type(employeeNameInput, employeeName);
    }

    public void selectFirstEmployeeFromAutocomplete() {
        click(firstAutocompleteOption);
    }

    public void enterEmployeeId(String employeeId) {
        type(employeeIdInput, employeeId);
    }

    public void clickSearch() {
        click(searchButton);
    }

    public String getEmployeeNameResult(String employeeName) {
        By employeeNameResult =
                By.xpath("//div[@role='table']//div[contains(text(),'" + employeeName + "')]");

        return getText(employeeNameResult);
    }

    public String getNoRecordsMessage() {
        return getText(noRecordsMessage);
    }
}