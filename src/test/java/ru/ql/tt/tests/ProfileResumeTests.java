package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileResumeTests extends TestBase {

    @Test
    public void testOpeningWindowResume() throws InterruptedException {
        app.wd.findElement(By.xpath("//button[@type='button'][contains(text(),'Редактировать резюме')]")).click();
        Thread.sleep(500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//div[@class='modal-content']")).isDisplayed());
        assertEquals(app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//h5[@id='exampleModalLabel']")).getText(),"Изменение краткого резюме сотрудника");
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

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseResume() throws InterruptedException {
        app.wd.findElement(By.xpath("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]")).click();
        Thread.sleep(1000);
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).clear();
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).sendKeys("Финансист");
        app.wd.findElement(By.xpath("//form[@class='post-info']//div[3]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Закрыть без сохранения')]")).click();
        Thread.sleep(1000);
        String before = app.wd.findElement(By.xpath("//span[@class='m-list-search__result-item-text post-description']")).getText();
        app.wd.findElement(By.xpath("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]")).click();
        Thread.sleep(1000);
        String after = app.wd.findElement(By.xpath("//textarea[@id='post-description']")).getText();
        assertEquals(before, after);
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//div[@class='modal-header']//button[@type='button']")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Закрыть без сохранения')]")).click();
        Thread.sleep(2000);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossResume() throws InterruptedException {
        app.wd.findElement(By.xpath("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]")).click();
        Thread.sleep(1000);
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).clear();
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).sendKeys("Финансист");
        app.wd.findElement(By.xpath("//form[@class='post-info']//div[3]")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//div[@class='modal-header']//button[@type='button']")).click();
        Thread.sleep(1000);
        String before = app.wd.findElement(By.xpath("//span[@class='m-list-search__result-item-text post-description']")).getText();
        app.wd.findElement(By.xpath("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]")).click();
        Thread.sleep(1000);
        String after = app.wd.findElement(By.xpath("//textarea[@id='post-description']")).getText();
        assertEquals(before, after);
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//div[@class='modal-header']//button[@type='button']")).click();
        app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Закрыть без сохранения')]")).click();
        Thread.sleep(2000);
    }
}
