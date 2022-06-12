package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    static By CART_CONTAINER = By.id("ContainerShoppingCart");
    static By SHOPPING_ACCORDION = By.cssSelector(".shopping__accordion");
    static By PRODUCT_CARD = By.className("shopping__card");
    static By PRODUCT_TITLE = By.className("shopping-product-card__info--title");
    static By PRODUCT_PRICE = By.className("shopping-product-card__info--price-new");
    static By DELETE_PRODUCT = By.cssSelector(".product-delete-item");
    static By CONFIRM_DELETE = By.cssSelector("#productDeleteModal .delete-button");
    static By EMPTY_CART_TEMPLATE = By.className("shopping__empty");

    public static void check(){
        BaseTest.wait_for_element(CART_CONTAINER);
        BaseTest.wait_for_element(SHOPPING_ACCORDION);
        BaseTest.wait_for_element(PRODUCT_CARD);
    }

    public static List<String> get_product_data(){
        List<String> product_data = new ArrayList<>();
        product_data.add(BaseTest.wait_for_element(PRODUCT_TITLE).getText());
        product_data.add(BaseTest.wait_for_element(PRODUCT_PRICE).getText());
        return product_data;
    }

    public static void delete_product(){
        BaseTest.wait_for_element(DELETE_PRODUCT).click();
        BaseTest.wait_for_element(CONFIRM_DELETE).click();
    }

    public static boolean is_cart_empty(){
        return BaseTest.element_exists(EMPTY_CART_TEMPLATE);
    }

}
