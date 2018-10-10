package ru.ql.tt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.appmanager.XpathElementsBase.*;

public class ApplicationManager {
    public WebDriver wd;
    private String browser;
    private final Properties properties;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void checkBrowser() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void init() throws IOException {
        open();
        properties.load(new FileReader(new File("src/test/resources/authorization.properties")));
        login(properties.getProperty("login"), properties.getProperty("password"));
    }

    public void open() throws IOException {
        properties.load(new FileReader(new File("src/test/resources/URL.properties")));
        wd.get(properties.getProperty("LoginPage"));
    }
    public String getLogin() throws IOException {
        properties.load(new FileReader(new File("src/test/resources/authorization.properties")));
        String login = properties.getProperty("login");
        return login;
    }

    public String getUrlProfilePage() throws IOException {
        properties.load(new FileReader(new File("src/test/resources/URL.properties")));
        String url = properties.getProperty("ProfilePage");
        return url;

    }


    private void login(String username, String password){
        checkFieldLoginAndPassword();
        wd.findElement(By.xpath(LOGIN)).sendKeys(username);
        wd.findElement(By.xpath(PASSWORD)).sendKeys(password);
        wd.findElement(By.xpath(SUBMIT)).click();
    }

    private void checkFieldLoginAndPassword() {
        Assert.assertTrue(wd.findElement(By.xpath(LOGIN)).isDisplayed());
        Assert.assertTrue(wd.findElement(By.xpath(PASSWORD)).isDisplayed());
    }

    public String checkPageUrl() {
        String page = wd.getCurrentUrl();
        return page;
    }

    public void goToProfile() {
        wd.findElement(By.xpath(AVATARCOVER)).click();
        wd.findElement(By.xpath(LINK_PROFILE)).click();
    }

    public void stop() {
        wd.quit();
    }

    public String getLoginNew() {
        String name = wd.findElement(By.xpath(NAME_USER)).getText();
        return name;
    }

    public boolean UserPhotoAboveResume() {
        boolean res = true;
        int firstElement = wd.findElement(By.xpath(AVATAR)).getLocation().getX();
        int secondElement = wd.findElement(By.xpath(BLOCK_RESUME)).getLocation().getY();
        if (firstElement - secondElement > 0) {
            res = false;
        }
        return res;
    }

    public boolean checkColorButtonCreateResume() {
        boolean res = true;
        String color = wd.findElement(By.xpath(BUTTON_CREATE_RESUME)).getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        if (!hex.equals("#716aca")) {
            res = false;
        }
        return res;
    }

    public boolean allElementsBlock() {
        String[] elements = {HEADER, LOGO, BLOCK_MENU, TITLE_PROFILE, BLOCK_RESUME, BLOCK_SCHEDULE_WORK
                ,BLOCK_CONTACTS,BLOCK_DEVICES};
        return allElementInBlock(elements);
    }

    private boolean allElementInBlock(String[] elements) {
        return listElements(elements).size() == elements.length;
    }

    private Collection listElements(String[] elements) {
        List<String> listOfElements = new LinkedList<String>();
        for (String element : elements) {
            try {
                if (wd.findElement(By.xpath(element)).isDisplayed()) {
                    listOfElements.add(element);
                }
            } catch (Exception e) {
                System.out.println("Element is not displayed:" + element);
            }
        }
        return listOfElements;
    }

    public void refreshPage() throws InterruptedException {
        wd.navigate().refresh();
        Thread.sleep(5000);
    }

    public void clickWaitElement(String s, int i) throws InterruptedException {
        wd.findElement(By.xpath(s)).click();
        Thread.sleep(i);
    }

    public void findClickElement(String s) {
        wd.findElement(By.xpath(s)).click();
    }

    public void addDevice() throws InterruptedException {
        clickWaitElement(BUTTON_ADD_DEVICES, 500);
        findClickElement(TYPE_PC);
        findClickElement(TYPE_OS_LINUX);
        findClickElement(BUTTON_DEVICE_SAVE);
        refreshPage();
    }

    public void sendData(String element, String text) {
        wd.findElement(By.xpath(element)).sendKeys(text);
    }

