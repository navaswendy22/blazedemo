package pom.actions;

import org.openqa.selenium.WebDriver;
import pom.BasePage;
import pom.pages.CheckoutsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CheckoutsAction extends BasePage {

    CheckoutsPage checkout;

    public CheckoutsAction(WebDriver driver) {
        super(driver);
        checkout = new CheckoutsPage(driver);
    }

    public int getQuantityOfProducts() {
        waitFor(2);
        return checkout.getNameLists().size();
    }

    public List getListOFAddedProducts() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < checkout.getNameLists().size(); i++) {
            list.add(checkout.getNameLists().get(i).getText());
        }
        Collections.sort(list);
        return list;
    }

    public List sortListOfSelectedProducts(String product1, String product2, String product3) {

        List<String> listOfSelectedProducts = new ArrayList<>();
        String[] products = {product1, product2, product3};

        Collections.addAll(listOfSelectedProducts, products);
        Collections.sort(listOfSelectedProducts);

        return listOfSelectedProducts;
    }

    public void clickDelete(String product) throws Exception {
        click(checkout.getBtnDelete(product));
    }

    public void clickBtnPlaceOrder() throws Exception {
        click(checkout.getBtnPlaceOrder());
    }

    public void sendInfoForPlaceOrder(String name, String country, String city, String creditCard, String month, String year) throws Exception {
        sendKeys(name, checkout.getInputName());
        sendKeys(country, checkout.getInputCountry());
        sendKeys(city, checkout.getInputCity());
        sendKeys(creditCard, checkout.getInputCreditCard());
        sendKeys(month, checkout.getInputMoth());
        sendKeys(year, checkout.getInputYear());
        click(checkout.getBtnPurchase());
    }

    public boolean getTextCreditCard(String creditCard) {
        return getText(checkout.getTextCreditCard(), creditCard);
    }


}
