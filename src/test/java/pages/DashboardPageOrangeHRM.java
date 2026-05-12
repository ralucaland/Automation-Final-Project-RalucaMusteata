package pages;

<<<<<<< HEAD
public class dashboardPageOrangeHRM {
}
=======
import API.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPageOrangeHRM extends BasePageOrangeHRM {

    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");

    public DashboardPageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    public String getDashboardTitle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(TestConfig.WAIT_TIME));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboardTitle)
        ).getText();
    }

    //Face click in pagina dashboard pe PIM
    private By pimMenu =
            By.xpath("//span[text()='PIM']");

    public void clickPimMenu() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(TestConfig.WAIT_TIME));

        wait.until(
                ExpectedConditions.elementToBeClickable(pimMenu)
        );

        driver.findElement(pimMenu).click();
    }
}
>>>>>>> d2b0f98 (push)
