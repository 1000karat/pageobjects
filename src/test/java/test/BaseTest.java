package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.DataHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.LoginPage;
import page.VerificationPage;

abstract public class BaseTest {
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1000x800";
        Configuration.headless = true;
    }

    @BeforeEach
    public void login() {
        setUp();
        DataHelper dataHelper = new DataHelper();
        LoginPage loginPage = new LoginPage(dataHelper.getBaseUrl());
        VerificationPage verificationPage = new VerificationPage();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
