package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.List;

import static org.testng.Assert.assertTrue;

public class CheckOutPage extends BasePage{

    private String productNameLink = "//*/table/tbody/tr/td/a";

    public void isProductInTheCard(String productName) {
        String productWasted = "//div[@id='content']//*/a[contains(text(), '" + productName + "')]";

        WebElement cartItem = driver.findElement(By.xpath(productWasted));
        String itemName = cartItem.getText();
        // Verify that the cart item text matches the expected value
        Assert.assertEquals(productName, itemName);
    }

    private List<WebElement>  getTitleOfProductsOfCart() {
        String productsLocator = "//div[@id='content']//table//a";
        List<WebElement> productsOnCart = driver.findElements(By.xpath(productsLocator));
        return productsOnCart;
    }
    public void isNotProductInTheCard(String productName) {
        //String productWasted = "//div[@id='content']//*/a[contains(text()," + productName + ")]/text()";
        //WebElement cartItem = driver.findElement(By.xpath(productWasted));
        //String itemName = cartItem.getText();
        //Assert.assertNotEquals(productName, itemName);

        // El producto no esta en la tabla
        // O la tabla esta vacia
        List<WebElement> rows = getTitleOfProductsOfCart();
        boolean productNotFound = true;
        for (WebElement row : rows) {
            // El producto ésta en la tabla
            if (row.getText().equals( productName )) {
                productNotFound = false;
                break;
            }
        }
        assertTrue(productNotFound || rows.isEmpty());

    }

    public void removeProductFromCart(String productName) {
        // Container > Buscar Link por texto > PadreTD > dos hermanos a la derecha > /button[@data-original-title='Remove']
        String xPathFromWastedButton = "//*[@id='content']//table//a[contains(text(), '" + productName + "')]//parent::td//following-sibling::td[2]//button[@data-original-title='Remove']";
        clickElement(xPathFromWastedButton);
    }
}
