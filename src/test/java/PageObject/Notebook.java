package PageObject;

import Helper.Helpers;
import nopCommerce.NotebookPage;
import nopCommerce.theMain;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.TestBase.driver;

public class Notebook extends Helpers {
    WebDriverWait wait = new WebDriverWait(driver, 5);


    //1. Mouse hover on Notebook
    public void mouseHoverOnNotebook(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(theMain.computeHoverBtn));
        driverMouseHover(theMain.computeHoverBtn);
    }


    //2. Click Notebooks
    public void clickNoteBooks(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(theMain.notebooks));
        clickElement(theMain.notebooks);
    }


    //3. Verify that we have navigate to Notebooks Page
    public void verifyThatWeHaveNavigateToNotebookPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.tittle));
        assertElementHasText(NotebookPage.tittle, "Notebooks");
    }


    //4. Choose 9 on Display dropdown
    public void choose_9_onDisplayDropdown(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.display));
        selectDropdown(NotebookPage.display, "9");
    }


    //5. + //9. Verify that only 6 items are displayed
    public void verifyThatOnly_6_itemsAreDisplayed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(NotebookPage.displayedElements));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(NotebookPage.displayedElements));
        wait.until(ExpectedConditions.numberOfElementsToBe(NotebookPage.displayedElements,6));
        noOfDisplayedElements(NotebookPage.displayedElements, 6);
        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }


    //6. On Filter by attributes check 16GB
    public void check_16GB_onFilterByAttributes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.attributes_check_16GB));
        clickElement2(NotebookPage.attributes_check_16GB);
    }


    //7. Verify that only 1 item is displayed
    public void verifyThatOnly_1_itemsAreDisplayed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(NotebookPage.displayedElements));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(NotebookPage.displayedElements));
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.displayedElements));
        wait.until(ExpectedConditions.numberOfElementsToBe(NotebookPage.displayedElements,1));
        noOfDisplayedElements(NotebookPage.displayedElements, 1);
        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    }


    //8. Uncheck the 16GB checkbox
    public void uncheck_16GB_onFilterByAttributes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.attributes_check_16GB));
        deSelect(NotebookPage.attributes_check_16GB);
    }


    //10.Add the third item on wishlist
    public void addItemsOnWishlist(){
//        weit.until(ExpectedConditions.presenceOfElementLocated(NotebookPage.wishListBtn3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.wishListBtn3));
        clickElement2(NotebookPage.wishListBtn3);
    }


    //11.Verify that after every adding a notification with text:
    //The product has been added to your wishlist – is displayed
    public void verifyThatItemsHaveBeenAddedToWishlist(){
        wait.until(ExpectedConditions.presenceOfElementLocated(NotebookPage.content));
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.content));
        elementIsDisplayed(NotebookPage.content, "The product has been added to your wishlist");
        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }


    //12.Add the fourth, fifth and sixth item on Shopping Cart
    public void addItemOnShoppingCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.addToCartBtn4));
        clickElement2(NotebookPage.addToCartBtn4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.addToCartBtn5));
        clickElement2(NotebookPage.addToCartBtn5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.addToCartBtn6));
        clickElement2(NotebookPage.addToCartBtn6);
    }

    //13.Verify that after every adding a notification with text:
    // The product has been added to your shopping cart
    public void verifyThatItemsHaveBeenAddedToShoppingCart(){
        wait.until(ExpectedConditions.presenceOfElementLocated(NotebookPage.content));
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.content));
        elementIsDisplayed(NotebookPage.content, "The product has been added to your shopping cart");
    }


    //14.Wait notification from step 13 to be invisible
    public void waitForElementNotToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.content));
        elementNotVisible(NotebookPage.content);
    }


    //15.Verify that Wishlist on Menu bar displays 2
    public void verifyQuantityOfWishlist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.wishListLable));
        elementIsDisplayed(NotebookPage.wishListLable, "(1)");
    }


    //16.Verify that Shopping Cart on Menu bar displays 3
    public void verifyQuantityOfShoppingCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.cartLable));
        elementIsDisplayed(NotebookPage.cartLable, "(3)");
    }


    //17.Close the browser
    public void closeTheBrowser(){
        driver.close();
        driver.quit();
    }


}
