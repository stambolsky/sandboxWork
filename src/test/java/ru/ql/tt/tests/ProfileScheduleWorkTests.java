package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.appmanager.XpathElementsBase.*;

public class ProfileScheduleWorkTests extends TestBase {

    // 2. Изменение графика работы
    @Test
    public void testOpeningWindowScheduleWork() throws InterruptedException {
        app.clickWaitElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT, 500);
        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_SCHEDULE_WORK)).isDisplayed());
        assertEquals(app.findGetText(MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK),"Изменение графика работы");
        app.changeTimeScheduleWork();
        String beforeStart = app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeEnd = app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        app.clickWaitElement(MODAL_WINDOW_EDIT_BUTTON_SAVE_RESUME, 5000);
        String after = app.findGetText(PROFILE_TABLE_TIME_MONDAY);
        assertEquals(after, beforeTime);
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseSchedulWork() throws InterruptedException {
        app.checkNotSaveFormScheduleWork(MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossSchedulWork() throws InterruptedException {
        app.checkNotSaveFormScheduleWork(MODAL_WINDOW_EDIT_ICON_CROSS);
    }

}
