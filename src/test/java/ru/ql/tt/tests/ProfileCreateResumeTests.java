package ru.ql.tt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileCreateResumeTests extends TestBase {

    @Test
    public void testOpenNewTabCreateResume() {
        app.wd.findElement(By.xpath("//a[@class='btn btn-brand m-btn']")).click();
        String idWindow = app.wd.getWindowHandle();
        Set<String> idOpeningWindows = app.wd.getWindowHandles();
        for (String tab : idOpeningWindows) {
            if (!tab.equals(idWindow)) {
                app.wd.switchTo().window(tab);
                break;
            }
        }
        String titleNewWindows = app.wd.getTitle();
        assertEquals(titleNewWindows, "Первая страница");
        String firstname = app.wd.findElement(By.xpath("//div[@class='count-subsection user-info']//div[3]//p[1]")).getText();
        String lastname = app.wd.findElement(By.xpath("//div[@class='count-subsection user-info']//div[3]//p[2]")).getText();
        String name = lastname + " " + firstname;
        String place = app.wd.findElement(By.xpath("//div[@class='user-position-name name editable ck-blurred ck-editor__editable ck-rounded-corners ck-editor__editable_inline']")).getText();
        app.wd.close();
        app.wd.switchTo().window(idWindow);
        assertTrue(app.wd.findElement(By.xpath("//span[@id='headerName']")).getText().equalsIgnoreCase(name));
        assertTrue(app.wd.findElement(By.xpath("//span[@class='m-list-search__result-item-text post-name']")).getText().equalsIgnoreCase(place));
    }
}
