package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;

public class LoginPage {

    private final SelenideElement formAuthenticationLink = $(byText("Form Authentication"));
    private final SelenideElement pageTitle = $("h2");
    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement flashMessage = $("#flash");
    private final SelenideElement logoutButton = $(byText("Logout"));
    private final SelenideElement elementalSeleniumLink = $(byText("Elemental Selenium"));

    public void openLoginPage() {
        open("https://the-internet.herokuapp.com/");
        formAuthenticationLink.click();
    }

    public void shouldHaveLoginPageTitle() {
        pageTitle.shouldHave(text("Login Page"));
    }

    public void enterCredentials(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void shouldHaveSuccessMessage() {
        flashMessage.shouldHave(text("You logged into a secure area!"));
    }

    public void shouldHaveInvalidUsernameMessage() {
        flashMessage.shouldHave(text("Your username is invalid!"));
    }

    public void shouldSeeLogoutButton() {
        logoutButton.shouldBe(visible);
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void shouldSeeElementalSeleniumLink() {
        elementalSeleniumLink.shouldBe(visible);
    }
}