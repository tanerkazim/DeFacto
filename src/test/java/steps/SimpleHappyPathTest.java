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
        log.info("SetUp completed.");
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
        log.info("Hover action performed to header category.");
    }

    @And("Ekranın sol tarafında beliren hamburger menüden KADIN’ a ait olan “Pantolon” kategorisi seçilir.")
    public void selectSubCategory() {
        MainPage.select_sub_category();
        log.info("Sub category selected.");
    }

    @Then("Kategori sayfasının yüklendiğinin kontrolü yapılır.")
    public void checkCategoryPageLoaded() {
        CategoryPage.check();
        log.info("Category page loaded successfully!");
    }

    @And("Ekranın sol tarafında yer alan filtrelerden Beden: S seçilir.")
    public void filterProductSize() {
        CategoryPage.filter_products();
        assertTrue(CategoryPage.is_filter_selected());
        log.info("Size filter applied.");
    }

    @And("Ceket kategorisine ait S beden ürünler yüklendikten sonra listeden rasgele bir ürüne tıklanarak ürün detay ekranına gidilir.")
    public void selectRandomProduct() {
        CategoryPage.go_to_random_product();
        log.info("Random product selected.");
    }

    @Then("Ürün detay ekranının yüklendiğinin kontrolü yapılır.")
    public void checkProductPageLoaded() {
        ProductPage.check();
        product_page_data = ProductPage.get_product_data();
        log.info("Product page opened successfully!");
    }

    @And("Rasgele bir beden seçimi yapılır.")
    public void selectProductSize() {
        ProductPage.select_random_size();
        log.info("Random product size selected.");
    }

    @And("Sepete Ekle butonuna tıklanır.")
    public void addToCart() {
        ProductPage.add_to_cart();
        MainPage.wait_toast_message_disappears();
        log.info("Product added to cart.");
    }

    @And("Ekranın sağ üstünde yer alan Sepetim butonuna tıklanır.")
    public void openMiniCart() {
        MainPage.open_mini_cart();
        log.info("Clicked to mini cart from header.");
    }

    @Then("Ekranın sağ tarafından Sepet Özet menüsünün gelmesi sağlanır.")
    public void checkMiniCartOpened() {
        assertTrue(MainPage.is_mini_cart_opened());
        log.info("Mini cart opened successfully!");
    }

    @And("SEPETE GİT butonuna tıklanır.")
    public void goToCartPage() {
        MainPage.go_to_cart();
        log.info("Go to cart button clicked.");
    }

    @Then("Sepetim ekranının yüklendiği görülür.")
    public void checkCartPageLoaded() {
        CartPage.check();
        log.info("Cart page opened successfully!");
    }

    @Then("Sepete eklenilen ürünün sepetteki ürün ile aynı isme-fiyata sahip olduğunun kontrolü yapılır.")
    public void checkCartProduct() {
        List<String> cart_page_data = CartPage.get_product_data();
        assertEquals(product_page_data.get(0), cart_page_data.get(0));
        assertEquals(product_page_data.get(1).replace("\n", " "), cart_page_data.get(1));
        log.info("The product which added to cart confirmed successfully!");
    }

    @And("Ürün Sepetim ekranında Sil buton yardımı ile sepetten çıkartılır.")
    public void deleteProduct() {
        CartPage.delete_product();
        log.info("Product being deleting from cart.");
    }

    @Then("Sepetin boş olduğu kontrol edilir.")
    public void checkCartIsEmpty() {
        assertTrue(CartPage.is_cart_empty());
        log.info("Product deleted from cart successfully!");
    }

    @After
    public void tearDown(){
        BaseTest.tear_down();
        log.info("FINISHED");
    }

}
