package pages;

import org.openqa.selenium.By;

public class CartPage {

    By CART_CONTAINER = By.id("ContainerShoppingCart");
    By SHOPPING_ACCORDION = By.cssSelector(".shopping__accordion");
    By PRODUCT_CARD = By.className("shopping__card ");
    By DELETE_PRODUCT = By.cssSelector(".product-delete-item");

}
