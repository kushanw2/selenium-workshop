package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    private final By pageTitle = By.cssSelector(".title");
    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By shoppingCartIcon = By.cssSelector(".shopping_cart_link");
    private final By shoppingCartBadge = By.cssSelector(".shopping_cart_badge");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public int getInventoryItemCount() {
        return driver.findElements(inventoryItems).size();
    }

    public void clickShoppingCart() {
        driver.findElement(shoppingCartIcon).click();
    }

    public String getCartBadgeCount() {
        List<?> badges = driver.findElements(shoppingCartBadge);
        return badges.isEmpty() ? "0" : driver.findElement(shoppingCartBadge).getText();
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }
}
