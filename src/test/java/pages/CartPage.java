package pages;

import base.BaseTest;
import org.openqa.selenium.By;

public class CartPage {

    static By CART_CONTAINER = By.id("ContainerShoppingCart");
    static By SHOPPING_ACCORDION = By.cssSelector(".shopping__accordion");
    static By PRODUCT_CARD = By.className("shopping__card ");
    static By DELETE_PRODUCT = By.cssSelector(".product-delete-item");
    static By CONFIRM_DELETE = By.cssSelector("#productDeleteModal .delete-button");
    static By EMPTY_CART_TEMPLATE = By.className("shopping__empty");

    static String product_name;
    static String product_price;

    public static void check(){
        BaseTest.wait_for_element(CART_CONTAINER);
        BaseTest.wait_for_element(SHOPPING_ACCORDION);
        BaseTest.wait_for_element(PRODUCT_CARD);
    }

    public static void get_product_info(){
        product_name = BaseTest.wait_for_element(PRODUCT_CARD).getAttribute("data-product-name");
        product_price = BaseTest.wait_for_element(PRODUCT_CARD).getAttribute("data-price");
    }

    public static void delete_product(){
        BaseTest.wait_for_element(DELETE_PRODUCT).click();
        BaseTest.wait_for_element(CONFIRM_DELETE).click();
    }

    public static boolean is_cart_empty(){
        return BaseTest.element_exists(EMPTY_CART_TEMPLATE);
    }

}
