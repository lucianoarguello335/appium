package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class JamesRiderSteps {
    LoginPage loginPage = new LoginPage();

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
        loginPage.checkRidesOpened();
    }
}
