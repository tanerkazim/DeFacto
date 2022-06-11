package pages;

import org.openqa.selenium.By;

public class MainPage {

    By HEADER_MENU_CATEGORY = By.cssSelector(".menu__super-link[title='kadın']");
    By SUB_MENU_CATEGORY = By.cssSelector(".menu__super--open .menu__heading[title*='pantolon']");
    By MINI_CART_BTN = By.className("header__section-cart");
    By GO_TO_CART_BTN = By.cssSelector("[class*='go-to-cart--button']");
    By HEADER_CONTAINER = By.className("header__container");
    By TOAST_MESSAGE_BOX = By.cssSelector(".toast-right");

}
