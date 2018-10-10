package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileResumeTests extends TestBase {

    @Test
    public void testOpeningWindowResume() throws InterruptedException {
        app.clickWaitElement("//button[@type='button'][contains(text(),'Редактировать резюме')]", 500);
        assertTrue(app.wd.findElement(By.xpath("//div[@id='popup-edit-resume']//div[@class='modal-content']")).isDisplayed());
        assertEquals(app.findGetText("//div[@id='popup-edit-resume']//h5[@id='exampleModalLabel']"),"Изменение краткого резюме сотрудника");
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).clear();
        app.sendData("//textarea[@id='post-description']", "Test Test Test");
        app.findClickElement("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Сохранить')]");
        app.clickWaitElement("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Сохранить')]", 5000);
        assertEquals("Test Test Test", app.findGetText("//span[@class='m-list-search__result-item-text post-description']"));
        app.clickWaitElement("//button[contains(text(),'Редактировать резюме')]", 2000);
        assertEquals("Test Test Test", app.findGetText("//textarea[@id='post-description']"));
        app.findClickElement("//div[@id='popup-edit-resume']");
    }

    //Кнопка “Закрыть без сохранения”.
    @Test
    public void testNotSaveButtonCloseResume() throws InterruptedException {
        app.clickWaitElement("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]", 1000);
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).clear();
        app.sendData("//textarea[@id='post-description']", "Финансист");
        app.findClickElement("//form[@class='post-info']//div[3]");
        app.clickWaitElement("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Закрыть без сохранения')]", 1000);
        String before = app.findGetText("//span[@class='m-list-search__result-item-text post-description']");
        app.clickWaitElement("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]", 1000);
        String after = app.findGetText("//textarea[@id='post-description']");
        if (after.equals("")) {
            after = "Краткое резюме не указано";
        }
        assertEquals(before, after);
        app.clickWaitElement("//div[@id='popup-edit-resume']//button[@type='button'][contains(text(),'Закрыть без сохранения')]", 2000);
    }

    //Кнопка “Крестик”.
    @Test
    public void testNotSaveIconCrossResume() throws InterruptedException {
        app.clickWaitElement("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]", 1000);
        app.wd.findElement(By.xpath("//textarea[@id='post-description']")).clear();
        app.sendData("//textarea[@id='post-description']", "Финансист");
        app.findClickElement("//form[@class='post-info']//div[3]");
        app.clickWaitElement("//div[@id='popup-edit-resume']//div[@class='modal-header']//button[@type='button']", 1000);
        String before = app.findGetText("//span[@class='m-list-search__result-item-text post-description']");
        app.clickWaitElement("//div[@id='m_tabs_6_1']//button[contains(text(),'Редактировать резюме')]", 1000);
        String after = app.findGetText("//textarea[@id='post-description']");
        if (after.equals("")) {
            after = "Краткое резюме не указано";
        }
        assertEquals(before, after);
        app.clickWaitElement("//div[@id='popup-edit-resume']//div[@class='modal-header']//button[@type='button']", 2000);
    }
}
