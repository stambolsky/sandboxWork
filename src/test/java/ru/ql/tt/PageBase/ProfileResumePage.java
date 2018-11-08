package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import ru.ql.tt.appmanager.ApplicationManager;
import ru.ql.tt.appmanager.UtilityMethods;

import static ru.ql.tt.PageBase.ProfilePage.*;
import static ru.ql.tt.tests.TestBase.app;


public class ProfileResumePage {

    public static String MODAL_WINDOW_EDIT_RESUME = "//div[@id='popup-edit-resume']//div[@class='modal-content']";
    public static String MODAL_WINDOW_EDIT_TITLE = "//div[@id='popup-edit-resume']//h5[@id='exampleModalLabel']";
    public static String MODAL_WINDOW_EDIT_TEXTAREA = "//textarea[@id='post-description']";
    public static String MODAL_WINDOW_EDIT_BUTTON_SAVE = "//div[@id='popup-edit-resume']//button[2]";
    public static String MODAL_WINDOW_EDIT_TIP_TEXTAREA = "//form[@class='post-info']//div[3]";
    public static String MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-resume']//button[contains(text(),'Закрыть без сохранения')]";
    public static String MODAL_RESUME_EDIT_ICON_CROSS = "//div[@id='popup-edit-resume']//button[@class='close']";
    private UtilityMethods utilityMethods = new UtilityMethods();

    public ProfileResumePage() {
        super();
    }

    public void checkNotSaveFormResume(String modalResumeEditIconCross) {
        utilityMethods.waitAndClickElement(PROFILE_RESUME_BUTTON_EDIT);
        utilityMethods.waitElement(MODAL_WINDOW_EDIT_TEXTAREA);
        ApplicationManager.wd.findElement(By.xpath(MODAL_WINDOW_EDIT_TEXTAREA)).clear();
        utilityMethods.writeTextInField(MODAL_WINDOW_EDIT_TEXTAREA, "Финансист");
        utilityMethods.waitAndClickElement(MODAL_WINDOW_EDIT_TIP_TEXTAREA);
        utilityMethods.waitAndClickElement(modalResumeEditIconCross);
        utilityMethods.waitCloseWindows(MODAL_WINDOW_EDIT_RESUME);
        String before = utilityMethods.getTextFromElement(PROFILE_RESUME_SHORT_RESUME);
        utilityMethods.waitAndClickElement(PROFILE_RESUME_BUTTON_EDIT);
        String after = utilityMethods.getTextFromElement(MODAL_WINDOW_EDIT_TEXTAREA);
        if (after.equals("")) {
            after = "Краткое резюме не указано";
        }
        Assert.assertEquals(before, after);
        utilityMethods.waitAndClickElement(modalResumeEditIconCross);
        utilityMethods.waitCloseWindows(MODAL_WINDOW_EDIT_RESUME);
    }

    public boolean UserPhotoAboveResume() {
        boolean res = true;
        int firstElement = app.wd.findElement(By.xpath(AVATAR)).getLocation().getX();
        int secondElement = app.wd.findElement(By.xpath(BLOCK_RESUME)).getLocation().getY();
        if (firstElement - secondElement > 0) {
            res = false;
        }
        return res;
    }

    public boolean checkColorButtonCreateResume() {
        boolean res = true;
        String color = app.wd.findElement(By.xpath(BUTTON_CREATE_RESUME)).getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        if (!hex.equals("#716aca")) {
            res = false;
        }
        return res;
    }
}
