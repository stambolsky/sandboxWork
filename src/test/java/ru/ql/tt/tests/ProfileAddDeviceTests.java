package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.ql.tt.PageBase.AddDevaicePage;
import ru.ql.tt.appmanager.UtilityMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.PageBase.AddDevaicePage.*;

public class ProfileAddDeviceTests extends TestBase {
    private UtilityMethods utilityMethods = new UtilityMethods();
    private AddDevaicePage addDevaicePage = new AddDevaicePage();

    // 4. Добавление нового устройства.
    @Test
    public void testOpeningWindowAddDevice() {
        utilityMethods.waitElement(BUTTON_ADD_DEVICES);
        utilityMethods.waitAndClickElement(BUTTON_ADD_DEVICES);
        utilityMethods.waitElement(MODAL_WINDOW_DEVICE);
        assertTrue(app.wd.findElement(By.xpath(MODAL_WINDOW_DEVICE)).isDisplayed());
        assertEquals(utilityMethods.getTextFromElement(TITLE_WINDOW_DEVICE),"Добавление нового устройства");
        utilityMethods.waitAndClickElement(TYPE_PHONE);
        utilityMethods.writeTextInField(PRODUCER_FIELD, "Apple");
        utilityMethods.waitAndClickElement(BUTTON_DEVICE_SAVE);
        utilityMethods.waitElement(TABLE_FIELD_TYPE_PHONE);
        assertTrue(utilityMethods.getTextFromElement(TABLE_FIELD_TYPE_PHONE).equalsIgnoreCase("Телефон"));
        assertTrue(utilityMethods.getTextFromElement(TABLE_TYPE_PRODUSER).equalsIgnoreCase("Apple"));
        utilityMethods.waitAndClickElement(TABLE_ICON_TRASH);
        utilityMethods.waitElement(BUTTON_DELETE_DEVICE);
        utilityMethods.waitAndClickElement(BUTTON_DELETE_DEVICE);
        //баг - блок не видимый
        //assertTrue(app.wd.findElement(By.xpath(TABLE_MESSAGE_EMPTY)).getText().equalsIgnoreCase("К сожалению, у Вас нет окружения."));
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseAddDevice() {
        addDevaicePage.checkNotSaveFormDevices(EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossAddDevice() {
        addDevaicePage.checkNotSaveFormDevices(EDIT_WINDOW_ICON_CROSS);
    }

}
