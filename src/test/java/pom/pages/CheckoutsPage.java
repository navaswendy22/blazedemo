package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutsPage {

    public CheckoutsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr[@class='success']/td[2]")
    private List <WebElement> nameLists;

    public List<WebElement> getNameLists() {
        return nameLists;
    }

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    private  WebElement btnPlaceOrder;

    @FindBy(id = "name")
    private  WebElement inputName;

    @FindBy(id = "country")
    private  WebElement inputCountry;

    @FindBy(id = "city")
    private  WebElement inputCity;

    @FindBy(id = "card")
    private  WebElement inputCreditCard;

    @FindBy(id = "month")
    private  WebElement inputMoth;

    @FindBy(id = "year")
    private  WebElement inputYear;

    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    private  WebElement btnPurchase;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    private  WebElement textCreditCard;

    public WebElement getBtnPlaceOrder() {
        return btnPlaceOrder;
    }

    public By getBtnDelete(String product) {
        return By.xpath("//td[contains(text(),'" + product + "')]/parent::tr//a[contains(text(),'Delete')]");
    }

    public WebElement getInputName() {
        return inputName;
    }

    public WebElement getInputCountry() {
        return inputCountry;
    }

    public WebElement getInputCity() {
        return inputCity;
    }

    public WebElement getInputCreditCard() {
        return inputCreditCard;
    }

    public WebElement getInputMoth() {
        return inputMoth;
    }

    public WebElement getInputYear() {
        return inputYear;
    }

    public WebElement getBtnPurchase() {
        return btnPurchase;
    }

    public WebElement getTextCreditCard() {
        return textCreditCard;
    }
}
