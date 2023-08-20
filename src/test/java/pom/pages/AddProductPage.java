package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddProductPage {

    public AddProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement btnCart;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement btnHome;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private WebElement btnAddToCart;

    public WebElement getBtnCart() {
        return btnCart;
    }

    public WebElement getBtnHome() {
        return btnHome;
    }

    public By getProduct(String product) {
        return By.xpath("//a[contains(text(),'" + product + "')]");
    }

    public By getCategory(String category) {
        return By.xpath("//a[contains(text(),'" + category + "')]");
    }

    public WebElement getBtnAddToCart() {
        return btnAddToCart;
    }

}
