package PageObject;

import Helper.Helpers;
import Helper.UserCredentials;
import nopCommerce.MyAccPage;
import nopCommerce.NotebookPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.TestBase.driver;

public class MyAccount extends Helpers {
    WebDriverWait weit = new WebDriverWait(driver, 5);
    UserCredentials user = new UserCredentials();

    // 1. Click My Account - Menu
    public void clickMyAccountButton(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.myAccButton));
        clickElement(MyAccPage.myAccButton);
    }

    // 2. Verify we are on “My account - Customer info”-page
    public void verifyThatWeHaveNavigateToMyAccountPage(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(NotebookPage.tittle));
        assertElementHasText(MyAccPage.MyAccPageLabel, "My account - Customer info");
    }

    // 3. Verify that all fields contain the values added from Register test
    public void validateRegistrationFields(){

        // a. Gender
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.GenderMale));
        isSelected(MyAccPage.GenderMale);
        // b. First name
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.name));
        assertValueOfElementIs(MyAccPage.name, user.getEmri());
        // c. Last name
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.surname));
        assertValueOfElementIs(MyAccPage.surname, user.getMbiemri());
        // d. Date of birth (Day, Month, Year)
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.dayOfBirth));
        assertValueOfElementIs(MyAccPage.dayOfBirth, user.getBirthdate());
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.monthOfBirth));
        assertValueOfElementIs(MyAccPage.monthOfBirth, "3");
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.yearOfBirth));
        assertValueOfElementIs(MyAccPage.yearOfBirth, user.getBirthyear());
        // e. Email
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.mail));
        assertValueOfElementIs(MyAccPage.mail, user.getEmail());
        // f. Company Details
        weit.until(ExpectedConditions.visibilityOfElementLocated(MyAccPage.details));
        assertValueOfElementIs(MyAccPage.details, user.getCompany());
    }

    // 4. Log Out
    public void clickLogoutButton (){
        clickElement(MyAccPage.logoutButton);
    }

    // 5. Close Browser
    public void closeTheBrowser(){
        driver.close();
        driver.quit();
    }

}
