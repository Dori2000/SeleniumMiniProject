package PageObject;

import Helper.Helpers;
import Helper.UserCredentials;
import nopCommerce.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static common.TestBase.driver;

public class UserRegistration extends Helpers {

    WebDriverWait weit = new WebDriverWait(driver, 5);
    UserCredentials user = new UserCredentials();

    public void registerWithCredentials(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(RegisterPage.finalRegistration));
        clickElement(RegisterPage.male);
        sendKeys(RegisterPage.firstname, user.getEmri());
        sendKeys(RegisterPage.lastname, user.getMbiemri());
        selectDropdownByText(RegisterPage.dayBirth, user.getBirthdate());
        selectDropdownByText(RegisterPage.monthBirth, user.getBirthmonth());
        selectDropdownByText(RegisterPage.yearBirth, user.getBirthyear());
        sendKeys(RegisterPage.email, user.getEmail());
        sendKeys(RegisterPage.company,  user.getCompany());
        clickElement(RegisterPage.newsletter);
        sendKeys(RegisterPage.pass, user.getPassword());
        sendKeys(RegisterPage.confirmPass, user.getPassword());
        clickElement(RegisterPage.finalRegistration);
    }

    public void getRegistrationTittle(String requiredTittle){
        WebElement element = driver.findElement(RegisterPage.registerLabel);
        String actualTittle = element.getText();
        Assert.assertEquals(actualTittle,requiredTittle);
    }

    public void validateUserRegistration(String expectedTittle){
        checkTest(expectedTittle);
    }

    public void clickLogoutButton (){
        clickElement(RegisterPage.logout);
    }

}