    public String findGetText(String s) {
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

    public void checkNotSaveFormDevices(String button) throws InterruptedException {
        addDevice();
        String typeDevice = wd.findElement(By.xpath(TABLE_FIELD_TYPE_PC)).getAttribute("data-type");
        clickWaitElement(TABLE_ICON_EDIT, 500);
        findClickElement(EDIT_WINDOW_OS_ANDROID);
        clickWaitElement(button, 500);
        Assert.assertEquals(typeDevice, wd.findElement(By.xpath(TABLE_FIELD_TYPE_PC)).getAttribute("data-type"));
        clickWaitElement(TABLE_ICON_TRASH, 500);
        clickWaitElement(BUTTON_DELETE_DEVICE, 2000);
    }

    public void checkNotSaveFormContacts(String modalEditButtonCloseNotSave) throws InterruptedException {
        clickWaitElement(BUTTON_EDIT_CONTACTS, 500);
        wd.findElement(By.xpath(MODAL_EDIT_EMAIL)).clear();
        sendData(MODAL_EDIT_EMAIL, "test@test.test");
        clickWaitElement(modalEditButtonCloseNotSave, 1000);
        String email = findGetText(PROFILE_CONTACTS_FIELD_EMAIL);
        assertFalse(email.equalsIgnoreCase("test@test.test"));
        wd.navigate().refresh();
        clickWaitElement(BUTTON_EDIT_CONTACTS, 500);
        assertTrue(wd.findElement(By.xpath(MODAL_EDIT_EMAIL)).getAttribute("value").equalsIgnoreCase(email));
        clickWaitElement(MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE, 2000);
    }

    public void changeContactsInfo(String phone, String skype) throws InterruptedException {
        clickWaitElement(BUTTON_EDIT_CONTACTS, 500);
        assertTrue(wd.findElement(By.xpath(MODAL_WINDOW_EDIT_CONTACTS)).isDisplayed());
        Assert.assertEquals(findGetText(TITLE_MODAL_WINDOW_EDIT_CONTACTS),"Изменение контактной информации");
        wd.findElement(By.xpath(MODAL_EDIT_PHONE_FIELD)).clear();
        sendData(MODAL_EDIT_PHONE_FIELD, phone);
        wd.findElement(By.xpath(MODAL_EDIT_SKYPE_FIELD)).clear();
        sendData(MODAL_EDIT_SKYPE_FIELD, skype);
        clickWaitElement(MODAL_EDIT_SAVE_BUTTON, 5000);
    }

    public void checkNotSaveFormResume(String modalResumeEditIconCross) throws InterruptedException {
        clickWaitElement(PROFILE_RESUME_BUTTON_EDIT, 1000);
        wd.findElement(By.xpath(MODAL_WINDOW_EDIT_TEXTAREA)).clear();
        sendData(MODAL_WINDOW_EDIT_TEXTAREA, "Финансист");
        findClickElement(MODAL_WINDOW_EDIT_TIP_TEXTAREA);
        clickWaitElement(modalResumeEditIconCross, 1000);
        String before = findGetText(PROFILE_RESUME_SHORT_RESUME);
        clickWaitElement(PROFILE_RESUME_BUTTON_EDIT, 1000);
        String after = findGetText(MODAL_WINDOW_EDIT_TEXTAREA);
        if (after.equals("")) {
            after = "Краткое резюме не указано";
        }
        Assert.assertEquals(before, after);
        clickWaitElement(modalResumeEditIconCross, 2000);
    }

    public void checkNotSaveFormScheduleWork(String modalWindowEditIconCross) throws InterruptedException {
        clickWaitElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT, 500);
        findClickElement(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK);
        findClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        findClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
        String beforeStart = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeEnd = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        clickWaitElement(modalWindowEditIconCross, 2000);
        String after = findGetText(PROFILE_TABLE_TIME_MONDAY);
        assertNotEquals(after, beforeTime);
        wd.navigate().refresh();
        clickWaitElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT, 500);
        String afterRefresh = after.substring(0,5);
        String afterStart = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        Assert.assertEquals(afterStart, afterRefresh);
        clickWaitElement(MODAL_WINDOW_EDIT_ICON_CROSS, 2000);
    }

    public void changeTimeScheduleWork() {
        findClickElement(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK);
        findClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        findClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
        findClickElement(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK);
        findClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        findClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
    }

}

