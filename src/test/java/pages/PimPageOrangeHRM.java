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
}

