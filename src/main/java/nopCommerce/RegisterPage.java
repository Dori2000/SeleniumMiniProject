package nopCommerce;

import org.openqa.selenium.By;

public class RegisterPage {

    public static By male = By.cssSelector("span.male > label");
    public static By female = By.cssSelector("span.female > label");
    public static By firstname = By.cssSelector("#FirstName");
    public static By lastname = By.cssSelector("#LastName");
    public static By email = By.cssSelector("#Email");
    public static By company = By.cssSelector("#Company");
    public static By newsletter = By.cssSelector("#Newsletter");
    public static By dayBirth = By.name("DateOfBirthDay");
    public static By monthBirth = By.name("DateOfBirthMonth");
    public static By yearBirth = By.name("DateOfBirthYear");
    public static By pass = By.xpath("//*[@id=\"Password\"]");
    public static By confirmPass = By.xpath("//*[@id=\"ConfirmPassword\"]");
    public static By finalRegistration = By.xpath("//*[@id=\"register-button\"]");
    public static By registerLabel = By.xpath("//h1[contains(text(),'Register')]");
    public static By logout = By.cssSelector(".ico-logout");



}















