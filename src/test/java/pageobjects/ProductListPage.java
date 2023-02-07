package pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ProductListPage extends BasePage {

    private String imageProductLink = "//div/image/a/@href";
    private String AddToCartButton = "//button/span[contains(text(), 'Add to Cart')]/parent::button";
    private String textOfProductName = "//div[@id=\"content\"]//h4/a/text()";

    private String ViewCartLink = "//*[@id=\"cart\"]//strong[contains(text(),'View Cart')]/parent::a";

    private String shoppingCartButton = "//span[@id=\"cart-total\"]/parent::button";
    private String titleProductLink = "//div[@id=\"content\"]//h4/a/@href";

    private void scrollDownToFindItem(String locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(locator)));
    }

    public void addFirstProductToCart() {
        scrollDownToFindItem(AddToCartButton);
        clickElement(AddToCartButton);
    }
    public void clickFirstProductLink() {
        scrollDownToFindItem(AddToCartButton);
        WebElement firstLink = driver.findElement(By.xpath(titleProductLink));
        firstLink.click();
    }
    public void pressShoppingCartButton() {
        clickElement(shoppingCartButton);
    }

    private void clickOnElementByPartialText(String text) {
        WebElement link = driver.findElement(By.partialLinkText(text));
        link.click();
    }
    public void pressViewCartLink() {
        clickElement(ViewCartLink);
    }
}
