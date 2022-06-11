package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage {

    static By SUBMENU_FILTER_OPTION = By.cssSelector(".filter-box-item[data-textfilter='S']");
    static By CATALOG_PRODUCTS = By.cssSelector("[class*='catalog-products'] .image-box");
    static By PRODUCT_CONTAINER = By.id("product-container");
    static By SUB_CATEGORIES = By.cssSelector(".catalog__sub-categories");
    static By SIZE_FILTER = By.cssSelector(".catalog-filter__option[data-target='#fx_s']");

    public static void check(){
        BaseTest.wait_for_element(SUBMENU_FILTER_OPTION);
        BaseTest.wait_for_element(PRODUCT_CONTAINER);
        BaseTest.wait_for_element(CATALOG_PRODUCTS);
        BaseTest.wait_for_element(SIZE_FILTER);
        BaseTest.wait_for_element(SUB_CATEGORIES);
    }

    public static void filter_products(){
        BaseTest.hover(SIZE_FILTER);
        BaseTest.wait_for_element(SUBMENU_FILTER_OPTION).click();
    }

    public static void go_to_random_product(){
        List<WebElement> products = BaseTest.wait_for_all_elements(CATALOG_PRODUCTS);
        products.get(BaseTest.random_number(1, products.size())).click();
    }
}
