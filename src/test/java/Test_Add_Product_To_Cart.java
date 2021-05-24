import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest {
    // TODO 1: Go Amazon Page -- > Base Test OK

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;


    // TODO 2: Search Product
    @Test
    @Order(1)
    public void search_product() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductPage(), "Not on product page!");
    }

    // TODO 3: Select Product
    @Test
    @Order(2)
    public void select_product() {
        productDetailPage = new ProductDetailPage(driver);
        // WEB element liste atıp 1. elemanı seçiyoruz
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on product detail page!");

    }

    // TODO 4: Add  Product to Cart
    @Test
    @Order(3)
    public void add_product_to_cart() {
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(), "Product count did not increase");
    }

    // TODO 5: Go to Cart
    @Test
    @Order(4)
    public void go_to_cart() {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkProductAdded(),"Product wasn't add to cart");

    }
}
