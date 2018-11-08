package ru.ql.tt.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import java.util.Properties;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ApplicationManager {
    public static WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        Properties properties = new Properties();
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

