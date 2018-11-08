package ru.ql.tt.tests;


import org.testng.annotations.Test;
import ru.ql.tt.PageBase.ProfileContactsPage;

import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfileContactsPage.*;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_CONTACTS_FIELD_PHONE;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_CONTACTS_FIELD_SKYPE;

public class ProfileContactTests extends TestBase {
    private ProfileContactsPage profileContactsPage = new ProfileContactsPage();

    // 3. Изменение контактной информации.
    @Test
    public void testOpeningWindowContacts() {
        String a = String.valueOf((int) ((Math.random()*(600+1)) - 200));
        profileContactsPage.changeContactsInfo(a, "SKYPE_TEST" + a);
        //profileContactsPage.changeContactsInfo("1234567890", "SKYPE_TEST");
        assertTrue(utilityMethods.getTextFromElement(PROFILE_CONTACTS_FIELD_PHONE).equalsIgnoreCase(a));
        assertTrue(utilityMethods.getTextFromElement(PROFILE_CONTACTS_FIELD_SKYPE).equalsIgnoreCase("SKYPE_TEST" + a));
    }

    //Кнопка "Закрыть без сохранения"
    @Test
    public void testNotSaveButtonCloseContacts() {
        profileContactsPage.checkNotSaveFormContacts(MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossContacts() {
        profileContactsPage.checkNotSaveFormContacts(MODAL_EDIT_ICON_CROSS);
    }
}
