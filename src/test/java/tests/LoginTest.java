package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String BASE_URL = "https://www.saucedemo.com";
    private static final String VALID_USER = "standard_user";
    private static final String VALID_PASS = "secret_sauce";

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulLogin() {
        // TODO Step 1 — Navigate to BASE_URL

        // TODO Step 2 — Find the username field (id="user-name") and type VALID_USER
        //               Find the password field (id="password") and type VALID_PASS

        // TODO Step 3 — Click the login button (id="login-button")

        // TODO Step 4 — Assert that driver.getCurrentUrl() contains "/inventory.html"
    }
}
