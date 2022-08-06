package test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.TransactionPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AppTest extends BaseTest{

    @Test
    public void transactionToFirstCardZero() {
        int toCard = 2;
        int fromCard = 1;
        int addsum = 0;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceFirstCard = dashboardPage.getFirstCardBalance();

        dashboardPage.transactionPage(toCard);
        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        int expected = firstBalanceFirstCard - addsum;
        int actual = dashboardPage.getFirstCardBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transactionToFirstCardOne() {
        int toCard = 1;
        int fromCard = 2;
        int addsum = 1;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceFirstCard = dashboardPage.getFirstCardBalance();

        dashboardPage.transactionPage(toCard);
        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        int expected = firstBalanceFirstCard + addsum;
        int actual = dashboardPage.getFirstCardBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transactionToSecondCardOne() {
        int toCard = 2;
        int fromCard = 1;
        int addsum = 1;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceFirstCard = dashboardPage.getFirstCardBalance();

        dashboardPage.transactionPage(toCard);
        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        int expected = firstBalanceFirstCard - addsum;
        int actual = dashboardPage.getFirstCardBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transactionToFirstCardMoreBalance() {
        int toCard = 2;
        int fromCard = 1;
        int addsum = 11000;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceFirstCard = dashboardPage.getFirstCardBalance();

        dashboardPage.transactionPage(toCard);
        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        int expected = firstBalanceFirstCard - addsum;
        int actual = dashboardPage.getFirstCardBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void transactionFromCardNumberThird() {
        int toCard = 1;
        int fromCard = 3;
        int addsum = 11000;

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.transactionPage(toCard);
        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        String notification = "Произошла ошибка";
        $x("//div[@class='notification__content']").should(appear, Duration.ofSeconds(3)).should(Condition.text(notification));
    }
}
