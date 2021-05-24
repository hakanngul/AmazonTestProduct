import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By cartCountLocator = By.id("nav-cart-count");
    By cartContainerLocator = By.id("nav-cart-count-container");
    By acceptCookies = By.id("sp-cc-accept");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }


    public boolean isProductCountUp() {
        return getCartCount() > 0;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    private int getCartCount() {
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void acceptCookies() {
        if (isDisplayed(acceptCookies))
            click(acceptCookies);

    }
}
