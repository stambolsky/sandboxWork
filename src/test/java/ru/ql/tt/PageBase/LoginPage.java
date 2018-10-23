package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import static ru.ql.tt.PageBase.ProfilePage.NAME_USER;
import static ru.ql.tt.appmanager.ApplicationManager.wd;

public class LoginPage {

    public static String LOGIN = "//input[@id='username']";
    public static String PASSWORD = "//input[@id='password']";
    public static String SUBMIT = "//input[@id='_submit']";
    public static String AVATARCOVER = "//span//div[@class='avatarCover']";
    public static String LINK_PROFILE = "//span[contains(@class,'m-nav__link-text')]";

    public LoginPage() {
        super();
    }

    public static void login(String username, String password){
        checkFieldLoginAndPassword();
        wd.findElement(By.xpath(LOGIN)).sendKeys(username);
        wd.findElement(By.xpath(PASSWORD)).sendKeys(password);
        wd.findElement(By.xpath(SUBMIT)).click();
    }

    public static void checkFieldLoginAndPassword() {
        Assert.assertTrue(wd.findElement(By.xpath(LOGIN)).isDisplayed());
        Assert.assertTrue(wd.findElement(By.xpath(PASSWORD)).isDisplayed());
    }

    public static String getLoginNew() {
        return wd.findElement(By.xpath(NAME_USER)).getText();
    }



}
