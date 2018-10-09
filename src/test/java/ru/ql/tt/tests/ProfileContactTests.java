package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProfileContactTests extends TestBase {

    // 3. Изменение контактной информации.
    @Test
    public void testOpeningWindowContacts() throws InterruptedException {
        //app.wd.navigate().refresh();
        app.clickWaitElement("//button[contains(text(),'Редактировать контакты')]", 500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//div[@class='modal-content']")).isDisplayed());
        assertEquals(app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//h5[@id='exampleModalLabel']")).getText(),"Изменение контактной информации");
        app.wd.findElement(By.xpath("//input[@id='phone']")).clear();
        app.wd.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
        app.wd.findElement(By.xpath("//input[@id='skype']")).clear();
        app.wd.findElement(By.xpath("//input[@id='skype']")).sendKeys("SKYPE_TEST");
        app.clickWaitElement("//div[@id='popup-edit-contact']//button[contains(@type,'button')][contains(text(),'Сохранить')]", 5000);
        assertTrue(app.wd.findElement(By.xpath("//a[contains(@class,'m-list-search__result-item')]//span[contains(@class,'m-list-search__result-item-text phone')]"))
                .getText().equalsIgnoreCase("1234567890"));
        assertTrue(app.wd.findElement(By.xpath("//span[contains(@class,'m-list-search__result-item-text skype')]")).getText().equalsIgnoreCase("SKYPE_TEST"));
    }

    @Test
    public void testNotSaveButtonCloseContacts() throws InterruptedException {
        app.clickWaitElement("//button[contains(text(),'Редактировать контакты')]", 500);
        app.wd.findElement(By.xpath("//input[@id='corporate-email']")).clear();
        app.wd.findElement(By.xpath("//input[@id='corporate-email']")).sendKeys("test@test.test");
        app.clickWaitElement("//div[@id='popup-edit-contact']//button[@type='button'][contains(text(),'Закрыть без сохранения')]", 1000);
        String email = app.wd.findElement(By.xpath("//span[@class='m-list-search__result-item-text corporate-email']")).getText();
        assertFalse(email.equalsIgnoreCase("test@test.test"));
        app.clickWaitElement("//button[contains(text(),'Редактировать контакты')]", 500);
        String em = app.wd.findElement(By.xpath("//input[@id='corporate-email']")).getAttribute("value");
        assertTrue(app.wd.findElement(By.xpath("//input[@id='corporate-email']")).getAttribute("value").equalsIgnoreCase(email));
        app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//div[@class='modal-header']//button[@type='button']")).click();
        app.clickWaitElement("//div[@id='popup-edit-contact']//button[@type='button'][contains(text(),'Закрыть без сохранения')]", 2000);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossContacts() throws InterruptedException {
        app.clickWaitElement("//button[contains(text(),'Редактировать контакты')]", 500);
        app.wd.findElement(By.xpath("//input[@id='corporate-email']")).clear();
        app.wd.findElement(By.xpath("//input[@id='corporate-email']")).sendKeys("test@test.test");
        app.clickWaitElement("//div[@id='popup-edit-contact']//div[@class='modal-header']//button[@type='button']", 1000);
        String email = app.wd.findElement(By.xpath("//span[@class='m-list-search__result-item-text corporate-email']")).getText();
        assertFalse(email.equalsIgnoreCase("test@test.test"));
        app.wd.navigate().refresh();
        app.clickWaitElement("//button[contains(text(),'Редактировать контакты')]", 500);
        assertTrue(app.wd.findElement(By.xpath("//input[@id='corporate-email']")).getAttribute("value").equalsIgnoreCase(email));
        app.wd.findElement(By.xpath("//div[@id='popup-edit-contact']//div[@class='modal-header']//button[@type='button']")).click();
        app.clickWaitElement("//div[@id='popup-edit-contact']//button[@type='button'][contains(text(),'Закрыть без сохранения')]", 2000);
    }
}
