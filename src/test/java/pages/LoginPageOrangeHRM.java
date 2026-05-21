package pages;

public class loginPageOrangeHRM {
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import API.config.TestConfig;
import java.time.Duration;

public class LoginPageOrangeHRM extends BasePageOrangeHRM {

    private By usernameInput = By.name("username");

    private By passwordInput = By.name("password");

    private By loginButton =
            By.cssSelector("button[type='submit']");
    private By errorMessage =
            By.cssSelector(".oxd-alert-content-text");

    public LoginPageOrangeHRM(WebDriver driver) {

        super(driver);
    }

    public void openLoginPage() {

            driver.get(TestConfig.ORANGE_HRM_URL);
        }

    public void enterUsername(String username) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameInput)
        );

        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }



    public String getErrorMessage() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );

        return driver.findElement(errorMessage).getText();
    }
}
>>>>>>> d2b0f98 (push)
