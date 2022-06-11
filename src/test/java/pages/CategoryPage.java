package pages;

import org.openqa.selenium.By;

public class CategoryPage {

    By SUBMENU_FILTER_OPTION = By.cssSelector("[class*='submenu'] label[data-value='S']");
    By CATALOG_PRODUCTS = By.cssSelector("[class*='catalog-products'] .image-box");
    By PRODUCT_CONTAINER = By.id("product-container");
    By SUB_CATEGORIES = By.cssSelector(".catalog__sub-categories");
}
