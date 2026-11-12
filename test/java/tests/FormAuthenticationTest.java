package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class FormAuthenticationTest {

    @Test
    void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage();
        loginPage.shouldHaveLoginPageTitle();
        loginPage.enterCredentials("tomsmith", "SuperSecretPassword!");
        loginPage.clickLogin();
        loginPage.shouldHaveSuccessMessage();
        loginPage.shouldSeeLogoutButton();
        loginPage.clickLogout();
        loginPage.shouldHaveLoginPageTitle();
    }

    @Test
    void unsuccessfulLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage();
        loginPage.shouldSeeElementalSeleniumLink();
        loginPage.enterCredentials("admin", "1234");
        loginPage.clickLogin();
        loginPage.shouldHaveInvalidUsernameMessage();
    }
}