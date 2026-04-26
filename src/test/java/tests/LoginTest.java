package tests;

import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String BASE_URL = "https://www.saucedemo.com";
    private static final String VALID_USER = "standard_user";
    private static final String VALID_PASS = "secret_sauce";

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo(BASE_URL);
        loginPage.login(VALID_USER, VALID_PASS);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoaded(), "Home page did not load after login");
    }
}
