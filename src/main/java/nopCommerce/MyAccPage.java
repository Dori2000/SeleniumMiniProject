package nopCommerce;

import org.openqa.selenium.By;

public class MyAccPage {

    public static By MyAccPageLabel = By.xpath("//h1[contains(text(),'My account - Customer info')]");
    public static By myAccButton = By.xpath("//div[@class='header-links']//a[@class='ico-account']");
    public static By registerButton = By.cssSelector(".ico-account");
    public static By GenderMale = By.cssSelector("#gender-male");
    public static By name = By.cssSelector("#FirstName");
    public static By surname = By.cssSelector("#LastName");
    public static By dayOfBirth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthDay']");
    public static By monthOfBirth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthMonth']");
    public static By yearOfBirth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthYear']");
    public static By mail = By.cssSelector("#Email");
    public static By details = By.cssSelector("#Company");
    public static By logoutButton = By.cssSelector(".ico-logout");









}
