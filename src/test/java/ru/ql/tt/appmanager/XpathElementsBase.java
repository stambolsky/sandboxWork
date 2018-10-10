package ru.ql.tt.appmanager;

public class XpathElementsBase {

    //------------Authorization------------//

    static String LOGIN = "//input[@id='username']";
    static String PASSWORD = "//input[@id='password']";
    static String SUBMIT = "//input[@id='_submit']";

    static String AVATARCOVER = "//span[contains(@class,'m-topbar__userpic')]//div//div[contains(@class,'avatarCover')]";
    static String LINK_PROFILE = "//span[contains(@class,'m-nav__link-text')]";

    //------------ProfilePage--------------//

    static String NAME_USER = "//span[@id='headerName']";

    //static String BLOCK_RESUME = "//div[@class='m-portlet__body']//div[@class='m-portlet'][1]";
    static String AVATAR = "//img[contains(@class,'avatar')]";
    static String BUTTON_CREATE_RESUME = "//a[contains(text(), 'Сформировать резюме')]";
    static String HEADER = "//div[contains(@class,'m-portlet__head m-stack m-stack--ver m-stack--general')]";
    static String LOGO = "//div[@class='m-portlet']//div[@class='avatarCover']";
    static String BLOCK_MENU = "//div[contains(@class,'m-stack__item m-stack__item--left m-stack--ver m-stack__item--middle m-stack__item--fluid')]";
    static String TITLE_PROFILE = "//div[contains(@class,'m-subheader')]";
    static String BLOCK_RESUME = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][1]";
    static String BLOCK_SCHEDULE_WORK = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][2]";
    static String BLOCK_CONTACTS = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][3]";
    static String BLOCK_DEVICES = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][4]";





    //-------------Devices------------------//
    static String BUTTON_ADD_DEVICES = "//span[contains(text(),'Добавить устройство')]";
    static String TYPE_PC = "//div[@id='parentTypeAdd']//option[@value='2'][contains(text(),'ПК')]";
    static String TYPE_OS_LINUX = "//div[@id='parentOSAdd']//option[@value='4'][contains(text(),'Linux')]";
    static String BUTTON_DEVICE_SAVE = "//div[@id='popup-add-environment']//button[@name='save'][contains(text(),'Сохранить')]";



}
