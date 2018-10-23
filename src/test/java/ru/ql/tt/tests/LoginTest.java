package ru.ql.tt.tests;

import org.testng.annotations.Test;
import ru.ql.tt.PageBase.LoginPage;

import java.io.IOException;
import static org.testng.Assert.*;
import static ru.ql.tt.PageBase.ProfilePage.allElementsBlock;
import static ru.ql.tt.PageBase.ProfileResumePaga.UserPhotoAboveResume;
import static ru.ql.tt.PageBase.ProfileResumePaga.checkColorButtonCreateResume;
import static ru.ql.tt.appmanager.UtilityMethods.*;

public class LoginTest extends TestBase{

    @Test
    public void testProfilePage() throws IOException {
        String name = LoginPage.getLoginNew();
        String login = getLogin();
        String url = getUrlProfilePage();
        assertEquals(login, name);
        assertEquals(getPageUrl(), url);
    }

    //"Фотография пользователя находится вверху страницы, над блоком резюме пользователя."
    @Test
    public void testLogoUser() {
        assertTrue(UserPhotoAboveResume());
    }

    //Кнопка “Сформировать резюме” имеет фиолетовую заливку.
    @Test
    public void testButtonCreateResume() {
        assertTrue(checkColorButtonCreateResume());
    }

    @Test
    public void testElementPagePresent() {
        assertTrue(allElementsBlock());
    }



}
