package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import page.TransactionPage;
import page.VerificationPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AppTest {

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1000x800";
        Configuration.headless = true;
        LoginPage loginPage = new LoginPage(DataHelper.BASE_URL);
        VerificationPage verificationPage = new VerificationPage();
    }

    @Test
    public void transactionToFirstCardZero() {
        int toCard = 0;
        int fromCard = 1;
        int addsum = 0;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceCard = dashboardPage.getFirstCardBalance();
        int secondBalanceCard = dashboardPage.getSecondCardBalance();
        dashboardPage.transactionPage(toCard);

        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        assertEquals(firstBalanceCard + addsum, dashboardPage.getFirstCardBalance());
        assertEquals(secondBalanceCard - addsum, dashboardPage.getSecondCardBalance());
    }

    @Test
    public void transactionToFirstCard() {
        int toCard = 0;
        int fromCard = 1;
        int addsum = 1000;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceCard = dashboardPage.getFirstCardBalance();
        int secondBalanceCard = dashboardPage.getSecondCardBalance();
        dashboardPage.transactionPage(toCard);

        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        assertEquals(firstBalanceCard + addsum, dashboardPage.getFirstCardBalance());
        assertEquals(secondBalanceCard - addsum, dashboardPage.getSecondCardBalance());
    }

    @Test
    public void transactionToSecondCard() {
        int toCard = 1;
        int fromCard = 0;
        int addsum = 2000;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceCard = dashboardPage.getFirstCardBalance();
        int secondBalanceCard = dashboardPage.getSecondCardBalance();
        dashboardPage.transactionPage(toCard);

        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        assertEquals(firstBalanceCard - addsum, dashboardPage.getFirstCardBalance());
        assertEquals(secondBalanceCard + addsum, dashboardPage.getSecondCardBalance());
    }

    @Test
    public void transactionToFirstCardMoreBalance() {
        int toCard = 1;
        int fromCard = 0;
        int addsum = 11000;

        DashboardPage dashboardPage = new DashboardPage();
        int firstBalanceCard = dashboardPage.getFirstCardBalance();
        int secondBalanceCard = dashboardPage.getSecondCardBalance();
        dashboardPage.transactionPage(toCard);

        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        assertEquals(firstBalanceCard - addsum, dashboardPage.getFirstCardBalance());
        assertEquals(secondBalanceCard + addsum, dashboardPage.getSecondCardBalance());
    }

    @Test
    public void transactionFromCardNumberThird() {
        int toCard = 1;
        int fromCard = 2;
        int addsum = 50000;

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.transactionPage(toCard);

        TransactionPage transactionPage = new TransactionPage();
        transactionPage.moneyTransaction(fromCard, addsum);

        String expected = transactionPage.getNotificationError().shouldBe(appear, Duration.ofSeconds(3)).getText();

        assertEquals(expected, "Ошибка! Произошла ошибка");
    }
}
