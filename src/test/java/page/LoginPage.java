package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginFiled = $("[data-test-id='login'] input");
    private final SelenideElement passwordFiled = $("[data-test-id='password'] input");
    private final SelenideElement buttonLogin = $("[data-test-id='action-login']");

    public LoginPage(String url) {
        Selenide.open(url);
        DataHelper dataHelper = new DataHelper();
        loginFiled.setValue(dataHelper.getLogin());
        passwordFiled.setValue(dataHelper.getPassword());
        buttonLogin.click();
    }
}
