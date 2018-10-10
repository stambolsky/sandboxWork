package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.appmanager.XpathElementsBase.*;

public class ProfileAddDeviceTests extends TestBase {

    // 4. Добавление нового устройства.
    @Test
    public void testOpeningWindowAddDevice() throws InterruptedException {
        app.clickWaitElement(BUTTON_ADD_DEVICES, 500);
        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_DEVICE)).isDisplayed());
        assertEquals(app.findGetText(TITLE_WINDOW_DEVICE),"Добавление нового устройства");
        app.findClickElement(TYPE_PHONE);
        app.sendData(PRODUCER_FIELD, "Apple");
        app.clickWaitElement(BUTTON_DEVICE_SAVE, 5000);
        assertTrue(app.findGetText(TABLE_FIELD_TYPE_PHONE).equalsIgnoreCase("Телефон"));
        assertTrue(app.findGetText(TABLE_TYPE_PRODUSER).equalsIgnoreCase("Apple"));
        app.clickWaitElement(TABLE_ICON_TRASH, 500);
        app.clickWaitElement(BUTTON_DELETE_DEVICE, 5000);
        //баг - блок не видимый
        //assertTrue(app.wd.findElement(By.xpath(TABLE_MESSAGE_EMPTY)).getText().equalsIgnoreCase("К сожалению, у Вас нет окружения."));
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseAddDevice() throws InterruptedException {
        app.checkNotSaveFormDevices(EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossAddDevice() throws InterruptedException {
        app.checkNotSaveFormDevices(EDIT_WINDOW_ICON_CROSS);
    }

}
