package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.ql.tt.PageBase.ProfileResumePage;
import ru.ql.tt.appmanager.UtilityMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_RESUME_BUTTON_EDIT;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_RESUME_SHORT_RESUME;
import static ru.ql.tt.PageBase.ProfileResumePage.*;

public class ProfileResumeTests extends TestBase {
    private UtilityMethods utilityMethods = new UtilityMethods();
    private ProfileResumePage profileResumePage = new ProfileResumePage();

    @Test
    public void testOpeningWindowResume() {
        utilityMethods.waitElement(PROFILE_RESUME_BUTTON_EDIT);
        utilityMethods.waitAndClickElement(PROFILE_RESUME_BUTTON_EDIT);
        utilityMethods.waitElement(MODAL_WINDOW_EDIT_RESUME);
        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_RESUME)).isDisplayed());
        assertEquals(utilityMethods.getTextFromElement(MODAL_WINDOW_EDIT_TITLE),"Изменение краткого резюме сотрудника");
        app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_TEXTAREA)).clear();
        utilityMethods.writeTextInField(MODAL_WINDOW_EDIT_TEXTAREA, "Test Test Test");
        utilityMethods.waitElement(MODAL_WINDOW_EDIT_BUTTON_SAVE);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_BUTTON_SAVE);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_BUTTON_SAVE);
        utilityMethods.waitCloseWindows(MODAL_WINDOW_EDIT_RESUME);
        utilityMethods.waitElement(PROFILE_RESUME_SHORT_RESUME);
        assertEquals("Test Test Test", utilityMethods.getTextFromElement(PROFILE_RESUME_SHORT_RESUME));
        utilityMethods.refreshPage();
        utilityMethods.waitElement(PROFILE_RESUME_BUTTON_EDIT);
        utilityMethods.waitAndClickElement(PROFILE_RESUME_BUTTON_EDIT);
        utilityMethods.waitElement(MODAL_WINDOW_EDIT_TEXTAREA);
        assertEquals("Test Test Test", utilityMethods.getTextFromElement(MODAL_WINDOW_EDIT_TEXTAREA));
        //app.findClickElement("//div[@id='popup-edit-resume']");
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseResume() {
        profileResumePage.checkNotSaveFormResume(MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossResume() {
        profileResumePage.checkNotSaveFormResume(MODAL_RESUME_EDIT_ICON_CROSS);
    }

}
