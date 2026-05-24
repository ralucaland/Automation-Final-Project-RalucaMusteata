package pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageOrangeHRM {

    // Driverul controlează browserul și este folosit de toate paginile
    protected WebDriver driver;

    // Wait-ul ajută testele să aștepte elementele dinamice din pagină
    protected WebDriverWait wait;

    // Locator pentru loaderul intern OrangeHRM care poate bloca click-ul pe butoane
    private By pageLoader =
            By.cssSelector(".oxd-form-loader");

    public BasePageOrangeHRM(WebDriver driver) {
        this.driver = driver;

        // Inițializăm wait-ul folosind timpul definit centralizat în TestConfig
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(TestConfig.WAIT_TIME)
        );
    }

    // Așteaptă ca elementul să fie clickabil, apoi face click
    protected void click(By locator) {
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }

    // Așteaptă ca elementul să fie vizibil, apoi scrie text în el
    protected void type(By locator, String text) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).sendKeys(text);
    }

    // Șterge complet textul existent dintr-un input și scrie valoarea nouă
    protected void clearAndType(By locator, String text) {
        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                );

        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(text);
    }

    // Așteaptă ca elementul să fie vizibil, apoi returnează textul lui
    protected String getText(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    // Returnează elementul doar după ce acesta este vizibil
    protected WebElement waitForVisible(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    // Returnează elementul doar după ce acesta poate fi apăsat
    protected WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    // Așteaptă ca loaderul OrangeHRM să dispară înainte de acțiuni sensibile, cum ar fi Save
    protected void waitForPageLoaderToDisappear() {
        List<WebElement> loaders =
                driver.findElements(pageLoader);

        if (!loaders.isEmpty()) {
            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(pageLoader)
            );
        }
    }
}

