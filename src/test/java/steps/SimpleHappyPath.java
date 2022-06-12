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

@RunWith(Cucumber.class)
public class SimpleHappyPath {
    @Before
    public void setUpChrome(){
        BaseTest.setDriver();
    }

    @Given("www.defacto.com.tr adresine gidilir.")
    public void openHomePage() {
    }

    @Then("Ekranın yüklendiğine dair kontrol yapılır.")
    public void checkHomePageLoaded() {
    }

    @When("Ana sayfada üstte yer alan menülerden KADIN sekmesinin üzerine gelinir.")
    public void selectHeaderCategory() {
    }

    @And("Ekranın sol tarafında beliren hamburger menüden KADIN’ a ait olan “Pantolon” kategorisi seçilir.")
    public void selectSubCategory() {
    }

    @Then("Kategori sayfasının yüklendiğinin kontrolü yapılır.")
    public void checkCategoryPageLoaded() {
    }

    @And("Ekranın sol tarafında yer alan filtrelerden Beden: S seçilir.")
    public void filterProductSize() {
    }

    @And("Ceket kategorisine ait S beden ürünler yüklendikten sonra listeden rasgele bir ürüne tıklanarak ürün detay ekranına gidilir.")
    public void selectRandomProduct() {
    }

    @Then("Ürün detay ekranının yüklendiğinin kontrolü yapılır.")
    public void checkProductPageLoaded() {
    }

    @And("Rasgele bir beden seçimi yapılır.")
    public void selectProductSize() {
    }

    @And("Sepete Ekle butonuna tıklanır.")
    public void addToCart() {
    }

    @And("Ekranın sağ üstünde yer alan Sepetim butonuna tıklanır.")
    public void openMiniCart() {
    }

    @Then("Ekranın sağ tarafından Sepet Özet menüsünün gelmesi sağlanır.")
    public void checkMiniCartOpened() {
    }

    @And("SEPETE GİT butonuna tıklanır.")
    public void goToCartPage() {
    }

    @Then("Sepetim ekranının yüklendiği görülür.")
    public void checkCartPageLoaded() {
    }

    @Then("Sepete eklenilen ürünün sepetteki ürün ile aynı isme-fiyata sahip olduğunun kontrolü yapılır.")
    public void checkCartProduct() {
    }

    @And("Ürün Sepetim ekranında Sil buton yardımı ile sepetten çıkartılır.")
    public void deleteProduct() {
    }

    @Then("Sepetin boş olduğu kontrol edilir.")
    public void checkCartIsEmpty() {
    }

    @After
    public void tearDown(){
        BaseTest.tear_down();
    }

}
