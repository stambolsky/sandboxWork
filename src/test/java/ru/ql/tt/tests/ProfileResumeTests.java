package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_RESUME_BUTTON_EDIT;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_RESUME_SHORT_RESUME;
import static ru.ql.tt.PageBase.ProfileResumePage.*;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.*;

public class ProfileResumeTests extends TestBase {

    @Test
    public void testOpeningWindowResume() {
        clickWaitElement(PROFILE_RESUME_BUTTON_EDIT, 500);
        assertTrue(wd.findElement(By.xpath(MODAL_WINDOW_EDIT_RESUME)).isDisplayed());
        assertEquals(findGetText(MODAL_WINDOW_EDIT_TITLE),"Изменение краткого резюме сотрудника");
        wd.findElement(By.xpath(MODAL_WINDOW_EDIT_TEXTAREA)).clear();
        sendData(MODAL_WINDOW_EDIT_TEXTAREA, "Test Test Test");
        findClickElement(MODAL_WINDOW_EDIT_BUTTON_SAVE);
        clickWaitElement(MODAL_WINDOW_EDIT_BUTTON_SAVE, 5000);
        assertEquals("Test Test Test", findGetText(PROFILE_RESUME_SHORT_RESUME));
        clickWaitElement(PROFILE_RESUME_BUTTON_EDIT, 2000);
        assertEquals("Test Test Test", findGetText(MODAL_WINDOW_EDIT_TEXTAREA));
        //app.findClickElement("//div[@id='popup-edit-resume']");
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseResume() {
        checkNotSaveFormResume(MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossResume() {
        checkNotSaveFormResume(MODAL_RESUME_EDIT_ICON_CROSS);
    }

}
