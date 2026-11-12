
package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("I open the login page")
    public void openLoginPage() {
        loginPage.openLoginPage();
    }

    @Then("I should see the login page title")
    public void shouldSeeLoginPageTitle() {
        loginPage.shouldHaveLoginPageTitle();
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @When("I click the login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("I should see a successful login message")
    public void shouldSeeSuccessMessage() {
        loginPage.shouldHaveSuccessMessage();
    }

    @Then("I should see the logout button")
    public void shouldSeeLogoutButton() {
        loginPage.shouldSeeLogoutButton();
    }

    @When("I click the logout button")
    public void clickLogout() {
        loginPage.clickLogout();
    }

    @Then("I should see the Elemental Selenium link")
    public void shouldSeeElementalSeleniumLink() {
        loginPage.shouldSeeElementalSeleniumLink();
    }

    @Then("I should see an invalid username message")
    public void shouldSeeInvalidUsernameMessage() {
        loginPage.shouldHaveInvalidUsernameMessage();
    }
}
