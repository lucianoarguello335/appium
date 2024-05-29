package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.LoginPage;
import pages.RidesPage;

public class JamesRiderSteps {
    LoginPage loginPage = new LoginPage();
    RidesPage ridesPage = new RidesPage();
    AccountPage accountPage = new AccountPage();

    @Given("I launch the application")
    public void iLaunchTheApplication() {
        loginPage.launchApp();
    }

    @When("I complete the login process with {string}, {string} and {string}")
    public void iCompleteTheLoginProcessWithAnd(String arg0, String arg1, String arg2) {
        loginPage.loginApp(arg0,arg1,arg2);
    }

    @Then("I should be on the Rides screen")
    public void iShouldBeOnTheRidesScreen() {
        ridesPage.launchPage();
    }

    @Given("I click on the options button")
    public void iClickOnTheOptionsButton() {
        ridesPage.clickOptionsButton();
    }

    @And("I should be on the account page")
    public void iShouldBeOnTheAccountPage() {
        accountPage.launchPage();
    }

    @When("I edit the name and last name")
    public void theUserEditsTheirNameAndLastName() {
        accountPage.editUserName();
    }

    @Then("the user information should be updated")
    public void theUserInformationShouldBeUpdated() {
        accountPage.checkAccountOpened();
    }

    @When("I click on the logout button")
    public void iClickOnTheLogoutButton() {
        accountPage.clickSignOutButton();
    }

    @Then("I should be on the login page")
    public void iShouldBeOnTheLoginPage() {
        loginPage.checkLoginStatus(loginPage.getGetStartedButton(),
                "Correctly located on 'Login' page initial screen",
                "Not on 'Login' initial page");
    }

    @Given("I click on the done button")
    public void iClickOnTheDoneButton() {
        accountPage.clickDoneButton();
    }

    @When("I change the profile pic")
    public void theUserChangesTheirProfilePic() {
        accountPage.changeProfilePic();
    }

    @And("the changes were saved")
    public void theChangesWereSaved() {
        accountPage.checkProfileUpdateSuccess();
    }

    @And("I click on the profile name")
    public void iClickOnTheProfileName() {
        accountPage.clickProfileName();
    }

    @And("I should be on the login page after the logout")
    public void iShouldBeOnTheLoginPageAfterTheLogout() {
        loginPage.checkLoginStatus(loginPage.getPhoneInputText(),
                "Correctly located on 'Login' page after logout",
                "Not on 'Login' page after logout");
    }
}
