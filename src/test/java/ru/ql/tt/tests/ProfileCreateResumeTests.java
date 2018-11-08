package ru.ql.tt.tests;

import org.testng.annotations.Test;
import ru.ql.tt.appmanager.UtilityMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.*;

public class ProfileCreateResumeTests extends TestBase {
    private UtilityMethods utilityMethods = new UtilityMethods();

    @Test
    public void testOpenNewTabCreateResume() {
        utilityMethods.waitAndClickElement(PROFILE_BUTTON_CREATE_RESUME);
        String idWindow = app.wd.getWindowHandle();
        utilityMethods.switchWindow(idWindow);
        String titleNewWindows = app.wd.getTitle();
        assertEquals(titleNewWindows, "Первая страница");
        String firstName = utilityMethods.getTextFromElement(WINDOW_RESUME_FIRST_NAME);
        String lastName = utilityMethods.getTextFromElement(WINDOW_RESUME_LAST_NAME);
        String name = lastName + " " + firstName;
        String place = utilityMethods.getTextFromElement(WINDOW_RESUME_PLACE);
        app.wd.close();
        app.wd.switchTo().window(idWindow);
        assertTrue(utilityMethods.getTextFromElement(FIRST_AND_LAST_NAME).equalsIgnoreCase(name));
        assertTrue(utilityMethods.getTextFromElement(PROFILE_RESUME_FIELD_PLACE).equalsIgnoreCase(place));
    }

}
