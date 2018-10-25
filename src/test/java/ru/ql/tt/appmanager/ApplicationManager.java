package ru.ql.tt.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.By.xpath;

public class ApplicationManager {
    public static WebDriver wd;
    private String browser;
    static Properties properties;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void createBrowser() {
        if (browser.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(5, SECONDS);
    }
}

