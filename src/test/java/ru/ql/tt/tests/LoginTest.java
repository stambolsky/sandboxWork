package ru.ql.tt.tests;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase{

    @Test
    public void testProfilePage() {
        //app.goToProfile();
        String name = app.getLogin();
        Assertions.assertEquals("Мистер АвтоМяу", name);
        Assertions.assertEquals(app.checkPageUrl(), "http://tt-develop.quality-lab.ru/user/263/show/profile");
    }

    //"Фотография пользователя находится вверху страницы, над блоком резюме пользователя."
    @Test
    public void testLogoUser() {
        //app.goToProfile();
        assertTrue(app.UserPhotoAboveResume());
    }

    //Кнопка “Сформировать резюме” имеет фиолетовую заливку.
    @Test
    public void testButtonCreateResume() {
        //app.goToProfile();
        assertTrue(app.checkColorButtonCreateResume());
    }

    //4) Проверка “состава” блоков страницы.
    //1. Реализовать проверки посредством “мягких” проверок.
    //2. Реализовать метод, который будет принимать в качестве параметра ожидаемые элементы, определять,
    // присутствуют ли каждый из них в блоке и в случае отсутствия выводить в отчет имя и селектор элемента.
    @Test
    public void testElementPagePresent() {
        //app.goToProfile();
        assertTrue(app.allElementsBlock());
    }

    //5) Проверка открытия модальных окон.
    //6) Проверка сохранения информации в модальных окнах.

      //Сценарий:
    /*1. Найти кнопку “Редактировать резюме (график работы, контакты, добавить устройство)” и кликнуть по ней.
      2. Дождаться появления соответствующего окна.
      3. Проверить, что окно действительно появилось.*/
    

    // 1. Изменение краткого резюме.
    @Test
    public void testOpeningWindowResume() throws InterruptedException {
        app.wd.findElement(By.xpath("//button[@type='button'][contains(text(),'Редактировать резюме')]")).click();
        Thread.sleep(500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//div[@class='modal-content']")).isDisplayed());
        Assertions.assertEquals(app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//h5[@id='exampleModalLabel']")).getText(),"Изменение краткого резюме сотрудника");
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).clear();
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).sendKeys("Test Test Test");
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Сохранить')]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Сохранить')]")).click();
        Thread.sleep(5000);
        assertEquals("Test Test Test", app.wd.findElement(By.xpath("//span[@class='m-list-search__result-item-text post-description']")).getText());
        app.wd.findElement(By.xpath("//button[contains(text(),'Редактировать резюме')]")).click();
        Thread.sleep(500);
        assertEquals("Test Test Test", app.wd.findElement(By.xpath("//textarea[@id='post-description']")).getText());
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']")).click();
    }

    // 2. Изменение графика работы
    @Test
    public void testOpeningWindowScheduleWork() throws InterruptedException {
        app.wd.findElement(By.xpath("//button[contains(text(),'Редактировать график')]")).click();
        Thread.sleep(500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//div[@class='modal-content']")).isDisplayed());
        Assertions.assertEquals(app.wd.findElement(By.xpath("//h5[contains(text(),'Изменение графика работы')]")).getText(),"Изменение графика работы");
        app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).click();
        app.wd.findElement(By.xpath("//tbody//tr[1]//td[1]//a[1]")).click();
        app.wd.findElement(By.xpath("//tbody//tr[1]//td[3]//a[1]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[2]//div[1]//input[1]")).click();
        app.wd.findElement(By.xpath("//tbody//tr[1]//td[1]//a[1]")).click();
        app.wd.findElement(By.xpath("//tbody//tr[1]//td[3]//a[1]")).click();
        String beforeStart = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        String beforeEnd = app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]")).getAttribute("value");
        String beforeTime = beforeStart + " - " + beforeEnd;
        app.wd.findElement(By.xpath("//div[@id='popup-edit-schedule']//button[@type='button'][contains(text(),'Сохранить')]")).click();
        Thread.sleep(5000);
        String after = app.wd.findElement(By.xpath("//div[@class='m-stack__item m-stack__item--center m-stack__item--fluid schedule-monday']")).getText();
        assertEquals(after, beforeTime);
    }

    // 3. Изменение контактной информации.
    @Test
    public void testOpeningWindowContacts() throws InterruptedException {
        //app.wd.navigate().refresh();
        app.wd.findElement(By.xpath("//button[contains(text(),'Редактировать контакты')]")).click();
        Thread.sleep(500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//div[@class='modal-content']")).isDisplayed());
        assertEquals(app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//h5[@id='exampleModalLabel']")).getText(),"Изменение контактной информации");
        app.wd.findElement(By.xpath("//input[@id='phone']")).clear();
        app.wd.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
        app.wd.findElement(By.xpath("//input[@id='skype']")).clear();
        app.wd.findElement(By.xpath("//input[@id='skype']")).sendKeys("SKYPE_TEST");
        app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//button[contains(@type,'button')][contains(text(),'Сохранить')]")).click();
        Thread.sleep(5000);
        assertTrue(app.wd.findElement(By.xpath("//a[contains(@class,'m-list-search__result-item')]//span[contains(@class,'m-list-search__result-item-text phone')]"))
                .getText().equalsIgnoreCase("1234567890"));
        assertTrue(app.wd.findElement(By.xpath("//span[contains(@class,'m-list-search__result-item-text skype')]")).getText().equalsIgnoreCase("SKYPE_TEST"));
        //app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//button[@type='button'][contains(text(),'Закрыть без сохранения')]")).click();
        //Thread.sleep(1000);
    }

    // 4. Добавление нового устройства.
    @Test
    public void testOpeningWindowAddDevice() throws InterruptedException {
        //app.wd.navigate().refresh();
        app.wd.findElement(By.xpath("//span[contains(text(),'Добавить устройство')]")).click();
        Thread.sleep(500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-add-environment']//div[@class='modal-content']")).isDisplayed());
        Assertions.assertEquals(app.wd.findElement(By.xpath("//h5[contains(text(),'Добавление нового устройства')]")).getText(),"Добавление нового устройства");
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



}
