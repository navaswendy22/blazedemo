package steps;

import org.openqa.selenium.WebDriver;
import pom.actions.AddProductAction;
import pom.actions.CheckoutsAction;

public class BaseTest {
    protected WebDriver driver = Hooks.getDriver();
    protected AddProductAction home = new AddProductAction(driver);
    protected CheckoutsAction checkout = new CheckoutsAction(driver);

}
