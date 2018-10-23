package ru.ql.tt.appmanager;

import org.openqa.selenium.By;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import static ru.ql.tt.PageBase.LoginPage.AVATARCOVER;
import static ru.ql.tt.PageBase.LoginPage.LINK_PROFILE;
import static ru.ql.tt.PageBase.LoginPage.login;
import static ru.ql.tt.appmanager.ApplicationManager.properties;
import static ru.ql.tt.appmanager.ApplicationManager.wd;

public class UtilityMethods {

    public static void init() throws IOException {
        open();
        properties.load(new FileReader(new File("src/test/resources/authorization.properties")));
        login(properties.getProperty("login"), properties.getProperty("password"));
    }

    private static void open() throws IOException {
        properties.load(new FileReader(new File("src/test/resources/URL.properties")));
        wd.get(properties.getProperty("LoginPage"));
    }

    public static String getLogin() throws IOException {
        properties.load(new FileReader(new File("src/test/resources/authorization.properties")));
        return properties.getProperty("login");
    }

    public static String getUrlProfilePage() throws IOException {
        properties.load(new FileReader(new File("src/test/resources/URL.properties")));
        return properties.getProperty("ProfilePage");
    }

    public static void goToProfile() {
        wd.findElement(By.xpath(AVATARCOVER)).click();
        wd.findElement(By.xpath(LINK_PROFILE)).click();
    }

    public static void clickWaitElement(String s, int i) throws InterruptedException {
        wd.findElement(By.xpath(s)).click();
        Thread.sleep(i);
    }

    public static void findClickElement(String s) {
        wd.findElement(By.xpath(s)).click();
    }

    public static void refreshPage() throws InterruptedException {
        wd.navigate().refresh();
        Thread.sleep(5000);
    }

    public static void sendData(String element, String text) {
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

    public static void stop() {
        wd.quit();
    }
}
