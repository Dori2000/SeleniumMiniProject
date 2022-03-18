package nopCommerceTESTS;

import Helper.Helpers;
import PageObject.*;
import common.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestBrowser extends TestBase{

    //Test 1
    @Test(priority = 1)
    public void userRegistrationTest() throws InterruptedException{

        test = extent.createTest("Registration on nopCommerce", "Case 1: Test!")
                .assignCategory("e2e testing")
                .assignAuthor("Dori");
        driver.manage().window().maximize();


        UserRegistration registration = new UserRegistration();
        UserLogin login = new UserLogin();
        Helpers help = new Helpers();

        //1. Navigoni ne : https://demo.nopcommerce.com/
        help.navigateTo("https://demo.nopcommerce.com/");
        //2. Kliko LogIn Menu
        login.clickLoginButtonHomePage();
        //3. Kliko butonin Register
        login.clickRegisterButton();
        //4. Printo titullin e faqes pas klikimit te butonit Register
        registration.getRegistrationTittle("Register");
        //5. Plotesoni formen e regjistrimit
        registration.registerWithCredentials();
        //6. Verifikoni qe regjistrimi u krye me sukses
        registration.validateUserRegistration("Your registration completed");
        //7. Kliko Log out Menu
        registration.clickLogoutButton();
        //8. Kliko LogIn Menu
        login.clickLoginButtonHomePage();
        //9. Logohuni ne aplikacion me te dhenat qe krijuat me pare
        login.loginWithCredentials();
        //10.Verifiko qe logimi u krye me sukses
        login.validateUserLogin("Welcome to our store");
        //11.Log out
        registration.clickLogoutButton();
    }

    //Test 2
    @Test(priority = 2)
    public void notebookTest() throws InterruptedException{

        test = extent.createTest("Buy on nopCommerce", "Case 2: Test Shopping cards!")
                .assignCategory("e2e testing")
                .assignAuthor("Dori");
        driver.manage().window().maximize();

        UserLogin login = new UserLogin();
        Helpers help = new Helpers();
        Notebook notebook = new Notebook();

        //Precondition: Log in nopCommerce Application
        help.navigateTo("https://demo.nopcommerce.com/");
        login.clickLoginButtonHomePage();
        login.loginWithCredentials();

        //1. Hover over Computers Menu
        notebook.mouseHoverOnNotebook();
        //2. Click Notebooks
        notebook.clickNoteBooks();
        //3. Verify that we have navigate to Notebooks Page
        notebook.verifyThatWeHaveNavigateToNotebookPage();
        //4. Choose 9 on Display dropdown
        notebook.choose_9_onDisplayDropdown();
        //5. Verify that only 6 items are displayed
        notebook.verifyThatOnly_6_itemsAreDisplayed();
        //6. On Filter by attributes check 16GB
        notebook.check_16GB_onFilterByAttributes();
        //7. Verify that only 1 item is displayed
        notebook.verifyThatOnly_1_itemsAreDisplayed();
        //8. Uncheck the 16GB checkbox
        notebook.uncheck_16GB_onFilterByAttributes();
        //9. Verify that 6 items are displayed now
        notebook.verifyThatOnly_6_itemsAreDisplayed();
        //10.Add the second and the third item on wishlist
        notebook.addItemsOnWishlist();
        //11.Verify that after every adding a notification with text:
        //The product has been added to your wishlist – is displayed
        notebook.verifyThatItemsHaveBeenAddedToWishlist();
        //12.Add the fourth, fifth and sixth item on Shopping Cart
        notebook.addItemOnShoppingCart();
        //13.Verify that after every adding a notification with text:
        // The product has been added to your shopping cart
        notebook.verifyThatItemsHaveBeenAddedToShoppingCart();
        //14.Wait notification from step 13 to be invisible
        notebook.waitForElementNotToBeVisible();
        //15.Verify that Wishlist on Menu bar displays 1
        notebook.verifyQuantityOfWishlist();
        //16.Verify that Shopping Cart on Menu bar displays 3
        notebook.verifyQuantityOfShoppingCart();
        //17.Close the browser
        notebook.closeTheBrowser();

    }

    //Test 3
    @Test(priority = 3)
    public void myAccountTest() throws InterruptedException{
        test = extent.createTest("Registration on nopCommerce", "Case 1: Test!")
                .assignCategory("e2e testing")
                .assignAuthor("Dori");
        driver.manage().window().maximize();

        MyAccount acc = new MyAccount();
        Helpers help = new Helpers();
        UserLogin login = new UserLogin();


        // Precondition: Log in nopCommerce Application
        help.navigateTo("https://demo.nopcommerce.com/");
        login.clickLoginButtonHomePage();
        login.loginWithCredentials();

        // 1. Click My Account - Menu
        acc.clickMyAccountButton();
        // 2. Verify we are on “My account - Customer info”-page
        acc.verifyThatWeHaveNavigateToMyAccountPage();
        // 3. Verify that all fields contain the values added from Register test
        acc.validateRegistrationFields();
        // 4. Log Out
        acc.clickLogoutButton();
        // 5. Close Browser
        acc.closeTheBrowser();

    }

    //Test 4
    @Test(priority = 4)
    public void shoppingCartTest() throws InterruptedException{
        test = extent.createTest("Registration on nopCommerce", "Case 1: Test!")
                .assignCategory("e2e testing")
                .assignAuthor("Dori");
        driver.manage().window().maximize();

        Helpers help = new Helpers();
        UserLogin login = new UserLogin();
        ShoppingCart sc = new ShoppingCart();

        help.navigateTo("https://demo.nopcommerce.com/");
        login.clickLoginButtonHomePage();
        login.loginWithCredentials();

        // 1. Hover over Shopping Cart – Menu
        sc.mouseHoverOnShoppingCart();
        // 2. Verify that ‘Go To Cart’ – button is displayed
        sc.verifyThatGoToCartIsDisplayed();
        // 3. Click ‘Go To Cart’ – button
        sc.clickShoppingCartButton();
        // 4. Verify that we have navigate to Shopping Cart Page
        sc.verifyNavigationToShoppingCartPage();
        // 5. Verify that following buttons are displayed
        sc.verifyThatButtonsAreDisplayed();
        // 6. Verify that the prices sum for all items is equal to Total Price in the end of the page
        sc.verifySumPrices();


    }

    //Test 5
    @Test(priority = 5)
    public void emptyShoppingCartTest() throws InterruptedException{
        test = extent.createTest("Registration on nopCommerce", "Case 1: Test!")
                .assignCategory("e2e testing")
                .assignAuthor("Dori");
        driver.manage().window().maximize();

        Helpers help = new Helpers();
        UserLogin login = new UserLogin();
        EmptyShoppingCart cart = new EmptyShoppingCart();

        //Precondition: Some Items are already added to shopping cart
        help.navigateTo("https://demo.nopcommerce.com/");
        login.clickLoginButtonHomePage();
        login.loginWithCredentials();
        cart.clickShoppingCartButton();

        //1. Delete the first item on shopping cart and verify that the number
        // of elements in Shopping Cart table is decreased by 1
        cart.deleteItemsOnShoppingCartAndCheckQuantity(0);

        //2. Verify that the number of elements in Shopping Cart table is decreased by 1
        //cart.verifyDecreasingNumberOfItemsOnShoppingCart();

        //3. Repeat steps 1&2 until the last item is deleted
        cart.deleteAllItems();

        //4. Verify that Shopping Cart is empty
        cart.verifyQuantityOfShoppingCart();

        //5. Close the browse
        cart.closeTheBrowser();


    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        Helpers help = new Helpers();
        if (result.getStatus() == ITestResult.FAILURE)  help.captureScreenshot(driver,result.getName());
         else if (result.getStatus() == ITestResult.SKIP) test.skip(result.getName() + " test case is skipped.");
         else if (result.getStatus() == ITestResult.SUCCESS) test.pass(result.getName() + " test case is Passed.");
    }


}
