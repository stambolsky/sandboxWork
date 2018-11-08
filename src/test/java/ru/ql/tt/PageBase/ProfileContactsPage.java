package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.ql.tt.appmanager.UtilityMethods;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_CONTACTS_FIELD_EMAIL;
import static ru.ql.tt.tests.TestBase.app;

public class ProfileContactsPage {

    public static String BUTTON_EDIT_CONTACTS = "//button[contains(text(),'Редактировать контакты')]";
    public static String MODAL_WINDOW_EDIT_CONTACTS = "//div[@id='popup-edit-contact']//div[@class='modal-content']";
    public static String TITLE_MODAL_WINDOW_EDIT_CONTACTS = "//div[@id='popup-edit-contact']//h5";
    public static String MODAL_EDIT_PHONE_FIELD = "//input[@id='phone']";
    public static String MODAL_EDIT_SKYPE_FIELD = "//input[@id='skype']";
    public static String MODAL_EDIT_SAVE_BUTTON = "//div[@id='popup-edit-contact']//button[2]";
    public static String MODAL_EDIT_EMAIL = "//input[@id='corporate-email']";
    public static String MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-contact']//button[contains(text(),'Закрыть без сохранения')]";
    public static String MODAL_EDIT_ICON_CROSS = "//div[@id='popup-edit-contact']//button[@class='close']";
    private UtilityMethods utilityMethods = new UtilityMethods();

    public ProfileContactsPage() {
        super();
    }

    public void checkNotSaveFormContacts(String modalEditButtonCloseNotSave) {
        utilityMethods.waitAndClickElement(BUTTON_EDIT_CONTACTS);
        utilityMethods.waitElement(MODAL_EDIT_EMAIL);
        app.wd.findElement(By.xpath(MODAL_EDIT_EMAIL)).clear();
        utilityMethods.writeTextInField(MODAL_EDIT_EMAIL, "test@test.test");
        utilityMethods.waitAndClickElement(modalEditButtonCloseNotSave);
        utilityMethods.waitElement(PROFILE_CONTACTS_FIELD_EMAIL);
        String email = utilityMethods.getTextFromElement(PROFILE_CONTACTS_FIELD_EMAIL);
        assertFalse(email.equalsIgnoreCase("test@test.test"));
        app.wd.navigate().refresh();
        utilityMethods.waitAndClickElement(BUTTON_EDIT_CONTACTS);
        utilityMethods.waitElement(MODAL_EDIT_EMAIL);
        assertTrue(app.wd.findElement(By.xpath(MODAL_EDIT_EMAIL)).getAttribute("value").equalsIgnoreCase(email));
        utilityMethods.waitAndClickElement(MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE);
        utilityMethods.waitCloseWindows(MODAL_WINDOW_EDIT_CONTACTS);
    }

    public void changeContactsInfo(String phone, String skype) {
        utilityMethods.waitAndClickElement(BUTTON_EDIT_CONTACTS);
        utilityMethods.waitElement(MODAL_WINDOW_EDIT_CONTACTS);
        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_CONTACTS)).isDisplayed());
        Assert.assertEquals(utilityMethods.getTextFromElement(TITLE_MODAL_WINDOW_EDIT_CONTACTS),"Изменение контактной информации");
        app.wd.findElement(By.xpath(MODAL_EDIT_PHONE_FIELD)).clear();
        utilityMethods.writeTextInField(MODAL_EDIT_PHONE_FIELD, phone);
        app.wd.findElement(By.xpath(MODAL_EDIT_SKYPE_FIELD)).clear();
        utilityMethods.writeTextInField(MODAL_EDIT_SKYPE_FIELD, skype);
        utilityMethods.waitAndClickElement(MODAL_EDIT_SAVE_BUTTON);
        utilityMethods.waitCloseWindows(MODAL_WINDOW_EDIT_CONTACTS);
    }
}
