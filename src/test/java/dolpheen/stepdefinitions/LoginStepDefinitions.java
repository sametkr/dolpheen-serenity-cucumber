package dolpheen.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import dolpheen.navigation.NavigateTo;
import dolpheen.pages.*;
import dolpheen.pages.OrangeHrmHomePage;

public class LoginStepDefinitions {

    @Given("{actor} is on the home page")
    public void user_is_on_the_login_page(Actor actor) {
        actor.wasAbleTo(NavigateTo.orangeHrmHomePage());
    }


    @When("{actor} enters email {string}")
    public void user_enters_email(Actor actor, String string) {
        actor.attemptsTo(Enter.theValue(string).into(OrangeHrmHomePage.USER_USERNAME));
    }

    @When("{actor} enters password {string}")
    public void user_enters_password(Actor actor, String string) {
        actor.attemptsTo(Enter.theValue(string).into(OrangeHrmHomePage.USER_PASSWORD));

    }

    @When("{actor} clicks Log in button")
    public void user_clicks_log_in_button(Actor actor) {
        actor.wasAbleTo(Click.on(OrangeHrmHomePage.LOG_IN_BUTTON));

    }

    @Then("{actor} should see {string} on the homepage")
    public void user_should_see_on_the_homepage(Actor actor, String string) {
        actor.attemptsTo(Ensure.that(DashboardPage.DASHBOARD_PAGE_TITLE).hasText(string));

    }

    @Then("{actor} should see {string} message")
    public void user_should_see_message(Actor actor, String string) {
        actor.attemptsTo(Ensure.that(OrangeHrmHomePage.ERROR_MESSAGE).hasText(string));

    }
}
