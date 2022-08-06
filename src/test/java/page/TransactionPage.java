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
    DataHelper dataHelper = new DataHelper();

    public TransactionPage() {
        buttonCancel.shouldBe(visible);
    }

    public void moneyTransaction(int fromCard, int addsum) {
        if (fromCard == 1) {
            sum.setValue(String.valueOf(addsum));
            sender.setValue(dataHelper.getCardNumberFirst());
            buttonTransfer.click();
            return;
        }
        if (fromCard == 2) {
            sum.setValue(String.valueOf(addsum));
            sender.setValue(dataHelper.getCardNumberSecond());
            buttonTransfer.click();
            return;
        }
        if (fromCard == 3) {
            sum.setValue(String.valueOf(addsum));
            sender.setValue(dataHelper.getCardNumberThird());
            buttonTransfer.click();
            return;
        }
    }
}
