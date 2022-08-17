package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement buttonVerify = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(visible);
        codeField.setValue(DataHelper.CODE);
        buttonVerify.click();
    }
}
