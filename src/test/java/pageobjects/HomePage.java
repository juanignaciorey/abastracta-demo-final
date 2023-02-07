package pageobjects;

public class HomePage extends BasePage{

    private String searchButton = "//*[@id='search']/span/button";

    private String searchTextField = "//*[@id='search']/input[@type='text']";

    public void navigateToHome() {
        navigateTo("http://opencart.abstracta.us/");
    }

    public void enterSearchCriteria(String criteria) {
        write(searchTextField, criteria);
    }

    public void clickOnSearchButton() {
        clickElement(searchButton);
    }

    public void selectInputToSearch() {
        focusOn(searchTextField);
    }
}
