package ru.ql.tt.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.*;

public class LoginTest extends TestBase{

    @Test
    public void testProfilePage() throws IOException {
        String name = app.getLoginNew();
        String login = app.getLogin();
        String url = app.getUrlProfilePage();
        assertEquals(login, name);
        assertEquals(app.checkPageUrl(), url);
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
