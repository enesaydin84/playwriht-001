package org.example;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;


public class App 
{
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://stb.turkcellbulut.com/");
            page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Giriş Yapın")).click();
            page.getByPlaceholder("Müşteri numaranızı ya da e-posta adresinizi girin").fill("23350412");
            page.getByPlaceholder("Şifrenizi Girin").fill("dssdds");
            page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Giriş Yapın")).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(page.title());
        }
    }}
