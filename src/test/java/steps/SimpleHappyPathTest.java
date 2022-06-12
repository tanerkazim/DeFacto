package steps;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import pages.CartPage;
import pages.CategoryPage;
import pages.MainPage;
import pages.ProductPage;
import java.util.List;

@RunWith(Cucumber.class)
public class SimpleHappyPathTest {

    public static Logger log;
    List<String> product_page_data;

    @Before
    public void setUp(){
        System.setProperty("log4j.configurationFile","log4j2-test.xml");
        log = LogManager.getLogger(SimpleHappyPathTest.class);
        BaseTest.setDriver();
        log.info("SetUP completed successfully!");
    }

    @Given("www.defacto.com.tr adresine gidilir.")
    public void openHomePage() {
        MainPage.open_website("https://www.defacto.com.tr/");
        log.info("Home page opened.");
    }

    @Then("Ekranın yüklendiğine dair kontrol yapılır.")
    public void checkHomePageLoaded() {
        MainPage.check();
        log.info("Home page loaded successfully!");
    }

    @When("Ana sayfada üstte yer alan menülerden KADIN sekmesinin üzerine gelinir.")
    public void selectHeaderCategory() {
        MainPage.hover_on_header_category();
    }

    @And("Ekranın sol tarafında beliren hamburger menüden KADIN’ a ait olan “Pantolon” kategorisi seçilir.")
    public void selectSubCategory() {
        MainPage.select_sub_category();
    }

    @Then("Kategori sayfasının yüklendiğinin kontrolü yapılır.")
    public void checkCategoryPageLoaded() {
        CategoryPage.check();
    }

    @And("Ekranın sol tarafında yer alan filtrelerden Beden: S seçilir.")
    public void filterProductSize() {
        CategoryPage.filter_products();
        assertTrue(CategoryPage.is_filter_selected());
    }

    @And("Ceket kategorisine ait S beden ürünler yüklendikten sonra listeden rasgele bir ürüne tıklanarak ürün detay ekranına gidilir.")
    public void selectRandomProduct() {
        CategoryPage.go_to_random_product();
    }

    @Then("Ürün detay ekranının yüklendiğinin kontrolü yapılır.")
    public void checkProductPageLoaded() {
        ProductPage.check();
        product_page_data = ProductPage.get_product_data();
    }

    @And("Rasgele bir beden seçimi yapılır.")
    public void selectProductSize() {
        ProductPage.select_random_size();
    }

    @And("Sepete Ekle butonuna tıklanır.")
    public void addToCart() {
        ProductPage.add_to_cart();
        MainPage.wait_toast_message_disappears();
    }

    @And("Ekranın sağ üstünde yer alan Sepetim butonuna tıklanır.")
    public void openMiniCart() {
        MainPage.open_mini_cart();
    }

    @Then("Ekranın sağ tarafından Sepet Özet menüsünün gelmesi sağlanır.")
    public void checkMiniCartOpened() {
        assertTrue(MainPage.is_mini_cart_opened());
    }

    @And("SEPETE GİT butonuna tıklanır.")
    public void goToCartPage() {
        MainPage.go_to_cart();
    }

    @Then("Sepetim ekranının yüklendiği görülür.")
    public void checkCartPageLoaded() {
        CartPage.check();
    }

    @Then("Sepete eklenilen ürünün sepetteki ürün ile aynı isme-fiyata sahip olduğunun kontrolü yapılır.")
    public void checkCartProduct() {
        List<String> cart_page_data = CartPage.get_product_data();
        assertEquals(product_page_data.get(0), cart_page_data.get(0));
        assertEquals(product_page_data.get(1).replace("\n", " "), cart_page_data.get(1));
    }

    @And("Ürün Sepetim ekranında Sil buton yardımı ile sepetten çıkartılır.")
    public void deleteProduct() {
        CartPage.delete_product();
    }

    @Then("Sepetin boş olduğu kontrol edilir.")
    public void checkCartIsEmpty() {
        assertTrue(CartPage.is_cart_empty());
    }

    @After
    public void tearDown(){
        BaseTest.tear_down();
    }

}
