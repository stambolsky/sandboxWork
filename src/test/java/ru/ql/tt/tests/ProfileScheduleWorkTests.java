package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class ProfileScheduleWorkTests extends TestBase {

    // 2. Изменение графика работы
    @Test
    public void testOpeningWindowScheduleWork() throws InterruptedException {
        app.clickWaitElement("//button[contains(text(),'Редактировать график')]", 500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//div[@class='modal-content']")).isDisplayed());
        assertEquals(app.wd.findElement(By.xpath("//h5[contains(text(),'Изменение графика работы')]")).getText(),"Изменение графика работы");
        app.findClickElement("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]");
        app.findClickElement("//tbody//tr[1]//td[1]//a[1]");
        app.findClickElement("//tbody//tr[1]//td[3]//a[1]");
        app.findClickElement("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[2]//div[1]//input[1]");
        app.findClickElement("//tbody//tr[1]//td[1]//a[1]");
        app.findClickElement("//tbody//tr[1]//td[3]//a[1]");
        String beforeStart = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        String beforeEnd = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[2]//div[1]//input[1]")).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        app.clickWaitElement("//div[@id='popup-edit-schedule']//button[@type='button'][contains(text(),'Сохранить')]", 5000);
        String after = app.wd.findElement(By.xpath("//div[@class='m-stack__item m-stack__item--center m-stack__item--fluid schedule-monday']")).getText();
        assertEquals(after, beforeTime);
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseSchedulWork() throws InterruptedException {
        app.clickWaitElement("//button[contains(text(),'Редактировать график')]", 500);
        app.findClickElement("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]");
        app.findClickElement("//tbody//tr[1]//td[1]//a[1]");
        app.findClickElement("//tbody//tr[1]//td[3]//a[1]");
        String beforeStart = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        String beforeEnd = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        app.clickWaitElement("//div[@id='popup-edit-schedule']//button[@type='button'][contains(text(),'Сохранить')]", 5000);
        String after = app.wd.findElement(By.xpath("//div[@class='m-stack__item m-stack__item--center m-stack__item--fluid schedule-monday']")).getText();
        assertNotEquals(after, beforeTime);
        app.wd.navigate().refresh();
        app.clickWaitElement("//button[contains(text(),'Редактировать график')]", 500);
        String afterRefresh = after.substring(0,5);
        String afterStart = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        assertEquals(afterStart, afterRefresh);
        app.clickWaitElement("//div[@id='popup-edit-schedule']//div[@class='modal-header']//button[@type='button']", 2000);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossSchedulWork() throws InterruptedException {
        app.clickWaitElement("//button[contains(text(),'Редактировать график')]", 500);
        app.findClickElement("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]");
        app.findClickElement("//tbody//tr[1]//td[1]//a[1]");
        app.findClickElement("//tbody//tr[1]//td[3]//a[1]");
        String beforeStart = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        String beforeEnd = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        app.clickWaitElement("//div[@id='popup-edit-schedule']//div[@class='modal-header']//button[@type='button']", 5000);
        String after = app.wd.findElement(By.xpath("//div[@class='m-stack__item m-stack__item--center m-stack__item--fluid schedule-monday']")).getText();
        assertNotEquals(after, beforeTime);
        app.wd.navigate().refresh();
        app.clickWaitElement("//button[contains(text(),'Редактировать график')]", 500);
        String afterRefresh = after.substring(0,5);
        String afterStart = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        assertEquals(afterStart, afterRefresh);
        app.clickWaitElement("//div[@id='popup-edit-schedule']//div[@class='modal-header']//button[@type='button']", 2000);
    }

}
