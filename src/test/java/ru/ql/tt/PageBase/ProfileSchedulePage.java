package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.ql.tt.appmanager.UtilityMethods;

import static org.testng.Assert.assertNotEquals;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_SCHEDULE_WORK_BUTTON_EDIT;
import static ru.ql.tt.PageBase.ProfilePage.PROFILE_TABLE_TIME_MONDAY;
import static ru.ql.tt.tests.TestBase.app;

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

    private UtilityMethods utilityMethods = new UtilityMethods();

    public ProfileSchedulePage() {
        super();
    }

    public void checkNotSaveFormScheduleWork(String modalWindowEditIconCross) {
        utilityMethods.waitAndClickElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT);
        utilityMethods.waitElement(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
        String beforeStart = app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeEnd = app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK)).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        utilityMethods.waitAndClickElement(modalWindowEditIconCross);
        utilityMethods.waitElement(PROFILE_TABLE_TIME_MONDAY);
        String after = utilityMethods.getTextFromElement(PROFILE_TABLE_TIME_MONDAY);
        assertNotEquals(after, beforeTime);
        app.wd.navigate().refresh();
        utilityMethods.waitAndClickElement(PROFILE_SCHEDULE_WORK_BUTTON_EDIT);
        utilityMethods.waitElement(PROFILE_TABLE_TIME_MONDAY);
        String afterRefresh = after.substring(0,5);
        String afterStart = app.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK)).getAttribute("value");
        Assert.assertEquals(afterStart, afterRefresh);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_ICON_CROSS);
        utilityMethods.waitCloseWindows(MODAL_WINDOW_EDIT_SCHEDULE_WORK);
    }

    public void changeTimeScheduleWork() {
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_TIME_HOUR_UP);
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_TIME_MINUTE_UP);
    }
}

