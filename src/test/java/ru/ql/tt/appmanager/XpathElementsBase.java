package ru.ql.tt.appmanager;

public class XpathElementsBase {


    //------------Authorization------------//


    public static String LOGIN = "//input[@id='username']";
    public static String PASSWORD = "//input[@id='password']";
    public static String SUBMIT = "//input[@id='_submit']";
    public static String AVATARCOVER = "//span//div[@class='avatarCover']";
    public static String LINK_PROFILE = "//span[contains(@class,'m-nav__link-text')]";


    //------------ProfilePage--------------//

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


    //------------Window create resume------//

    public static String WINDOW_RESUME_FIRST_NAME = "//div[@class='fields']//div[3]/p[1]";
    public static String WINDOW_RESUME_LAST_NAME = "//div[@class='fields']//div[3]/p[2]";
    public static String WINDOW_RESUME_PLACE = "//div[@class='fields']//div[4]";


    //------------Resume--------------------//

    public static String MODAL_WINDOW_EDIT_RESUME = "//div[@id='popup-edit-resume']//div[@class='modal-content']";
    public static String MODAL_WINDOW_EDIT_TITLE = "//div[@id='popup-edit-resume']//h5[@id='exampleModalLabel']";
    public static String MODAL_WINDOW_EDIT_TEXTAREA = "//textarea[@id='post-description']";
    public static String MODAL_WINDOW_EDIT_BUTTON_SAVE = "//div[@id='popup-edit-resume']//button[2]";
    public static String MODAL_WINDOW_EDIT_TIP_TEXTAREA = "//form[@class='post-info']//div[3]";
    public static String MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-resume']//button[contains(text(),'Закрыть без сохранения')]";
    public static String MODAL_RESUME_EDIT_ICON_CROSS = "//div[@id='popup-edit-resume']//button[@class='close']";


    //-------------Schedule work------------//

    public static String MODAL_WINDOW_EDIT_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//div[@class='modal-content']";
    public static String MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//h5";
    public static String MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[1]//div[1]//input[1]";
    public static String MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK = "//div[@id='popup-edit-schedule']//form//div[@class='form-group m-form__group row']//div[2]//div[1]//input[1]";
    public static String MODAL_WINDOW_EDIT_TIME_HOUR_UP = "//tbody//tr[1]//td[1]/a";
    public static String MODAL_WINDOW_EDIT_TIME_MINUTE_UP = "//tbody//tr[1]//td[3]/a";
    public static String MODAL_WINDOW_EDIT_BUTTON_SAVE_RESUME = "//div[@id='popup-edit-schedule']//button[2]";
    public static String MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-schedule']//button[contains(text(),'Закрыть без сохранения')]";
    public static String MODAL_WINDOW_EDIT_ICON_CROSS = "//div[@id='popup-edit-schedule']//div[@class='modal-header']//button";


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
    public static String TABLE_ICON_TRASH = "//tr[@class='m-datatable__row'][1]//a[2]";
    public static String TABLE_ICON_EDIT = "//tr[@class='m-datatable__row'][1]//a[1]";
    public static String BUTTON_DELETE_DEVICE = "//div[@id='popup-delete-environment']//div[@class='modal-footer']//button[2]";
    public static String TABLE_MESSAGE_EMPTY = "//div[@class='alert m-alert--default col-lg-12 no-items']";

    public static String TYPE_OS_LINUX = "//div[@id='parentOSAdd']//option[@value='4'][contains(text(),'Linux')]";
    public static String BUTTON_DEVICE_SAVE = "//div[@id='popup-add-environment']//button[@name='save']";
    public static String EDIT_WINDOW_OS_ANDROID = "//div[@id='parentOSEdit']//option[@value='2'][contains(text(),'Android')]";
    public static String EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-environment']//button[@type='button'][contains(text(),'Закрыть без сохранения')]";
    public static String EDIT_WINDOW_ICON_CROSS = "//div[@id='popup-edit-environment']//div[@class='modal-header']//button[@type='button']";


    //--------------Contacts-----------------//

    public static String BUTTON_EDIT_CONTACTS = "//button[contains(text(),'Редактировать контакты')]";
    public static String MODAL_WINDOW_EDIT_CONTACTS = "//div[@id='popup-edit-contact']//div[@class='modal-content']";
    public static String TITLE_MODAL_WINDOW_EDIT_CONTACTS = "//div[@id='popup-edit-contact']//h5";
    public static String MODAL_EDIT_PHONE_FIELD = "//input[@id='phone']";
    public static String MODAL_EDIT_SKYPE_FIELD = "//input[@id='skype']";
    public static String MODAL_EDIT_SAVE_BUTTON = "//div[@id='popup-edit-contact']//button[2]";
    public static String MODAL_EDIT_EMAIL = "//input[@id='corporate-email']";
    public static String MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE = "//div[@id='popup-edit-contact']//button[contains(text(),'Закрыть без сохранения')]";
    public static String MODAL_EDIT_ICON_CROSS = "//div[@id='popup-edit-contact']//button[@class='close']";




}
