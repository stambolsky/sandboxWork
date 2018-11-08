package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.ql.tt.appmanager.ApplicationManager;

import static ru.ql.tt.PageBase.ProfilePage.NAME_USER;
import static ru.ql.tt.tests.TestBase.app;

public class LoginPage {

    public static String LOGIN = "//input[@id='username']";
    public static String PASSWORD = "//input[@id='password']";
    public static String SUBMIT = "//input[@id='_submit']";
    public static String AVATARCOVER = "//span//div[@class='avatarCover']";
    public static String LINK_PROFILE = "//span[contains(@class,'m-nav__link-text')]";
    private String login;


    public void login(String username, String password){
        checkFieldLoginAndPassword();
        app.wd.findElement(By.xpath(LOGIN)).sendKeys(username);
        app.wd.findElement(By.xpath(PASSWORD)).sendKeys(password);
        app.wd.findElement(By.xpath(SUBMIT)).click();
    }

    public void checkFieldLoginAndPassword() {
        Assert.assertTrue(app.wd.findElement(By.xpath(LOGIN)).isDisplayed());
        Assert.assertTrue(app.wd.findElement(By.xpath(PASSWORD)).isDisplayed());
    }

    public String getLoginFromMainPage() {
        return app.wd.findElement(By.xpath(NAME_USER)).getText();
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
