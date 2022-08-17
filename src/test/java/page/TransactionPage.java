package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TransactionPage {
    private final SelenideElement sum = $("[data-test-id='amount'] input");
    private final SelenideElement sender = $("[data-test-id='from'] input");
    private final SelenideElement buttonTransfer = $("[data-test-id='action-transfer']");
    private final SelenideElement buttonCancel = $("[data-test-id='action-cancel']");
    private final SelenideElement notificationError = $("[data-test-id='error-notification'] .notification__content");

    public TransactionPage() {
        buttonCancel.shouldBe(visible);
    }
    public void moneyTransaction(int fromCard, int addsum) {
        sum.setValue(String.valueOf(addsum));
        sender.setValue(DataHelper.cardNumberList(fromCard));
        buttonTransfer.click();
    }
    public SelenideElement getNotificationError() {
        return notificationError;
    }
}
