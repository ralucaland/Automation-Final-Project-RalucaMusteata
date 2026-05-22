package pages;

import API.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeePage extends BasePageOrangeHRM {

    private By firstNameInput =
            By.name("firstName");

    private By lastNameInput =
            By.name("lastName");

    private By saveButton =
            By.cssSelector("button[type='submit']");

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameInput)
        );

        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void clickSave() {

        driver.findElement(saveButton).click();
    }


    public String getFirstNameValue() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameInput)
        );

        return driver.findElement(firstNameInput)
                .getAttribute("value");
    }

    public String getLastNameValue() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastNameInput)
        );

        return driver.findElement(lastNameInput)
                .getAttribute("value");
    }
}


