package ru.ql.tt.appmanager;

import com.sun.deploy.config.VerboseDefaultConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ql.tt.PageBase.LoginPage;
import ru.ql.tt.PageBase.ProfilePage;
import ru.ql.tt.PageBase.ProfileResumePage;
import ru.ql.tt.tests.TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import static ru.ql.tt.PageBase.LoginPage.AVATARCOVER;
import static ru.ql.tt.PageBase.LoginPage.LINK_PROFILE;
import static ru.ql.tt.appmanager.ApplicationManager.wd;

public class UtilityMethods {
    public ProfilePage profilePage;
    public ProfileResumePage profileResumePage;
    private LoginPage loginPage = new LoginPage();
    private String authProperties = "src/test/resources/authorization.properties";
    private String urlProperties = "src/test/resources/URL.properties";
    private Properties properties = new Properties();

    public void init() {
        open();
        loginPage.login(getLogin(), getPassword());
    }

    private void open() {
        try {
            properties.load(new FileReader(new File(urlProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        wd.get(properties.getProperty("LoginPage"));
    }

    public String getLogin() {
        try {
            properties.load(new FileReader(new File(authProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("login");
    }

    public String getPassword() {
        try {
            properties.load(new FileReader(new File(authProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("password");
    }

    public String getUrlProfilePage() {
        try {
            properties.load(new FileReader(new File(urlProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("ProfilePage");
    }

    public void goToProfile() {
        waitElement(AVATARCOVER);
        wd.findElement(By.xpath(AVATARCOVER)).click();
        waitElement(LINK_PROFILE);
        wd.findElement(By.xpath(LINK_PROFILE)).click();
    }

    public void waitAndClickElement(String elementXpath) {
        waitElement(elementXpath);
        wd.findElement(By.xpath(elementXpath)).click();
    }

    public void refreshPage() {
        wd.navigate().refresh();
    }

    public void writeTextInField(String element, String text) {
        waitElement(element);
        wd.findElement(By.xpath(element)).sendKeys(text);
    }

    public String getTextFromElement(String s) {
        return wd.findElement(By.xpath(s)).getText();
    }

    public void switchWindow(String idWindow) {
        Set<String> idOpeningWindows = wd.getWindowHandles();
        for (String tab : idOpeningWindows) {
            if (!tab.equals(idWindow)) {
                wd.switchTo().window(tab);
                break;
            }
        }
    }

    public String getPageUrl() {
        return wd.getCurrentUrl();
    }

    public void waitCloseWindows(String elementXpath) {
        WebDriverWait wait = new WebDriverWait(wd, 100);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));
    }

    public void waitElement(String elementXpath) {
        WebDriverWait wait = new WebDriverWait(wd, 100);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(elementXpath))));
    }

    public void stopBrowser() {
        wd.quit();
    }
}
