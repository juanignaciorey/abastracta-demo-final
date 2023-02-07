import io.cucumber.java.en.Given;
public class AbstractaStepDefs {

    pages.HomePage HOME;
    @Given("^I am on the Home search page$")
    public void iAmOnTheHomeSearchPage() {
        HOME = new HomePage();
        HOME.navigateToHome();
    }
}
