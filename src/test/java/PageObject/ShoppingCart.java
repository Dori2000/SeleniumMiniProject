package PageObject;

import Helper.Helpers;
import nopCommerce.ShoppingCartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static common.TestBase.driver;

public class ShoppingCart extends Helpers {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    EmptyShoppingCart cart = new EmptyShoppingCart();

    // 1. Hover over Shopping Cart – Menu
    public void mouseHoverOnShoppingCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.shoppinCartButton));
        driverMouseHover(ShoppingCartPage.shoppinCartButton);
    }
    // 2. Verify that ‘Go To Cart’ – button is displayed
    public void verifyThatGoToCartIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.goToCartBttn));
        elementIsDisplayed(ShoppingCartPage.goToCartBttn, "GO TO CART");
    }
    // 3. Click ‘Go To Cart’ – button
    public void clickShoppingCartButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.goToCartBttn));
        clickElement(ShoppingCartPage.goToCartBttn);
    }
    // 4. Verify that we have navigate to Shopping Cart Page
    public void verifyNavigationToShoppingCartPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.shoppingCartTittle));
        elementIsDisplayed(ShoppingCartPage.shoppingCartTittle, "Shopping cart");
    }
    // 5. Verify that following buttons are displayed
    public void verifyThatButtonsAreDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.updateShoppingCartBtn));
        elementIsDisplayed(ShoppingCartPage.updateShoppingCartBtn, "Update shopping cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.continueShoppingBtn));
        elementIsDisplayed(ShoppingCartPage.continueShoppingBtn, "Continue shopping");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.estimateShippingBtn));
        elementIsDisplayed(ShoppingCartPage.estimateShippingBtn, "Estimate shipping");
    }
    // 6. Verify that the prices sum for all items is equal to Total Price in the end of the page
    public void verifySumPrices(){
        //List<WebElement> shoppingCart = driver.findElements(ShoppingCartPage.items);
        List <WebElement> itemPrice = driver.findElements(ShoppingCartPage.itemSubtotal);
        wait.until(ExpectedConditions.visibilityOfAllElements(itemPrice));

        WebElement totalPrice = driver.findElement(ShoppingCartPage.orderTotal);

        //Marrim vtm cmimin nga label
        String orderTotal = totalPrice.getText();
        String actualorderTotal = orderTotal.replaceAll("[^0-9]", "");

        int actualorder = Integer.parseInt(actualorderTotal);
        int sumOfactualValue = 0;

        for (int i=0; i<itemPrice.size(); i++){
            String actualPrice = itemPrice.get(i).getText();
            String actualSubtotal = actualPrice.replaceAll("[^0-9]", "");
            int actualValue = Integer.parseInt(actualSubtotal);
            sumOfactualValue += actualValue;
        }

        Assert.assertEquals(sumOfactualValue,actualorder);
        System.out.println("Successful Verification!");


    }
}
