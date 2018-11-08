package ru.ql.tt.tests;

import org.testng.annotations.Test;
import ru.ql.tt.PageBase.LoginPage;
import ru.ql.tt.PageBase.ProfilePage;
import ru.ql.tt.PageBase.ProfileResumePage;
import ru.ql.tt.appmanager.UtilityMethods;

import static org.testng.Assert.*;

public class LoginTest extends TestBase{
    private LoginPage loginPage = new LoginPage();
    private UtilityMethods utilityMethods = new UtilityMethods();
    private ProfileResumePage profileResumePage = new ProfileResumePage();
    private ProfilePage profilePage = new ProfilePage();

    @Test
    public void testProfilePage() {
        String name = loginPage.getLoginFromMainPage();
        String login = loginPage.getLogin();
        String url = utilityMethods.getUrlProfilePage();
        assertEquals(login, name);
        assertEquals(utilityMethods.getPageUrl(), url);
    }

    //"Фотография пользователя находится вверху страницы, над блоком резюме пользователя."
    @Test
    public void testLogoUser() {
        assertTrue(profileResumePage.UserPhotoAboveResume());
    }

    //Кнопка “Сформировать резюме” имеет фиолетовую заливку.
    @Test
    public void testButtonCreateResume() {
        assertTrue(profileResumePage.checkColorButtonCreateResume());
    }

    @Test
    public void testElementPagePresent() {
        assertTrue(profilePage.allElementsBlock());
    }



}
