package ru.ql.tt.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationManager {
    public WebDriver wd;
    private String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void checkBrowser() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void init() {
        open();
        login("Мистер АвтоМяу", "12345678");
    }

    public void open() {
        wd.get("http://tt-develop.quality-lab.ru/login");
    }

    private void login(String username, String password) {
        Assert.assertTrue(wd.findElement(By.xpath("//input[@id='username']")).isDisplayed());
        Assert.assertTrue(wd.findElement(By.xpath("//input[@id='password']")).isDisplayed());
        wd.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        wd.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        wd.findElement(By.xpath("//input[@id='_submit']")).click();
    }

    public String checkPageUrl() {
        String page = wd.getCurrentUrl();
        return page;
    }

    public void goToProfile() {
        wd.findElement(By.xpath("//span[contains(@class,'m-topbar__userpic')]//div//div[contains(@class,'avatarCover')]")).click();
        wd.findElement(By.xpath("//span[contains(@class,'m-nav__link-text')]")).click();
    }

    public void stop() {
        wd.quit();
    }

    public String getLogin() {
        String name = wd.findElement(By.xpath("//span[@id='headerName']")).getText();
        return name;
    }

    public boolean UserPhotoAboveResume() {
        boolean res = true;
        int firstElement = wd.findElement(By.xpath("//img[contains(@class,'avatar')]")).getLocation().getX();
        int secondElement = wd.findElement(By.xpath("//div[@class='m-portlet__body']//div[@class='m-portlet'][1]")).getLocation().getY();
        if (firstElement - secondElement > 0) {
            res = false;
        }
        return res;
    }

    public boolean checkColorButtonCreateResume() {
        boolean res = true;
        String color = wd.findElement(By.xpath("//a[contains(text(), 'Сформировать резюме')]")).getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        if (!hex.equals("#716aca")) {
            res = false;
        }
        return res;
    }




    public boolean allElementsBlock() {
        String menu = "//div[contains(@class,'m-portlet__head m-stack m-stack--ver m-stack--general')]";
        String logo = "//div[@class='m-portlet']//div[@class='avatarCover']";
        String menuBlock = "//div[contains(@class,'m-stack__item m-stack__item--left m-stack--ver m-stack__item--middle m-stack__item--fluid')]";
        String titleProfile = "//div[contains(@class,'m-subheader')]";
        String resume = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][1]";
        String scheduleWork = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][2]";
        String contacts = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][3]";
        String devices = "//div[@id='m_tabs_6_1']/div[@class='m-portlet'][4]";
        String[] elements = {menu, logo, menuBlock, titleProfile, resume, scheduleWork, contacts,devices};
        return allElementInBlock(elements);
    }

    private boolean allElementInBlock(String[] elements) {
        return listElements(elements).size() == elements.length;
    }

    private Collection listElements(String[] elements) {
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

