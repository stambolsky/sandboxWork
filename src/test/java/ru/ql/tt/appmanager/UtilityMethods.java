package ru.ql.tt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import static ru.ql.tt.PageBase.LoginPage.AVATARCOVER;
import static ru.ql.tt.PageBase.LoginPage.LINK_PROFILE;
import static ru.ql.tt.PageBase.LoginPage.login;
import static ru.ql.tt.appmanager.ApplicationManager.properties;
import static ru.ql.tt.appmanager.ApplicationManager.wd;

public class UtilityMethods {
    private static String authProperties = "src/test/resources/authorization.properties";
    private static String urlProperties = "src/test/resources/URL.properties";

    public static void init() {
        open();
        try {
            properties.load(new FileReader(new File(authProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        login(properties.getProperty("login"), properties.getProperty("password"));
    }

    private static void open() {
        try {
            properties.load(new FileReader(new File(urlProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        wd.get(properties.getProperty("LoginPage"));
    }

    public static String getLogin() {
        try {
            properties.load(new FileReader(new File(authProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("login");
    }

    public static String getUrlProfilePage() {
        try {
            properties.load(new FileReader(new File(urlProperties)));
        } catch (NoSuchElementException | IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("ProfilePage");
    }

    public static void goToProfile() {
        waitElement(AVATARCOVER);
        wd.findElement(By.xpath(AVATARCOVER)).click();
        waitElement(LINK_PROFILE);
        wd.findElement(By.xpath(LINK_PROFILE)).click();
    }

    public static void clickWaitElement(String s) {
        waitElement(s);
        wd.findElement(By.xpath(s)).click();
    }

    public static void findClickElement(String s) {
        waitElement(s);
        wd.findElement(By.xpath(s)).click();
    }

    public static void refreshPage() {
        wd.navigate().refresh();
    }

    public static void sendData(String element, String text) {
        waitElement(element);
        wd.findElement(By.xpath(element)).sendKeys(text);
    }

    public static String findGetText(String s) {
        return wd.findElement(By.xpath(s)).getText();
    }

    public static void switchWindow(String idWindow) {
        Set<String> idOpeningWindows = wd.getWindowHandles();
        for (String tab : idOpeningWindows) {
            if (!tab.equals(idWindow)) {
                wd.switchTo().window(tab);
                break;
            }
        }
    }

    public static String getPageUrl() {
        return wd.getCurrentUrl();
    }

    public static void waitCloseWindows(String elementXpath) {
        WebDriverWait wait = new WebDriverWait(wd, 100);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));
    }

    public static void waitElement(String elementXpath) {
        WebDriverWait wait = new WebDriverWait(wd, 100);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(elementXpath))));
    }

    public static void stop() {
        wd.quit();
    }
}
