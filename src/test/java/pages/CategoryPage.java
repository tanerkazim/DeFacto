package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage {

    static By SUBMENU_FILTER_OPTION = By.cssSelector(".filter-box-item[data-textfilter='S']");
    static By CATALOG_PRODUCTS = By.cssSelector(".catalog-products__item");
    static By CATALOG_PRODUCT_TITLE = By.cssSelector(".catalog-products__item .product-card__title a");
    static By PRODUCT_CONTAINER = By.id("product-container");
    static By SUB_CATEGORIES = By.cssSelector(".catalog__sub-categories");
    static By SIZE_FILTER = By.cssSelector(".catalog-filter__option[data-target='#fx_s']");
    static By SELECTED_FILTERS = By.cssSelector(".selected-filters [href*='beden']");

    public static void check(){
        BaseTest.wait_for_element(SUBMENU_FILTER_OPTION);
        BaseTest.wait_for_element(PRODUCT_CONTAINER);
        BaseTest.wait_for_element(CATALOG_PRODUCTS);
        BaseTest.wait_for_element(SIZE_FILTER);
        BaseTest.wait_for_element(SUB_CATEGORIES);
    }

    public static void filter_products(){
        BaseTest.scroll_to(SIZE_FILTER);
        BaseTest.wait_for_element(SUBMENU_FILTER_OPTION).click();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean is_filter_selected(){
        return BaseTest.element_exists(SELECTED_FILTERS);
    }

    public static void go_to_random_product(){
        List<WebElement> products = BaseTest.wait_for_all_elements(CATALOG_PRODUCTS);
        int random_product_number = BaseTest.random_number(1, products.size());
        BaseTest.scroll_to_web_element(products.get(random_product_number));
        //List<WebElement> product_title = BaseTest.wait_for_all_elements(CATALOG_PRODUCTS);
        BaseTest.wait_for_web_element(products.get(random_product_number)).click();
    }
}
