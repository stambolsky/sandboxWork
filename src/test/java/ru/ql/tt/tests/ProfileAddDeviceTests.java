package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileAddDeviceTests extends TestBase {

    // 4. Добавление нового устройства.
    @Test
    public void testOpeningWindowAddDevice() throws InterruptedException {
        app.wd.findElement(By.xpath("//span[contains(text(),'Добавить устройство')]")).click();
        Thread.sleep(500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-add-environment']//div[@class='modal-content']")).isDisplayed());
        assertEquals(app.wd.findElement(By.xpath("//h5[contains(text(),'Добавление нового устройства')]")).getText(),"Добавление нового устройства");
        app.wd.findElement(By.xpath("//div[@id='parentTypeAdd']//option[@value='6'][contains(text(),'Телефон')]")).click();
        app.wd.findElement(By.xpath("//form[@action='/api/v1/environment/user/263/create.json']//input[@name='manufacturer-device']")).sendKeys("Apple");
        app.wd.findElement(By.xpath("//div[@id='popup-add-environment']//button[@name='save'][contains(text(),'Сохранить')]")).click();
        Thread.sleep(5000);
        assertTrue(app.wd.findElement(By.xpath("//td[contains(text(),'Телефон')]")).getText().equalsIgnoreCase("Телефон"));
        assertTrue(app.wd.findElement(By.xpath("//td[contains(text(),'APPLE')]")).getText().equalsIgnoreCase("Apple"));
        app.wd.findElement(By.xpath("//tbody[@class='m-datatable__body']/tr[1]/td[7]/a[2]")).click();
        Thread.sleep(500);
        app.wd.findElement(By.xpath("//form[@action='/api/v1/environment/user/263/delete.json']//button[@type='button'][contains(text(),'Удалить')]")).click();
        Thread.sleep(5000);
        //баг - блок не видимый
        //assertTrue(app.wd.findElement(By.xpath("//div[@class='alert m-alert--default col-lg-12 no-items']")).getText().equalsIgnoreCase("К сожалению, у Вас нет окружения."));
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseAddDevice() throws InterruptedException {
        app.wd.findElement(By.xpath("//span[contains(text(),'Добавить устройство')]")).click();
        Thread.sleep(500);
        app.wd.findElement(By.xpath("//div[@id='parentTypeAdd']//option[@value='2'][contains(text(),'ПК')]")).click();
        app.wd.findElement(By.xpath("//div[@id='parentOSAdd']//option[@value='4'][contains(text(),'Linux')]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-add-environment']//button[@name='save'][contains(text(),'Сохранить')]")).click();
        app.wd.navigate().refresh();
        Thread.sleep(5000);
        String typeDevice = app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type");
        app.wd.findElement(By.xpath("//a[@class='btn m-btn btn-nav-action m-btn--icon m-btn--icon-only m-btn--pill edit-environment']")).click();
        Thread.sleep(500);
        app.wd.findElement(By.xpath("//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-environment']//button[@type='button'][contains(text(),'Закрыть без сохранения')]")).click();
        Thread.sleep(500);
        assertEquals(typeDevice, app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type"));
        app.wd.findElement(By.xpath("//tbody[@class='m-datatable__body']/tr[1]/td[7]/a[2]")).click();
        Thread.sleep(500);
        app.wd.findElement(By.xpath("//form[@action='/api/v1/environment/user/263/delete.json']//button[@type='button'][contains(text(),'Удалить')]")).click();
        Thread.sleep(2000);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossAddDevice() throws InterruptedException {
        app.wd.findElement(By.xpath("//span[contains(text(),'Добавить устройство')]")).click();
        Thread.sleep(500);
        app.wd.findElement(By.xpath("//div[@id='parentTypeAdd']//option[@value='2'][contains(text(),'ПК')]")).click();
        app.wd.findElement(By.xpath("//div[@id='parentOSAdd']//option[@value='4'][contains(text(),'Linux')]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-add-environment']//button[@name='save'][contains(text(),'Сохранить')]")).click();
        app.wd.navigate().refresh();
        Thread.sleep(5000);
        String typeDevice = app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type");
        app.wd.findElement(By.xpath("//a[@class='btn m-btn btn-nav-action m-btn--icon m-btn--icon-only m-btn--pill edit-environment']")).click();
        Thread.sleep(500);
        app.wd.findElement(By.xpath("//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-environment']//div[@class='modal-header']//button[@type='button']")).click();
        Thread.sleep(500);
        assertEquals(typeDevice, app.wd.findElement(By.xpath("//td[contains(text(),'ПК')]")).getAttribute("data-type"));
        app.wd.findElement(By.xpath("//tbody[@class='m-datatable__body']/tr[1]/td[7]/a[2]")).click();
        Thread.sleep(500);
        app.wd.findElement(By.xpath("//form[@action='/api/v1/environment/user/263/delete.json']//button[@type='button'][contains(text(),'Удалить')]")).click();
        Thread.sleep(2000);
    }
}
