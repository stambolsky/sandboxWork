package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_CONTACTS_FIELD_EMAIL;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.*;

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

    public ProfileContactsPage() {
        super();
    }

    public static void checkNotSaveFormContacts(String modalEditButtonCloseNotSave) {
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

    public static void changeContactsInfo(String phone, String skype) {
        clickWaitElement(BUTTON_EDIT_CONTACTS, 500);
        assertTrue(wd.findElement(By.xpath(MODAL_WINDOW_EDIT_CONTACTS)).isDisplayed());
        Assert.assertEquals(findGetText(TITLE_MODAL_WINDOW_EDIT_CONTACTS),"Изменение контактной информации");
        wd.findElement(By.xpath(MODAL_EDIT_PHONE_FIELD)).clear();
        sendData(MODAL_EDIT_PHONE_FIELD, phone);
        wd.findElement(By.xpath(MODAL_EDIT_SKYPE_FIELD)).clear();
        sendData(MODAL_EDIT_SKYPE_FIELD, skype);
        clickWaitElement(MODAL_EDIT_SAVE_BUTTON, 5000);
    }
}
