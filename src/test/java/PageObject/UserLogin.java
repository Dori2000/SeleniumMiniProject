package PageObject;

import Helper.Helpers;
import Helper.UserCredentials;
import nopCommerce.LoginPage;
import nopCommerce.theMain;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.TestBase.driver;

public class UserLogin extends Helpers {

    WebDriverWait weit = new WebDriverWait(driver, 5);
    UserCredentials user = new UserCredentials();

    public void loginWithCredentials(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
        clickElement(LoginPage.loginButton);
        sendKeys(LoginPage.email, user.getEmail());
        sendKeys(LoginPage.password,  user.getPassword());
        clickElement(LoginPage.loginButton);
    }

    public void clickLoginButtonHomePage(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(theMain.login));
        clickElement(theMain.login);
    }

    public void clickRegisterButton(){
        weit.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.registerButton));
        clickElement(LoginPage.registerButton);
    }

    public void validateUserLogin(String expectedTittle){
        weit.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.welcomeLabel2));
        assertElementHasText(LoginPage.welcomeLabel2,expectedTittle);
    }

}
