package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.AddDevaicePage.*;
import static ru.ql.tt.appmanager.ApplicationManager.wd;
import static ru.ql.tt.appmanager.UtilityMethods.*;

public class ProfileAddDeviceTests extends TestBase {

    // 4. Добавление нового устройства.
    @Test
    public void testOpeningWindowAddDevice() throws InterruptedException {
        clickWaitElement(BUTTON_ADD_DEVICES, 500);
        assertTrue(wd.findElement(By.xpath(MODAL_WINDOW_DEVICE)).isDisplayed());
        assertEquals(findGetText(TITLE_WINDOW_DEVICE),"Добавление нового устройства");
        findClickElement(TYPE_PHONE);
        sendData(PRODUCER_FIELD, "Apple");
        clickWaitElement(BUTTON_DEVICE_SAVE, 5000);
        assertTrue(findGetText(TABLE_FIELD_TYPE_PHONE).equalsIgnoreCase("Телефон"));
        assertTrue(findGetText(TABLE_TYPE_PRODUSER).equalsIgnoreCase("Apple"));
        clickWaitElement(TABLE_ICON_TRASH, 500);
        clickWaitElement(BUTTON_DELETE_DEVICE, 5000);
        //баг - блок не видимый
        //assertTrue(app.wd.findElement(By.xpath(TABLE_MESSAGE_EMPTY)).getText().equalsIgnoreCase("К сожалению, у Вас нет окружения."));
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseAddDevice() throws InterruptedException {
        checkNotSaveFormDevices(EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossAddDevice() throws InterruptedException {
        checkNotSaveFormDevices(EDIT_WINDOW_ICON_CROSS);
    }

}
