package ru.ql.tt.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static ru.ql.tt.appmanager.XpathElementsBase.*;


public class ProfileCreateResumeTests extends TestBase {

    @Test
    public void testOpenNewTabCreateResume() {
        app.findClickElement(PROFILE_BUTTON_CREATE_RESUME);
        String idWindow = app.wd.getWindowHandle();
        app.switchWindow(idWindow);
        String titleNewWindows = app.wd.getTitle();
        assertEquals(titleNewWindows, "Первая страница");
        String firstname = app.findGetText(WINDOW_RESUME_FIRST_NAME);
        String lastname = app.findGetText(WINDOW_RESUME_LAST_NAME);
        String name = lastname + " " + firstname;
        String place = app.findGetText(WINDOW_RESUME_PLACE);
        app.wd.close();
        app.wd.switchTo().window(idWindow);
        assertTrue(app.findGetText(FIRST_AND_LAST_NAME).equalsIgnoreCase(name));
        assertTrue(app.findGetText(PROFILE_RESUME_FIELD_PLACE).equalsIgnoreCase(place));
    }

}
