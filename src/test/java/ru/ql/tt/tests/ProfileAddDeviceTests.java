package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileAddDeviceTests extends TestBase {

    // 4. Добавление нового устройства.
    @Test
    public void testOpeningWindowAddDevice() throws InterruptedException {
        app.clickWaitElement("//span[contains(text(),'Добавить устройство')]", 500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-add-environment']//div[@class='modal-content']")).isDisplayed());
        assertEquals(app.findGetText("//h5[contains(text(),'Добавление нового устройства')]"),"Добавление нового устройства");
        app.findClickElement("//div[@id='parentTypeAdd']//option[@value='6'][contains(text(),'Телефон')]");
        app.sendData("//form[@action='/api/v1/environment/user/263/create.json']//input[@name='manufacturer-device']", "Apple");
        app.clickWaitElement("//div[@id='popup-add-environment']//button[@name='save'][contains(text(),'Сохранить')]", 5000);
        assertTrue(app.findGetText("//td[contains(text(),'Телефон')]").equalsIgnoreCase("Телефон"));
        assertTrue(app.findGetText("//td[contains(text(),'APPLE')]").equalsIgnoreCase("Apple"));
        app.clickWaitElement("//tbody[@class='m-datatable__body']/tr[1]/td[7]/a[2]", 500);
        app.clickWaitElement("//form[@action='/api/v1/environment/user/263/delete.json']//button[@type='button'][contains(text(),'Удалить')]", 5000);
        //баг - блок не видимый
        //assertTrue(app.wd.findElement(By.xpath("//div[@class='alert m-alert--default col-lg-12 no-items']")).getText().equalsIgnoreCase("К сожалению, у Вас нет окружения."));
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseAddDevice() throws InterruptedException {
        app.addDevice();
        String typeDevice = app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type");
        app.clickWaitElement("//a[@class='btn m-btn btn-nav-action m-btn--icon m-btn--icon-only m-btn--pill edit-environment']", 500);
        app.findClickElement("//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]");
        app.clickWaitElement("//div[@id='popup-edit-environment']//button[@type='button'][contains(text(),'Закрыть без сохранения')]", 500);
        assertEquals(typeDevice, app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type"));
        app.clickWaitElement("//tbody[@class='m-datatable__body']/tr[1]/td[7]/a[2]", 500);
        app.clickWaitElement("//form[@action='/api/v1/environment/user/263/delete.json']//button[@type='button'][contains(text(),'Удалить')]", 2000);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossAddDevice() throws InterruptedException {
        app.addDevice();
        String typeDevice = app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type");
        app.clickWaitElement("//a[@class='btn m-btn btn-nav-action m-btn--icon m-btn--icon-only m-btn--pill edit-environment']", 500);
        app.findClickElement("//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]");
        app.clickWaitElement("//div[@id='popup-edit-environment']//div[@class='modal-header']//button[@type='button']", 500);
        assertEquals(typeDevice, app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type"));
        app.clickWaitElement("//tbody[@class='m-datatable__body']/tr[1]/td[7]/a[2]", 500);
        app.clickWaitElement("//form[@action='/api/v1/environment/user/263/delete.json']//button[@type='button'][contains(text(),'Удалить')]", 2000);
    }
}
