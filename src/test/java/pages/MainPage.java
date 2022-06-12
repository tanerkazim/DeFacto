package pages;

import org.openqa.selenium.By;
import base.BaseTest;

public class MainPage {

    static By HEADER_MENU_CATEGORY = By.cssSelector(".menu__super-link[title='kadın']");
    static By SUB_MENU_CATEGORY = By.cssSelector(".menu__super--open .menu__heading[title*='pantolon']");
    static By MINI_CART_BTN = By.className("header__section-cart");
    static By GO_TO_CART_BTN = By.cssSelector("[class*='go-to-cart--button']");
    static By HEADER_CONTAINER = By.className("header__container");
    static By TOAST_MESSAGE_BOX = By.cssSelector(".toast-right");
    static By OPENED_MINI_CARD = By.cssSelector(".sideMenu--open");

    public static void open_website(String url){
        BaseTest.setDriver();
        BaseTest.navigate_to(url);
    }

    public static void check(){
        BaseTest.wait_for_element(HEADER_MENU_CATEGORY);
        BaseTest.wait_for_element(MINI_CART_BTN);
        BaseTest.wait_for_element(HEADER_CONTAINER);
    }

    public static void hover_on_header_category(){
        BaseTest.hover(HEADER_MENU_CATEGORY);
    }

    public static void select_sub_category(){
        BaseTest.wait_for_element(SUB_MENU_CATEGORY).click();
    }

    public static void wait_toast_message_disappears(){
        BaseTest.wait_for_element(TOAST_MESSAGE_BOX);
        BaseTest.wait_for_element_disappears(TOAST_MESSAGE_BOX);
    }

    public static void open_mini_cart(){
        BaseTest.wait_for_element(MINI_CART_BTN).click();
    }

    public static boolean is_mini_cart_opened(){
        return BaseTest.element_exists(OPENED_MINI_CARD);
    }

    public static void go_to_cart(){
        BaseTest.wait_for_element(GO_TO_CART_BTN).click();
    }

}
