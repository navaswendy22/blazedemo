package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddProductsSteps extends BaseTest {
    private String product1;
    private String product2;
    private String product3;

    @Given("I enters to the {string}")
    public void enterToTheWebsite(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @When("I want to add three products {string} {string} {string}")
    public void addProducts(String phone, String laptop, String monitor) throws Exception {
        product1 = phone;
        product2 = laptop;
        product3 = monitor;

        home.addProduct("Phones", phone);
        home.clickHome();

        home.addProduct("Laptops", laptop);
        home.clickHome();

        home.addProduct("Monitors", monitor);
        home.clickCart();
    }

    @Then("I verify that I added {string} products")
    public void verifyProducts(String qty) {
        int qty1 = Integer.parseInt(qty);
        Assert.assertEquals(checkout.getQuantityOfProducts(), qty1);
    }

    @Then("I confirm that I have added the products accurately")
    public void confirmProducts() {
        Assert.assertEquals(checkout.getListOFAddedProducts(), checkout.sortListOfSelectedProducts(product1, product2, product3));
    }

    @When("I delete a product {string}")
    public void deleteProduct(String product) throws Exception {
        checkout.clickDelete(product);
    }

    @When("I proceed to complete the checkout flow with the following information {string} {string} {string} {string} {string} {string}")
    public void checkoutProduct(String name, String country, String city, String creditCard, String month, String year) throws Exception {
        checkout.clickBtnPlaceOrder();
        checkout.sendInfoForPlaceOrder(name, country, city, creditCard, month, year);
        Assert.assertTrue(checkout.getTextCreditCard(creditCard));
    }
}
