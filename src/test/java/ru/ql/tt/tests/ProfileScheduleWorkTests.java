package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_SCHEDULE_WORK_BUTTON_EDIT;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_TABLE_TIME_MONDAY;
import static ru.ql.tt.PageBase.ProfileShedulePage.*;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.clickWaitElement;
import static ru.ql.tt.appmanager.UtilityMethods.findGetText;

public class ProfileScheduleWorkTests extends TestBase {

    // 2. Изменение графика работы
    @Test
    public void testOpeningWindowScheduleWork() throws InterruptedException {
        clickWaitElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT, 500);
        assertTrue(wd.findElement(By.xpath(MODAL_WINDOW_EDIT_SCHEDULE_WORK)).isDisplayed());
        assertEquals(findGetText(MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK),"Изменение графика работы");
        changeTimeScheduleWork();
        String beforeStart = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeEnd = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        clickWaitElement(MODAL_WINDOW_EDIT_BUTTON_SAVE_RESUME, 5000);
        String after = findGetText(PROFILE_TABLE_TIME_MONDAY);
        assertEquals(after, beforeTime);
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseSchedulWork() throws InterruptedException {
        checkNotSaveFormScheduleWork(MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossSchedulWork() throws InterruptedException {
        checkNotSaveFormScheduleWork(MODAL_WINDOW_EDIT_ICON_CROSS);
    }

}
