package ru.ql.tt.tests;


import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.appmanager.XpathElementsBase.*;

public class ProfileContactTests extends TestBase {

    // 3. Изменение контактной информации.
    @Test
    public void testOpeningWindowContacts() throws InterruptedException {
        app.changeContactsInfo("1234567890", "SKYPE_TEST");
        assertTrue(app.findGetText(PROFILE_CONTACTS_FIELD_PHONE).equalsIgnoreCase("1234567890"));
        assertTrue(app.findGetText(PROFILE_CONTACTS_FIELD_SKYPE).equalsIgnoreCase("SKYPE_TEST"));
    }

    //Кнопка "Закрыть без сохранения"
    @Test
    public void testNotSaveButtonCloseContacts() throws InterruptedException {
        app.checkNotSaveFormContacts(MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossContacts() throws InterruptedException {
        app.checkNotSaveFormContacts(MODAL_EDIT_ICON_CROSS);
    }
}
