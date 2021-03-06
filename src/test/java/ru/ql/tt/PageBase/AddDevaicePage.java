package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.ql.tt.appmanager.UtilityMethods;

import static ru.ql.tt.tests.TestBase.app;

public class AddDevaicePage {

    public static String MODAL_WINDOW_DEVICE = "//div[@id='popup-add-environment']//div[@class='modal-content']";
    public static String TITLE_WINDOW_DEVICE = "//h5[contains(text(),'Добавление нового устройства')]";
    public static String BUTTON_ADD_DEVICES = "//span[contains(text(),'Добавить устройство')]";
    public static String TYPE_PC = "//div[@id='parentTypeAdd']//option[@value='2'][contains(text(),'ПК')]";
    public static String TYPE_PHONE = "//div[@id='parentTypeAdd']//option[@value='6'][contains(text(),'Телефон')]";
    public static String PRODUCER_FIELD = "//div[@id='popup-add-environment']//input[@name='manufacturer-device']";
    public static String TABLE_FIELD_TYPE_PHONE = "//td[contains(text(),'Телефон')]";
    public static String TABLE_FIELD_TYPE_PC  = "//td[contains(text(),'ПК')]";
    public static String TABLE_TYPE_PRODUSER = "//td[contains(text(),'APPLE')]";
    public static String TABLE_ICON_TRASH = "//tr[@class='m-datatable__row'][1]//a[2]";
    public static String TABLE_ICON_EDIT = "//tr[@class='m-datatable__row'][1]//a[1]";
    public static String BUTTON_DELETE_DEVICE = "//div[@id='popup-delete-environment']//div[@class='modal-footer']//button[2]";
    public static String TABLE_MESSAGE_EMPTY = "//div[@class='alert m-alert--default col-lg-12 no-items']";


    public static String TABLE = "//div[@class='table-responsive']";
    public static String TYPE_OS_LINUX = "//div[@id='parentOSAdd']//option[@value='4'][contains(text(),'Linux')]";
    public static String BUTTON_DEVICE_SAVE = "//div[@id='popup-add-environment']//button[@name='save']";
    public static String EDIT_MODAL_WINDOWS = "//div[@id='popup-edit-environment']//div[@class='modal-content']";
    public static String EDIT_WINDOW_OS_ANDROID = "//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]";
    public static String EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-environment']//button[@type='button'][contains(text(),'Закрыть без сохранения')]";
    public static String EDIT_WINDOW_ICON_CROSS = "//div[@id='popup-edit-environment']//div[@class='modal-header']//button[@type='button']";
    public static String EDIT_MODAL_WINDOW_DELETE = "//div[@id='popup-delete-environment']//div[@class='modal-content']";
    public static String DELETE_WINDOW_DEVICES = "//div[@id='popup-delete-environment']";

    private UtilityMethods utilityMethods = new UtilityMethods();

    private void addDevice() {
        utilityMethods.waitAndClickElement(BUTTON_ADD_DEVICES);
        utilityMethods.waitElement(TYPE_PC);
        utilityMethods.waitElement(TYPE_PC);
        utilityMethods.waitAndClickElement(TYPE_PC);
        utilityMethods.waitAndClickElement(TYPE_OS_LINUX);
        utilityMethods.waitAndClickElement(BUTTON_DEVICE_SAVE);
        utilityMethods.refreshPage();
    }

    public void checkNotSaveFormDevices(String button) {
        addDevice();
        String typeDevice = app.wd.findElement(By.xpath(TABLE_FIELD_TYPE_PC)).getAttribute("data-type");
        utilityMethods.waitAndClickElement(TABLE_ICON_EDIT);
        utilityMethods.waitAndClickElement(EDIT_WINDOW_OS_ANDROID);
        utilityMethods.waitAndClickElement(button);
        utilityMethods.waitCloseWindows(EDIT_MODAL_WINDOWS);
        Assert.assertEquals(typeDevice, app.wd.findElement(By.xpath(TABLE_FIELD_TYPE_PC)).getAttribute("data-type"));
        utilityMethods.waitAndClickElement(TABLE_ICON_TRASH);
        utilityMethods.waitAndClickElement(BUTTON_DELETE_DEVICE);
        utilityMethods.waitCloseWindows(EDIT_MODAL_WINDOW_DELETE);
    }

}
