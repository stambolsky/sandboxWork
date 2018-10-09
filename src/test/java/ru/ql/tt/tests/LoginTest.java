package ru.ql.tt.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends TestBase{

    @Test
    public void testProfilePage() {
        String name = app.getLogin();
        assertEquals("Мистер АвтоМяу", name);
        assertEquals(app.checkPageUrl(), "http://tt-develop.quality-lab.ru/user/263/show/profile");
    }

    //"Фотография пользователя находится вверху страницы, над блоком резюме пользователя."
    @Test
    public void testLogoUser() {
        assertTrue(app.UserPhotoAboveResume());
    }

    //Кнопка “Сформировать резюме” имеет фиолетовую заливку.
    @Test
    public void testButtonCreateResume() {
        assertTrue(app.checkColorButtonCreateResume());
    }

    @Test
    public void testElementPagePresent() {
        assertTrue(app.allElementsBlock());
    }



}
