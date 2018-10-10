package ru.ql.tt.appmanager;

public class XpathElementsBase {

    //------------Authorization------------//

    public static String LOGIN = "//input[@id='username']";
    public static String PASSWORD = "//input[@id='password']";
    public static String SUBMIT = "//input[@id='_submit']";

    public static String AVATARCOVER = "//span[contains(@class,'m-topbar__userpic')]//div//div[contains(@class,'avatarCover')]";
    public static String LINK_PROFILE = "//span[contains(@class,'m-nav__link-text')]";

    //------------ProfilePage--------------//

    public static String NAME_USER = "//span[@id='headerName']";

    //static String BLOCK_RESUME = "//div[@class='m-portlet__body']//div[@class='m-portlet'][1]";
    public static String AVATAR = "//img[contains(@class,'avatar')]";
    public static String BUTTON_CREATE_RESUME = "//a[contains(text(), 'Сформировать резюме')]";
    public static String HEADER = "//div[contains(@class,'m-portlet__head m-stack m-stack--ver m-stack--general')]";
    public static String LOGO = "//div[@class='m-portlet']//div[@class='avatarCover']";
    public static String BLOCK_MENU = "//div[contains(@class,'m-stack__item m-stack__item--left m-stack--ver m-stack__item--middle m-stack__item--fluid')]";
    public static String TITLE_PROFILE = "//div[contains(@class,'m-subheader')]";
    public static String BLOCK_RESUME = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][1]";
    public static String BLOCK_SCHEDULE_WORK = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][2]";
    public static String BLOCK_CONTACTS = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][3]";
    public static String BLOCK_DEVICES = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][4]";





    //-------------Devices------------------//
    public static String MODAL_WINDOW_DEVICE = "//div[@id='popup-add-environment']//div[@class='modal-content']";
    public static String TITLE_WINDOW_DEVICE = "//h5[contains(text(),'Добавление нового устройства')]";
    public static String BUTTON_ADD_DEVICES = "//span[contains(text(),'Добавить устройство')]";
    public static String TYPE_PC = "//div[@id='parentTypeAdd']//option[@value='2'][contains(text(),'ПК')]";
    public static String TYPE_PHONE = "//div[@id='parentTypeAdd']//option[@value='6'][contains(text(),'Телефон')]";
    public static String PRODUCER_FIELD = "//div[@id='popup-add-environment']//input[@name='manufacturer-device']";
    public static String TABLE_FIELD_TYPE_PHONE = "//td[contains(text(),'Телефон')]";
    public static String TABLE_FIELD_TYPE_PC  = "//td[contains(text(),'ПК')]";
    public static String TABLE_TYPE_PRODUSER = "//td[contains(text(),'APPLE')]";
    public static String TABLE_ICON_TRASH = "//tbody[@class='m-datatable__body']/tr[1]/td[7]/a[2]";
    public static String TABLE_ICON_EDIT = "//a[@class='btn m-btn btn-nav-action m-btn--icon m-btn--icon-only m-btn--pill edit-environment']";
    public static String BUTTON_DELETE_DEVICE = "//div[@id='popup-delete-environment']//button[@type='button'][contains(text(),'Удалить')]";
    public static String TABLE_MESSAGE_EMPTY = "//div[@class='alert m-alert--default col-lg-12 no-items']";

    public static String TYPE_OS_LINUX = "//div[@id='parentOSAdd']//option[@value='4'][contains(text(),'Linux')]";
    public static String BUTTON_DEVICE_SAVE = "//div[@id='popup-add-environment']//button[@name='save'][contains(text(),'Сохранить')]";
    public static String EDIT_WINDOW_OS_ANDROID = "//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]";
    public static String EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-environment']//button[@type='button'][contains(text(),'Закрыть без сохранения')]";
    public static String EDIT_WINDOW_ICON_CROSS = "//div[@id='popup-edit-environment']//div[@class='modal-header']//button[@type='button']";



}
