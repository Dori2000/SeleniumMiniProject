package PageObject;

import Helper.Helpers;
import nopCommerce.NotebookPage;
import nopCommerce.ShoppingCartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static common.TestBase.driver;

public class EmptyShoppingCart extends Helpers{

    WebDriverWait weit = new WebDriverWait(driver, 5);


    public void clickShoppingCartButton(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.shoppinCartButton));
        clickElement(ShoppingCartPage.shoppinCartButton);
    }

    //1. Delete the first item on shopping cart
    //2. Verify that the number of elements in Shopping Cart table is decreased by 1
    public void deleteItemsOnShoppingCartAndCheckQuantity(int index){
        WebElement element = driver.findElement(ShoppingCartPage.cartLabel);
        String actualString = element.getText();

        deleteElementByIndex(ShoppingCartPage.items, index);

        String actualText = actualString.replaceAll("[^0-9]", "");
        int actualValue = Integer.parseInt(actualText);

        String expectedText = actualString.replaceAll("[^0-9]", "");
        int expectedValue = Integer.parseInt(expectedText);

        if (expectedValue == (actualValue - 1)) Assert.assertEquals(actualValue,expectedValue);
        else System.out.println(" ");
    }

    //2. Verify that the number of elements in Shopping Cart table is decreased by 1
    public void verifyDecreasingNumberOfItemsOnShoppingCart(){
        List <WebElement> shoppingCart = driver.findElements(ShoppingCartPage.items);
        int shoppingCartSize = shoppingCart.size();
        int expectedNumberOfItems = shoppingCartSize-1;
        Assert.assertEquals(shoppingCartSize,expectedNumberOfItems);
    }

    //3. Repeat steps 1&2 until the last item is deleted
    public void deleteAllItems(){
        List <WebElement> shoppingCart = driver.findElements(ShoppingCartPage.items);
        List <WebElement> removeItemBttn = driver.findElements(ShoppingCartPage.removeItemBttn);
        weit.until(ExpectedConditions.visibilityOfAllElements(shoppingCart));
        //while (shoppingCart.size()>0)
        for (int i=0; i<removeItemBttn.size(); i++)
            deleteElementByIndex(ShoppingCartPage.items, 0);
        //for (int i=0; i<sc.removeItemBttn.size(); i++)
            //sc.removeItemBttn.get(i).click();
    }

    //4. Verify that Shopping Cart is empty
    public void verifyQuantityOfShoppingCart(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.cartLable));
        elementIsDisplayed(NotebookPage.cartLable, "(0)");
    }

    //5. Close the browse
    public void closeTheBrowser(){
        driver.close();
        driver.quit();
    }

}
