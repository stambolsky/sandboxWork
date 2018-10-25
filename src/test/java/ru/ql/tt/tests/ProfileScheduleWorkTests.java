package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_SCHEDULE_WORK_BUTTON_EDIT;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_TABLE_TIME_MONDAY;
import static ru.ql.tt.PageBase.ProfileSchedulePage.*;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.*;

public class ProfileScheduleWorkTests extends TestBase {

    // 2. Изменение графика работы
    @Test
    public void testOpeningWindowScheduleWork() {
        clickWaitElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT);
        waitElement(MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        assertTrue(wd.findElement(By.xpath(MODAL_WINDOW_EDIT_SCHEDULE_WORK)).isDisplayed());
        assertEquals(findGetText(MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK),"Изменение графика работы");
        changeTimeScheduleWork();
        String beforeStart = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeEnd = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        clickWaitElement(MODAL_WINDOW_EDIT_BUTTON_SAVE_RESUME);
        waitCloseWindows(MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        waitElement(PROFILE_TABLE_TIME_MONDAY);
        String after = findGetText(PROFILE_TABLE_TIME_MONDAY);
        assertEquals(after, beforeTime);
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseScheduleWork() {
        checkNotSaveFormScheduleWork(MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossScheduleWork() {
        checkNotSaveFormScheduleWork(MODAL_WINDOW_EDIT_ICON_CROSS);
    }

}
