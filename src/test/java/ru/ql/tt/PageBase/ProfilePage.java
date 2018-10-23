package ru.ql.tt.PageBase;

import org.openqa.selenium.By;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import static ru.ql.tt.appmanager.ApplicationManager.wd;

public class ProfilePage {

    public static String NAME_USER = "//span[@id='headerName']";
    public static String AVATAR = "//img[contains(@class,'avatar')]";
    public static String BUTTON_CREATE_RESUME = "//a[contains(text(), 'Сформировать резюме')]";
    public static String HEADER = "//div[contains(@class,'m-portlet__head m-stack m-stack--ver m-stack--general')]";
    public static String LOGO = "//div[@class='m-portlet']//div[@class='avatarCover']";
    public static String FIRST_AND_LAST_NAME = "//span[@id='headerName']";
    public static String PROFILE_BUTTON_CREATE_RESUME = "//a[@class='btn btn-brand m-btn']";
    public static String BLOCK_MENU = "//div[@class='m-stack__item m-stack__item--left m-stack--ver m-stack__item--middle m-stack__item--fluid']";
    public static String TITLE_PROFILE = "//div[contains(@class,'m-subheader')]";
    public static String BLOCK_RESUME = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][1]";
    public static String BLOCK_SCHEDULE_WORK = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][2]";
    public static String BLOCK_CONTACTS = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][3]";
    public static String PROFILE_RESUME_FIELD_PLACE = "//span[@class='m-list-search__result-item-text post-name']";
    public static String PROFILE_RESUME_BUTTON_EDIT = "//button[@type='button'][contains(text(),'Редактировать резюме')]";
    public static String PROFILE_RESUME_SHORT_RESUME = "//span[@class='m-list-search__result-item-text post-description']";
    public static String PROFILE_SCHEDULE_WORK_BUTTON_EDIT = "//button[contains(text(),'Редактировать график')]";
    public static String PROFILE_TABLE_TIME_MONDAY = "//div[@class='m-stack__item m-stack__item--center m-stack__item--fluid schedule-monday']";
    public static String PROFILE_CONTACTS_FIELD_PHONE = "//a//span[@class='m-list-search__result-item-text phone']";
    public static String PROFILE_CONTACTS_FIELD_SKYPE = "//span[contains(@class,'m-list-search__result-item-text skype')]";
    public static String PROFILE_CONTACTS_FIELD_EMAIL = "//span[@class='m-list-search__result-item-text corporate-email']";

    public static String BLOCK_DEVICES = "//div[@class='m-portlet'][4]";
    public static String WINDOW_RESUME_FIRST_NAME = "//div[@class='fields']//div[3]/p[1]";
    public static String WINDOW_RESUME_LAST_NAME = "//div[@class='fields']//div[3]/p[2]";
    public static String WINDOW_RESUME_PLACE = "//div[@class='fields']//div[4]";

    public ProfilePage() {
        super();
    }

    public static boolean allElementsBlock() {
        String[] elements = {HEADER, LOGO, BLOCK_MENU, TITLE_PROFILE, BLOCK_RESUME, BLOCK_SCHEDULE_WORK
                ,BLOCK_CONTACTS,BLOCK_DEVICES};
        return allElementInBlock(elements);
    }

    private static boolean allElementInBlock(String[] elements) {
        return listElements(elements).size() == elements.length;
    }

    private static Collection listElements(String[] elements) {
        List<String> listOfElements = new LinkedList<String>();
        for (String element : elements) {
            try {
                if (wd.findElement(By.xpath(element)).isDisplayed()) {
                    listOfElements.add(element);
                }
            } catch (Exception e) {
                System.out.println("Element is not displayed:" + element);
            }
        }
        return listOfElements;
    }
}
