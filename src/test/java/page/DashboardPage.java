package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private final SelenideElement buttonReload = $("[data-test-id='action-reload']");
    private ElementsCollection cards = $$(".list__item div"); //balance
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private final ElementsCollection buttonTransaction = $$("[data-test-id='action-deposit']");

    public DashboardPage() {
        buttonReload.shouldBe(visible);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    public int getSecondCardBalance() {
        val text = cards.last().text();
        return extractBalance(text);
    }

    public TransactionPage transactionPage(int toCard) {
        if (toCard == 1) {
            buttonTransaction.first().click();
            return new TransactionPage();
        }
        buttonTransaction.last().click();
        return new TransactionPage();
    }
}
