package pages;

import API.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimPageOrangeHRM extends BasePageOrangeHRM {

    private By pimTitle =
            By.xpath("//h6[text()='PIM']");

    public PimPageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    public String getPimTitle() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(TestConfig.WAIT_TIME));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(pimTitle)
        ).getText();
    }
    private By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    public void clickAddEmployee() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.elementToBeClickable(addEmployeeButton)
        );

        driver.findElement(addEmployeeButton).click();
    }
    //Shearch Doru
    private By employeeNameInput =
            By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");

    private By firstAutocompleteOption =
            By.xpath("//div[@role='listbox']//span");

    private By searchButton =
            By.xpath("//button[@type='submit']");

    private By employeeNameResult =
            By.xpath("//div[@role='table']//div[contains(text(),'Doru')]");

    //metode

    public void enterEmployeeName(String employeeName) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(employeeNameInput)
        );

        driver.findElement(employeeNameInput).sendKeys(employeeName);
    }

    public void selectFirstEmployeeFromAutocomplete() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstAutocompleteOption)
        );

        driver.findElement(firstAutocompleteOption).click();
    }

    public void clickSearch() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        );

        driver.findElement(searchButton).click();
    }

    public String getEmployeeNameResult() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(employeeNameResult)
        );

        return driver.findElement(employeeNameResult).getText();
    }
    private By employeeIdInput =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");

    private By noRecordsMessage =
            By.xpath("//span[text()='No Records Found']");

    //metoda
    public void enterEmployeeId(String employeeId) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(employeeIdInput)
        );

        driver.findElement(employeeIdInput).sendKeys(employeeId);
    }

    public String getNoRecordsMessage() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(noRecordsMessage)
        );

        return driver.findElement(noRecordsMessage).getText();
    }
}

