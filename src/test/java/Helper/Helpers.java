package Helper;

import nopCommerce.ShoppingCartPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;

import static common.TestBase.driver;

public class Helpers {
    WebDriverWait weit = new WebDriverWait(driver, 5);

    public void navigateTo(String link) {
        driver.get(link);
    }

    public void sendKeysUsingActions(String key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key);
        actions.build().perform();
    }

    public void mouseHover(By path){
        WebElement element = driver.findElement(path);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void driverMouseHover(By path){
        WebElement element = driver.findElement(path);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void sendKeys(By path, String text) {
        WebElement element = driver.findElement(path);
        element.sendKeys(text);
    }

    public void clickElement(By path) {
        WebElement element = driver.findElement(path);
        element.click();
    }

    public void selectDropdown(By path, String text) {
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void select(By path) {
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        boolean x = element.isDisplayed();
        if (x == true) {
            element.click();
        }
    }

    public void isSelected(By path) {
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        boolean x = element.isSelected();
        if (x == true) {
            Assert.assertTrue(x);
        }
    }

    public void clickRemoveItemButton(By path ,int i){
        List<WebElement> elements = driver.findElements(path);
        List<WebElement> removeItems = driver.findElements(ShoppingCartPage.removeItemBttn);

        int itemsCount = elements.size();
        if (itemsCount > 0) {
            weit.until(ExpectedConditions.visibilityOfAllElements(removeItems));
            removeItems.get(i).click();
        }
    }

    public void deSelect(By path) {
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        WebElement element = driver.findElement(path);
        boolean x = element.isSelected();
        if (x == true) {
            element.click();
            Assert.assertFalse(element.isSelected());
        }
    }

    public void deleteElementByIndex(By path, int index){
        List<WebElement> elements = driver.findElements(path);
        List<WebElement> removeItems = driver.findElements(ShoppingCartPage.removeItemBttn);
        int itemsCount = elements.size();
        if (itemsCount > 0) {
            removeItems.get(index).click();
        }
    }

    public void assertElementHasText(By path, String expectedText) {
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        String actualText = element.getText();
        Assert.assertEquals(actualText,expectedText);
    }

    public void assertValueOfElementIs(By path, String expectedValue){
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        String actualValue = element.getAttribute("value");
        Assert.assertEquals(actualValue,expectedValue);
    }

    public void clickElement2(By path) {
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }

    public void checkTest(String expectedTittle) {
        String actualTittle = "";
        actualTittle = driver.getTitle();

        if (actualTittle.equals(expectedTittle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println(" ");
        }
    }

    public void selectDropdownByText(By path, String text) {
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By path, int i) {
        List<WebElement> element = driver.findElements(path);
        element.get(i).click();
    }

    public void clickElementByActions(By path) {
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        System.out.println("Element was clicked!");
    }

    public void elementIsDisplayed(By path, String expectedText) {
        WebElement element = driver.findElement(path);
        String actualText = element.getText();
        weit.until(ExpectedConditions.visibilityOf(element));
        //while (element.isDisplayed()) Assert.assertEquals(actualText,expectedText);
        if (element.isDisplayed())
            Assert.assertEquals(actualText,expectedText);
        else
            System.out.println("Element not displayed!");
    }

    public void noOfDisplayedElements(By path, int num) {
        List<WebElement> elements = driver.findElements(path);

        weit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(path));
        int totalLinkSize = elements.size();
        Assert.assertEquals(totalLinkSize, num);
    }

    public void elementNotVisible(By path) { //waitForElementNotToBeVisible
        WebElement element = driver.findElement(path);
        weit.until(ExpectedConditions.visibilityOfElementLocated(path));
        boolean isVisible = ExpectedConditions.invisibilityOf(element).apply(driver).booleanValue();
        if (isVisible)
            System.out.println("Element is invisible");
        else
            System.out.println("Element is invisible Now!");
    }

    public void captureScreenshot(WebDriver driver,String screenshotName) throws Exception{

        String fileWithPath = "C:\\Users\\User\\SeleniumWebdriverMavenDemo\\src\\test\\java\\Screenshots";
        //File DestFile=new File(fileWithPath);
//        File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(source,DestFile);



        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

/*
TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileHandler.copy(source, DestFile);
        System.out.println("Screenshot taken");
 */

    }

}
