package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import static ru.ql.tt.PageBase.ProfilePage.*;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.*;
import static ru.ql.tt.tests.TestBase.app;


public class ProfileResumePage {

    public static String MODAL_WINDOW_EDIT_RESUME = "//div[@id='popup-edit-resume']//div[@class='modal-content']";
    public static String MODAL_WINDOW_EDIT_TITLE = "//div[@id='popup-edit-resume']//h5[@id='exampleModalLabel']";
    public static String MODAL_WINDOW_EDIT_TEXTAREA = "//textarea[@id='post-description']";
    public static String MODAL_WINDOW_EDIT_BUTTON_SAVE = "//div[@id='popup-edit-resume']//button[2]";
    public static String MODAL_WINDOW_EDIT_TIP_TEXTAREA = "//form[@class='post-info']//div[3]";
    public static String MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-resume']//button[contains(text(),'Закрыть без сохранения')]";
    public static String MODAL_RESUME_EDIT_ICON_CROSS = "//div[@id='popup-edit-resume']//button[@class='close']";

    public ProfileResumePage() {
        super();
    }

    public static void checkNotSaveFormResume(String modalResumeEditIconCross) {
        clickWaitElement(PROFILE_RESUME_BUTTON_EDIT);
        waitElement(MODAL_WINDOW_EDIT_TEXTAREA);
        wd.findElement(By.xpath(MODAL_WINDOW_EDIT_TEXTAREA)).clear();
        sendData(MODAL_WINDOW_EDIT_TEXTAREA, "Финансист");
        findClickElement(MODAL_WINDOW_EDIT_TIP_TEXTAREA);
        clickWaitElement(modalResumeEditIconCross);
        waitCloseWindows(MODAL_WINDOW_EDIT_RESUME);
        String before = findGetText(PROFILE_RESUME_SHORT_RESUME);
        clickWaitElement(PROFILE_RESUME_BUTTON_EDIT);
        String after = findGetText(MODAL_WINDOW_EDIT_TEXTAREA);
        if (after.equals("")) {
            after = "Краткое резюме не указано";
        }
        Assert.assertEquals(before, after);
        clickWaitElement(modalResumeEditIconCross);
        waitCloseWindows(MODAL_WINDOW_EDIT_RESUME);
    }

    public static boolean UserPhotoAboveResume() {
        boolean res = true;
        int firstElement = wd.findElement(By.xpath(AVATAR)).getLocation().getX();
        int secondElement = wd.findElement(By.xpath(BLOCK_RESUME)).getLocation().getY();
        if (firstElement - secondElement > 0) {
            res = false;
        }
        return res;
    }

    public static boolean checkColorButtonCreateResume() {
        boolean res = true;
        String color = wd.findElement(By.xpath(BUTTON_CREATE_RESUME)).getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        if (!hex.equals("#716aca")) {
            res = false;
        }
        return res;
    }
}
