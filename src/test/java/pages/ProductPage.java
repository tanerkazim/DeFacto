package pages;

import org.openqa.selenium.By;

public class ProductPage {

    By AVAILABLE_PRODUCT_SIZE = By.cssSelector(".product-size-selector [class='button-reset ']");
    By ADD_TO_CART_BTN = By.cssSelector(".action-cart-btn");
    By PRODUCT_NAME = By.className("product-card__name");
    By PRODUCT_CARD = By.cssSelector(".product-card .row");

}
