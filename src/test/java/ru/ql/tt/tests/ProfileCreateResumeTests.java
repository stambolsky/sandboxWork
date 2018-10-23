package ru.ql.tt.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.*;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.findClickElement;
import static ru.ql.tt.appmanager.UtilityMethods.findGetText;
import static ru.ql.tt.appmanager.UtilityMethods.switchWindow;


public class ProfileCreateResumeTests extends TestBase {

    @Test
    public void testOpenNewTabCreateResume() {
        findClickElement(PROFILE_BUTTON_CREATE_RESUME);
        String idWindow = wd.getWindowHandle();
        switchWindow(idWindow);
        String titleNewWindows = wd.getTitle();
        assertEquals(titleNewWindows, "Первая страница");
        String firstname = findGetText(WINDOW_RESUME_FIRST_NAME);
        String lastname = findGetText(WINDOW_RESUME_LAST_NAME);
        String name = lastname + " " + firstname;
        String place = findGetText(WINDOW_RESUME_PLACE);
        wd.close();
        wd.switchTo().window(idWindow);
        assertTrue(findGetText(FIRST_AND_LAST_NAME).equalsIgnoreCase(name));
        assertTrue(findGetText(PROFILE_RESUME_FIELD_PLACE).equalsIgnoreCase(place));
    }

}
