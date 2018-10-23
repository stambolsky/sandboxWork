package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.Assert.assertNotEquals;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_SCHEDULE_WORK_BUTTON_EDIT;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_TABLE_TIME_MONDAY;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.clickWaitElement;
import static ru.ql.tt.appmanager.UtilityMethods.findClickElement;
import static ru.ql.tt.appmanager.UtilityMethods.findGetText;

public class ProfileSchedulePage {

    public static String MODAL_WINDOW_EDIT_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//div[@class='modal-content']";
    public static String MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//h5";
    public static String MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]";
    public static String MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[2]//div[1]//input[1]";
    public static String MODAL_WINDOW_EDIT_TIME_HOUR_UP = "//tbody//tr[1]//td[1]/a";
    public static String MODAL_WINDOW_EDIT_TIME_MINUTE_UP = "//tbody//tr[1]//td[3]/a";
    public static String MODAL_WINDOW_EDIT_BUTTON_SAVE_RESUME = "//div[@id='popup-edit-schedule']//button[2]";
    public static String MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-schedule']//button[contains(text(),'Закрыть без сохранения')]";
    public static String MODAL_WINDOW_EDIT_ICON_CROSS = "//div[@id='popup-edit-schedule']//div[@class='modal-header']//button";

    public ProfileSchedulePage() {
        super();
    }

    public static void checkNotSaveFormScheduleWork(String modalWindowEditIconCross) {
        clickWaitElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT, 500);
        findClickElement(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK);
        findClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        findClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
        String beforeStart = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeEnd = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        clickWaitElement(modalWindowEditIconCross, 2000);
        String after = findGetText(PROFILE_TABLE_TIME_MONDAY);
        assertNotEquals(after, beforeTime);
        wd.navigate().refresh();
        clickWaitElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT, 500);
        String afterRefresh = after.substring(0,5);
        String afterStart = wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        Assert.assertEquals(afterStart, afterRefresh);
        clickWaitElement(MODAL_WINDOW_EDIT_ICON_CROSS, 2000);
    }

    public static void changeTimeScheduleWork() {
        findClickElement(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK);
        findClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        findClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
        findClickElement(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK);
        findClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        findClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
    }
}

