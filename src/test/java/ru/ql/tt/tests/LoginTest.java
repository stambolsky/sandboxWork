package ru.ql.tt.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import java.sql.SQLOutput;
import java.util.*;

import static com.sun.activation.registries.LogSupport.log;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase{

    @Test
    public void testProfilePage() {
        app.goToProfile();
        String name = app.getLogin();
        assertEquals("Мистер АвтоМяу", name);
        assertEquals(app.checkPageUrl(), "http://tt-develop.quality-lab.ru/user/263/show/profile");
    }

    //"Фотография пользователя находится вверху страницы, над блоком резюме пользователя."
    @Test
    public void testLogoUser() {
        app.goToProfile();
        assertTrue(app.UserPhotoAboveResume());
    }

    //Кнопка “Сформировать резюме” имеет фиолетовую заливку.
    @Test
    public void testButtonCreateResume() {
        app.goToProfile();
        assertTrue(app.checkColorButtonCreateResume());
    }

    //4) Проверка “состава” блоков страницы.
    //1. Реализовать проверки посредством “мягких” проверок.
    @Test
    public void areElementPagePresent() {
        app.goToProfile();
        assertTrue(app.allElementsBlock());
    }

    //2. Реализовать метод, который будет принимать в качестве параметра ожидаемые элементы, определять, присутствуют ли каждый из них в блоке и в случае отсутствия выводить в отчет имя и селектор элемента.





}
