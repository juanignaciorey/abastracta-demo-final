package stepsdef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.messages.types.Product;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.*;

import static java.lang.Thread.sleep;

public class AbstractaStepDefs {

    HomePage HOME = new HomePage();
    ProductListPage PLP = new ProductListPage();
    CheckOutPage CHECKOUT = new CheckOutPage();

    @Given("^I am on the Home search page$")
    public void iAmOnTheHomeSearchPage() {
        HOME.navigateToHome();
    }

    @When("^I enter a search iPhone$")
    public void iEnterASearchIPhone() {
        HOME.enterSearchCriteria("iPhone");
    }

    @And("^I click search$")
    public void iClickSearch() {
        HOME.clickOnSearchButton();
    }

    @AfterMethod
    @And("^Add the product to the shopping cart$")
    public void addTheProductToTheShoppingCart() throws InterruptedException {
        PLP.addFirstProductToCart();
        // TODO: Si espera dos segundo.
        sleep(1500);
    }

    @Then("^Enter the shopping cart button$")
    public void enterTheShoppingCartButton(){
        PLP.pressShoppingCartButton();
        PLP.pressPage_UP();
    }

    @And("^Press 'View Cart' link$")
    public void pressViewCartLink() {
        PLP.pressViewCartLink();
    }
    @AfterMethod
    @And("^Validate that the selected iPhone is in the shopping cart$")
    public void validateThatTheSelectedIPhoneIsInTheShoppingCart() {
        CHECKOUT.isProductInTheCard("iPhone");
    }

    @Then("^Remove the iPhone from the shopping cart$")
    public void removeTheIPhoneFromTheShoppingCart() {
        CHECKOUT.removeProductFromCart("iPhone");
    }

    @AfterMethod
    @And("^Validate that the iPhone is no longer in the shopping cart$")
    public void validateThatTheIPhoneIsNoLongerInTheShoppingCart() {
        CHECKOUT.isNotProductInTheCard("Iphone");
    }
}
