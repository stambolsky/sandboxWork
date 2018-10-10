package ru.ql.tt.tests;import org.openqa.selenium.By;import org.openqa.selenium.remote.BrowserType;import org.testng.annotations.AfterClass;import org.testng.annotations.BeforeClass;import ru.ql.tt.appmanager.ApplicationManager;import java.util.Set;import static org.testng.Assert.assertEquals;import static org.testng.Assert.assertFalse;import static org.testng.Assert.assertTrue;import static ru.ql.tt.appmanager.XpathElementsBase.*;public class TestBase {    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);    @BeforeClass    public static void setUp() throws Exception {        app.checkBrowser();        app.init();        app.goToProfile();    }    @AfterClass    public static void tearDown(){        app.stop();    }    /*public void changeContactsInfo(String phone, String skype) throws InterruptedException {        app.clickWaitElement(BUTTON_EDIT_CONTACTS, 500);        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_CONTACTS)).isDisplayed());        assertEquals(app.findGetText(TITLE_MODAL_WINDOW_EDIT_CONTACTS),"Изменение контактной информации");        app.wd.findElement(By.xpath(MODAL_EDIT_PHONE_FIELD)).clear();        app.sendData(MODAL_EDIT_PHONE_FIELD, phone);        app.wd.findElement(By.xpath(MODAL_EDIT_SKYPE_FIELD)).clear();        app.sendData(MODAL_EDIT_SKYPE_FIELD, skype);        app.clickWaitElement(MODAL_EDIT_SAVE_BUTTON, 5000);    }*/    /*public void checkNotSaveFormContacts(String modalEditButtonCloseNotSave) throws InterruptedException {        app.clickWaitElement(BUTTON_EDIT_CONTACTS, 500);        app.wd.findElement(By.xpath(MODAL_EDIT_EMAIL)).clear();        app.sendData(MODAL_EDIT_EMAIL, "test@test.test");        app.clickWaitElement(modalEditButtonCloseNotSave, 1000);        String email = app.findGetText(PROFILE_CONTACTS_FIELD_EMAIL);        assertFalse(email.equalsIgnoreCase("test@test.test"));        app.wd.navigate().refresh();        app.clickWaitElement(BUTTON_EDIT_CONTACTS, 500);        assertTrue(app.wd.findElement(By.xpath(MODAL_EDIT_EMAIL)).getAttribute("value").equalsIgnoreCase(email));        //app.findClickElement(MODAL_EDIT_ICON_CROSS);        app.clickWaitElement(MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE, 2000);    }*/    /*public void checkNotSaveFormDevices(String editWindowIconCross) throws InterruptedException {        app.addDevice();        String typeDevice = app.wd.findElement(By.xpath(TABLE_FIELD_TYPE_PC)).getAttribute("data-type");        app.clickWaitElement(TABLE_ICON_EDIT, 500);        app.findClickElement(EDIT_WINDOW_OS_ANDROID);        app.clickWaitElement(editWindowIconCross, 500);        assertEquals(typeDevice, app.wd.findElement(By.xpath(TABLE_FIELD_TYPE_PC)).getAttribute("data-type"));        app.clickWaitElement(TABLE_ICON_TRASH, 500);        app.clickWaitElement(BUTTON_DELETE_DEVICE, 2000);    }*/    /*public void switchWindow(String idWindow) {        Set<String> idOpeningWindows = app.wd.getWindowHandles();        for (String tab : idOpeningWindows) {            if (!tab.equals(idWindow)) {                app.wd.switchTo().window(tab);                break;            }        }    }*/    /*public String findGetText(String s) {        return app.wd.findElement(By.xpath(s)).getText();    }*/}