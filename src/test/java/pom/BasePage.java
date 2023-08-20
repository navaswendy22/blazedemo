package pom;

import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class BasePage {

    private static final int WAIT_TIMEOUT = 30;
    protected WebDriver driver;
    protected Actions action;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, 30);
        action = new Actions(driver);

    }

    protected void click(WebElement element) throws Exception {
        isClickeable(element);
        element.click();
    }

    public void click(By selector) throws Exception {
        isClickeable(selector);
        WebElement element = driver.findElement(selector);
        element.click();
    }

    protected void isClickeable(By element) throws Exception {
        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new Exception("El elemento no es clickeable " + element);
        }
    }

    protected void isClickeable(WebElement element) throws Exception {
        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new Exception("El elemento no es clickeable " + element);
        }
    }

    protected boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilElementIsVisible(WebElement element) {
        try {
            await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
        } catch (ConditionTimeoutException e) {
            throw new ConditionTimeoutException(String.format("No se encuentra el elemento despues de 30 segundos\nElemento: %s", element));
        }
    }

    public void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException ignored) {

        }
    }

    protected void sendKeys(String inputText, WebElement element) {
        waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(inputText);
    }

    protected boolean getText(WebElement element, String text) {
        try {
            waitUntilElementIsVisible(element);
            return element.getText().contains(text);
        } catch (Exception e) {
            return false;
        }
    }
}