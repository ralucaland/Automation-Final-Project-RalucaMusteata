package pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOrangeHRM extends BasePageOrangeHRM {

    // Locator pentru câmpul Username
    private By usernameInput =
            By.name("username");

    // Locator pentru câmpul Password
    private By passwordInput =
            By.name("password");

    // Locator pentru butonul Login
    private By loginButton =
            By.cssSelector("button[type='submit']");

    // Locator pentru mesajul de eroare afișat la login invalid
    private By errorMessage =
            By.cssSelector(".oxd-alert-content-text");

    public LoginPageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    // Deschide pagina de login OrangeHRM
    public void openLoginPage() {
        driver.get(TestConfig.ORANGE_HRM_URL);
    }

    // Introduce username în câmpul de login
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    // Introduce parola în câmpul de login
    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    // Apasă butonul de Login
    public void clickLogin() {
        click(loginButton);
    }

    // Returnează mesajul de eroare pentru login invalid
    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
