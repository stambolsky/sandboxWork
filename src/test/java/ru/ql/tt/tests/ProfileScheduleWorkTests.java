package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.ql.tt.PageBase.ProfileSchedulePage;
import ru.ql.tt.appmanager.UtilityMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_SCHEDULE_WORK_BUTTON_EDIT;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_TABLE_TIME_MONDAY;
import static ru.ql.tt.PageBase.ProfileSchedulePage.*;

public class ProfileScheduleWorkTests extends TestBase {
    private UtilityMethods utilityMethods = new UtilityMethods();
    private ProfileSchedulePage profileSchedulePage = new ProfileSchedulePage();

    // 2. Изменение графика работы
    @Test
    public void testOpeningWindowScheduleWork() {
        utilityMethods.waitAndClickElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT);
        utilityMethods.waitElement(MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_SCHEDULE_WORK)).isDisplayed());
        assertEquals(utilityMethods.getTextFromElement(MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK),"Изменение графика работы");
        profileSchedulePage.changeTimeScheduleWork();
        String beforeStart = app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeEnd = app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_BUTTON_SAVE_RESUME);
        utilityMethods.waitCloseWindows(MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        utilityMethods.waitElement(PROFILE_TABLE_TIME_MONDAY);
        String after = utilityMethods.getTextFromElement(PROFILE_TABLE_TIME_MONDAY);
        assertEquals(after, beforeTime);
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseScheduleWork() {
        profileSchedulePage.checkNotSaveFormScheduleWork(MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossScheduleWork() {
        profileSchedulePage.checkNotSaveFormScheduleWork(MODAL_WINDOW_EDIT_ICON_CROSS);
    }

}
