package nopCommerce;

import org.openqa.selenium.By;

public class NotebookPage {

    public static By attributes_check_16GB = By.id("attribute-option-10");
    public static By displayedElements = By.xpath("//div[@class='products-wrapper']//div[@class='item-box']");
    public static By tittle = By.xpath("//div[@class='page-title']/h1");
    public static By display = By.xpath("//*[@id=\"products-pagesize\"]");
    public static By wishListBtn2 = By.xpath("//div[@data-productid='5']//div[@class='buttons']/button[contains(text(),'Add to wishlist')]");
    public static By wishListBtn3 = By.xpath("//div[@data-productid='8']//div[@class='buttons']/button[contains(text(),'Add to wishlist')]");
    public static By addToCartBtn4 = By.xpath("//div[@data-productid='7']//div[@class='buttons']/button[contains(text(),'Add to cart')]");
    public static By addToCartBtn5 = By.xpath("//div[@data-productid='9']//div[@class='buttons']/button[contains(text(),'Add to cart')]");
    public static By addToCartBtn6 = By.xpath("//div[@data-productid='6']//div[@class='buttons']/button[contains(text(),'Add to cart')]");
    public static By addToCartBtnss = By.xpath("//div[@class='buttons']/button[@class='button-2 product-box-add-to-cart-button']");
    public static By wishListBtnss = By.xpath("//div[@class='buttons']/button[@class='button-2 add-to-wishlist-button']");
    public static By content = By.xpath("//div[@class='bar-notification success']");
    public static By cartLable = By.xpath("//a[@class='ico-cart']/span[@class='cart-qty']");
    public static By wishListLable = By.xpath("//a[@class='ico-wishlist']/span[@class='wishlist-qty']");

}
