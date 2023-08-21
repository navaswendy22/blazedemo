package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddProductsSteps extends BaseTest {
    private String phone;
    private String laptop;
    private String monitor;
    private String creditCard;

    @Given("I enters to the {string}")
    public void enterToTheWebsite(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @When("I want to add three products {string} {string} {string}")
    public void addProducts(String phone, String laptop, String monitor) throws Exception {
        this.phone = phone;
        this.laptop = laptop;
        this.monitor = monitor;

        home.addProduct("Laptops", laptop);
        home.clickHome();

        home.addProduct("Phones", phone);
        home.clickHome();

        home.addProduct("Monitors", monitor);
        home.clickCart();
    }

    @Then("I verify that I added {string} products")
    public void verifyProducts(String quantity) {
        int qty = Integer.parseInt(quantity);
        Assert.assertEquals(checkout.getQuantityOfProducts(), qty);
    }

    @Then("I confirm that I have added the products accurately")
    public void confirmProducts() {
        Assert.assertEquals(checkout.getListOFAddedProducts(), checkout.sortListOfSelectedProducts(phone, laptop, monitor));
    }

    @When("I delete a product {string}")
    public void deleteProduct(String product) throws Exception {
        checkout.clickDelete(product);
    }

    @When("I proceed to complete the checkout flow with the following information {string} {string} {string} {string} {string} {string}")
    public void checkoutProduct(String name, String country, String city, String creditCard, String month, String year) throws Exception {
        this.creditCard= creditCard;
        checkout.clickBtnPlaceOrder();
        checkout.sendInfoForPlaceOrder(name, country, city, creditCard, month, year);
    }

    @When("I verify that the displayed card number is accurate")
    public void verifyCreditCard() throws Exception {
        Assert.assertTrue(checkout.getTextCreditCard(creditCard));
    }
}
