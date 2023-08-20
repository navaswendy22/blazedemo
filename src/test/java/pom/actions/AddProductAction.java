package pom.actions;

import org.openqa.selenium.WebDriver;
import pom.BasePage;
import pom.pages.AddProductPage;

public class AddProductAction extends BasePage {
    AddProductPage addProductPage;

    public AddProductAction(WebDriver driver) {
        super(driver);
        addProductPage = new AddProductPage(driver);
    }

    public void clickProduct(String product) throws Exception {
        click(addProductPage.getProduct(product));
    }

    public void clickCategory(String category) throws Exception {
        click(addProductPage.getCategory(category));
    }

    public void clickHome() throws Exception {
        click(addProductPage.getBtnHome());
    }

    public void clickCart() throws Exception {
        click(addProductPage.getBtnCart());
    }

    public void clickBtnAddToCart() throws Exception {
        click(addProductPage.getBtnAddToCart());
        waitFor(2);
        driver.switchTo().alert().dismiss();
    }

    public void addProduct(String category, String product) throws Exception {
        this.clickCategory(category);
        this.clickProduct(product);
        this.clickBtnAddToCart();
    }
}
