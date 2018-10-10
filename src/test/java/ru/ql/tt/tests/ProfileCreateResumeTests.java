package ru.ql.tt.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class ProfileCreateResumeTests extends TestBase {

    @Test
    public void testOpenNewTabCreateResume() {
        app.findClickElement("//a[@class='btn btn-brand m-btn']");
        String idWindow = app.wd.getWindowHandle();
        app.switchWindow(idWindow);
        String titleNewWindows = app.wd.getTitle();
        assertEquals(titleNewWindows, "Первая страница");
        String firstname = app.findGetText("//div[@class='count-subsection user-info']//div[3]//p[1]");
        String lastname = app.findGetText("//div[@class='count-subsection user-info']//div[3]//p[2]");
        String name = lastname + " " + firstname;
        String place = app.findGetText("//div[@class='user-position-name name editable ck-blurred ck-editor__editable ck-rounded-corners ck-editor__editable_inline']");
        app.wd.close();
        app.wd.switchTo().window(idWindow);
        assertTrue(app.findGetText("//span[@id='headerName']").equalsIgnoreCase(name));
        assertTrue(app.findGetText("//span[@class='m-list-search__result-item-text post-name']").equalsIgnoreCase(place));
    }

}
