package ru.ql.tt.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;
    private String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void checkBrowser() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void init() {
        open();
        login("Мистер АвтоМяу", "12345678");
    }

    public void open() {
        wd.get("http://tt-develop.quality-lab.ru/login");
    }

    private void login(String username, String password) {
        Assert.assertTrue(wd.findElement(By.xpath("//input[@id='username']")).isDisplayed());
        Assert.assertTrue(wd.findElement(By.xpath("//input[@id='password']")).isDisplayed());
        wd.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        wd.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        wd.findElement(By.xpath("//input[@id='_submit']")).click();
    }

    public String checkPageUrl() {
        String page = wd.getCurrentUrl();
        return page;
    }

    public void goToProfile() {
        wd.findElement(By.xpath("//span[contains(@class,'m-topbar__userpic')]//div//div[contains(@class,'avatarCover')]")).click();
        wd.findElement(By.xpath("//span[contains(@class,'m-nav__link-text')]")).click();
    }

    public void stop() {
        wd.quit();
    }

    public String getLogin() {
        String name = wd.findElement(By.xpath("//span[@id='headerName']")).getText();
        return name;
    }

}

