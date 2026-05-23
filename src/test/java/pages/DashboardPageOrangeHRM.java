package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageOrangeHRM extends BasePageOrangeHRM {

    // Locator pentru titlul paginii Dashboard
    private By dashboardTitle =
            By.xpath("//h6[text()='Dashboard']");

    // Locator pentru meniul PIM din sidebar
    private By pimMenu =
            By.xpath("//span[text()='PIM']");

    public DashboardPageOrangeHRM(WebDriver driver) {
        super(driver);
    }

    // Returnează textul titlului Dashboard
    public String getDashboardTitle() {
        return getText(dashboardTitle);
    }

    // Face click pe PIM din Dashboard
    public void clickPimMenu() {
        click(pimMenu);
    }

    // Locator pentru LeavPage
    private By leaveMenu =
            By.xpath("//span[text()='Leave']");
    // Face click pe meniul Leave din Dashboard
    public void clickLeaveMenu() {
        click(leaveMenu);
    }
}