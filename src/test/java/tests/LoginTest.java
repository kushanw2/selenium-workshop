package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String BASE_URL = "https://www.saucedemo.com";
    private static final String VALID_USER = "standard_user";
    private static final String VALID_PASS = "secret_sauce";
    private static final String LOCKED_USER = "locked_out_user";

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a valid user can log in and land on the inventory page")
    public void testSuccessfulLogin() {
        navigateToLoginPage();
        enterCredentials(VALID_USER, VALID_PASS);
        clickLoginButton();
        verifyDashboardLoaded();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that an invalid password shows an appropriate error message")
    public void testInvalidPassword() {
        navigateToLoginPage();
        enterCredentials(VALID_USER, "wrong_password");
        clickLoginButton();
        verifyErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a locked-out user sees the locked-out error message")
    public void testLockedOutUser() {
        navigateToLoginPage();
        enterCredentials(LOCKED_USER, VALID_PASS);
        clickLoginButton();
        verifyErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }

    @Step("Navigate to login page")
    private void navigateToLoginPage() {
        driver.get(BASE_URL);
    }

    @Step("Enter credentials — username: {username}")
    private void enterCredentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Step("Click the Login button")
    private void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Step("Verify dashboard is loaded")
    private void verifyDashboardLoaded() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
                "URL should contain /inventory.html after successful login");
        String pageTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products", "Page title should be 'Products'");
    }

    @Step("Verify error message: {expectedMessage}")
    private void verifyErrorMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch");
    }
}
