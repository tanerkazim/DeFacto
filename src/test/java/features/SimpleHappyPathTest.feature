Feature: Simple User Happy Path


  Scenario: Kullanıcının bir kategori sayfasına gidip, rastgele bir ürün seçip,
  ürün sayfasından sepete ekleyip sepet sayfasına gidebildiği görülmelidir
    Given www.defacto.com.tr adresine gidilir.
    Then Ekranın yüklendiğine dair kontrol yapılır.
    When Ana sayfada üstte yer alan menülerden KADIN sekmesinin üzerine gelinir.
    And Ekranın sol tarafında beliren hamburger menüden KADIN’ a ait olan “Pantolon” kategorisi seçilir.
    Then Kategori sayfasının yüklendiğinin kontrolü yapılır.
    And Ekranın sol tarafında yer alan filtrelerden Beden: S seçilir.
    And Ceket kategorisine ait S beden ürünler yüklendikten sonra listeden rasgele bir ürüne tıklanarak ürün detay ekranına gidilir.
    Then Ürün detay ekranının yüklendiğinin kontrolü yapılır.
    And Rasgele bir beden seçimi yapılır.
    And Sepete Ekle butonuna tıklanır.
    And Ekranın sağ üstünde yer alan Sepetim butonuna tıklanır.
    Then Ekranın sağ tarafından Sepet Özet menüsünün gelmesi sağlanır.
    And SEPETE GİT butonuna tıklanır.
    Then Sepetim ekranının yüklendiği görülür.
    Then Sepete eklenilen ürünün sepetteki ürün ile aynı isme-fiyata sahip olduğunun kontrolü yapılır.
    And Ürün Sepetim ekranında Sil buton yardımı ile sepetten çıkartılır.
    Then Sepetin boş olduğu kontrol edilir.
