package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductPage {

    static By AVAILABLE_PRODUCT_SIZE = By.cssSelector(".product-size-selector [class='button-reset ']");
    static By ADD_TO_CART_BTN = By.cssSelector(".action-cart-btn[data-state='1']");
    static By PRODUCT_OPTIONS = By.cssSelector(".product-options");
    static By PRODUCT_NAME = By.className("product-card__name");
    static By PRODUCT_CARD = By.cssSelector(".product-card__right");

    static String product_name;

    public static void check(){
        BaseTest.wait_for_element(PRODUCT_CARD);
        BaseTest.wait_for_element(PRODUCT_NAME);
        BaseTest.wait_for_element(AVAILABLE_PRODUCT_SIZE);
    }

    public static void select_random_size(){
        BaseTest.scroll_to(PRODUCT_OPTIONS);
        List<WebElement> product_sizes = BaseTest.wait_for_all_elements(AVAILABLE_PRODUCT_SIZE);
        int random_size_number = BaseTest.random_number(1, product_sizes.size());
        //BaseTest.scroll_to_web_element(product_sizes.get(random_size_number));
        product_sizes.get(random_size_number).click();
    }

    public static void add_to_cart(){
        BaseTest.scroll_to(PRODUCT_OPTIONS);
        //BaseTest.hover(ADD_TO_CART_BTN);
        BaseTest.wait_for_element(ADD_TO_CART_BTN).click();
    }

    public static String get_product_name(){
        return product_name = BaseTest.wait_for_element(PRODUCT_NAME).getText();
    }

}
