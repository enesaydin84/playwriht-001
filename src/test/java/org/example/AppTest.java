package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://turkcellbulut.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş Yapın")).click();
            page.getByPlaceholder("Müşteri numaranızı ya da e-posta adresinizi girin").fill("23350412");
            page.getByPlaceholder("Şifrenizi Girin").fill("dssdds");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yapın")).click();
            assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Devamkkk"))).isVisible();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
