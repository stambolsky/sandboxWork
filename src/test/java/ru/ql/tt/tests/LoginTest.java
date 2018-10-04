package ru.ql.tt.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends TestBase{

    @Test
    public void testProfilePage() {
        app.goToProfile();
        String name = app.getLogin();
        Assert.assertEquals("Мистер АвтоМяу", name);
        Assert.assertEquals(app.checkPageUrl(), "http://tt-develop.quality-lab.ru/user/263/show/profile");
    }

    //"Фотография пользователя находится вверху страницы, над блоком резюме пользователя."
    @Test
    public void testLogoUser() {
        app.goToProfile();
        Assert.assertTrue(app.UserPhotoAboveResume());
    }

    //Кнопка “Сформировать резюме” имеет фиолетовую заливку.
    @Test
    public void testButtonCreateResume() {
        app.goToProfile();
        Assert.assertTrue(app.checkColorButtonCreateResume());
    }




}
