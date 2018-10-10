package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.appmanager.XpathElementsBase.*;

public class ProfileResumeTests extends TestBase {

    @Test
    public void testOpeningWindowResume() throws InterruptedException {
        app.clickWaitElement(PROFILE_RESUME_BUTTON_EDIT, 500);
        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_RESUME)).isDisplayed());
        assertEquals(app.findGetText(MODAL_WINDOW_EDIT_TITLE),"Изменение краткого резюме сотрудника");
        app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_TEXTAREA)).clear();
        app.sendData(MODAL_WINDOW_EDIT_TEXTAREA, "Test Test Test");
        app.findClickElement(MODAL_WINDOW_EDIT_BUTTON_SAVE);
        app.clickWaitElement(MODAL_WINDOW_EDIT_BUTTON_SAVE, 5000);
        assertEquals("Test Test Test", app.findGetText(PROFILE_RESUME_SHORT_RESUME));
        app.clickWaitElement(PROFILE_RESUME_BUTTON_EDIT, 2000);
        assertEquals("Test Test Test", app.findGetText(MODAL_WINDOW_EDIT_TEXTAREA));
        //app.findClickElement("//div[@id='popup-edit-resume']");
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseResume() throws InterruptedException {
        app.checkNotSaveFormResume(MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossResume() throws InterruptedException {
        app.checkNotSaveFormResume(MODAL_RESUME_EDIT_ICON_CROSS);
    }

}
