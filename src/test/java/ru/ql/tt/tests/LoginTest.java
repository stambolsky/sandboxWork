package ru.ql.tt.tests;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TestBase{

    @Test
    public void testProfilePage() {
        app.goToProfile();
        String name = app.getLogin();
        Assert.assertEquals("Мистер АвтоМяу", name);
        Assert.assertEquals(app.checkPageUrl(), "http://tt-develop.quality-lab.ru/user/263/show/profile");
    }

}
