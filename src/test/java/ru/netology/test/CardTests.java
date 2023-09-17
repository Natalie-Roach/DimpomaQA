package ru.netology.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.CardPage;
import ru.netology.data.SQLHelper;

import static com.codeborne.selenide.Selenide.open;


public class CardTests {

    @BeforeEach
    void setup() {
        open(System.getProperty("sut.url"));
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SQLHelper.cleanDataBase();
    }


    @Test
    @DisplayName("Сценарий №1 - Успешная оплата по дебетовой карте со статусом APPROVED (Payment Gate)")
    public void shouldFillInFormWithApprovedCardForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    @DisplayName("Сценарий №1 - Успешная оплата по кредитной карте со статусом APPROVED (Credit Gate)")
    public void shouldFillInFormWithApprovedCardForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    @DisplayName("Сценарий №2 - Запись о неуспешной операции по дебетовой карте со статусом DECLINED (Payment Gate)")
    public void shouldFillInFormWithDeclinedCardForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    @DisplayName("Сценарий №2 - Запись о неуспешной операции по кредитной карте со статусом DECLINED (Credit Gate)")
    public void shouldFillInFormWithDeclinedCardForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    @DisplayName("Сценарий №3 - Невалидный формат номера дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithInvalidCardNumberForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.invalidCardNumberField();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    @DisplayName("Сценарий №3 - Невалидный формат номера кредитной карты (Credit Gate)")
    public void shouldFillInFormWithInvalidCardNumberForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        ;
        var cardInfo = DataHelper.invalidCardNumberField();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    @DisplayName("Сценарий №4 - Невалидный месяц для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithInvalidMonthForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.nonExistentMonthField();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    @DisplayName("Сценарий №4 - Невалидный месяц для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithInvalidMonthForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.nonExistentMonthField();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    @DisplayName("Сценарий №5 - Невалидный год для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithInvalidYearForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.invalidYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    @DisplayName("Сценарий №5 - Невалидный год для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithInvalidYearForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.invalidYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    @DisplayName("Сценарий №6 - Истёкший срок годности для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithExpiredYearForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.expiredYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    @DisplayName("Сценарий №6 - Истёкший срок годности для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithExpiredYearForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.expiredYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    @DisplayName("Сценарий №7 - Невалидное значение в поле Владелец (кириллица) для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithInvalidOwnerCyrillicForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.invalidOwnerField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    @DisplayName("Сценарий №7 - Невалидное значение в поле Владелец (кириллица) для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithInvalidOwnerCyrillicForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.invalidOwnerField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    @DisplayName("Сценарий №8 - Невалидное значение в поле Владелец (цифры) для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithInvalidOwnerNumbersForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.invalidOwnerNumbersField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    @DisplayName("Сценарий №8 - Невалидное значение в поле Владелец (цифры) для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithInvalidOwnerNumbersForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.invalidOwnerNumbersField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    @DisplayName("Сценарий №9 - Невалидное значение в поле CVC для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithInvalidCVCForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.invalidCVCField();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    @DisplayName("Сценарий №9 - Невалидное значение в поле CVC для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithInvalidCVCForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.invalidCVCField();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    @DisplayName("Сценарий №10 - Пустое поле номера карты для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithEmptyCardFieldForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.emptyCardNumberField();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    @DisplayName("Сценарий №10 - Пустое поле номера карты для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithEmptyCardFieldForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.emptyCardNumberField();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    @DisplayName("Сценарий №11 - Пустое поле месяца для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithEmptyMonthFieldForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.emptyMonthField();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    @DisplayName("Сценарий №11 - Пустое поле месяца для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithEmptyMonthFieldForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.emptyMonthField();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    @DisplayName("Сценарий №12 - Пустое поле года для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithEmptyYearFieldForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.emptyYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    @DisplayName("Сценарий №12 - Пустое поле года для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithEmptyYearFieldForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.emptyYearField();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    @DisplayName("Сценарий №13 - Пустое поле Владелец для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithEmptyOwnerFieldForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.emptyOwnerField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    @DisplayName("Сценарий №13 - Пустое поле Владелец для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithEmptyOwnerFieldForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.emptyOwnerField();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    @DisplayName("Сценарий №14 - Пустое поле CVC для дебетовой карты (Payment Gate)")
    public void shouldFillInFormWithEmptyCVCFieldForPaymentGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInDebitButton();
        var cardInfo = DataHelper.emptyCVCField();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    @DisplayName("Сценарий №14 - Пустое поле CVC для кредитной карты (Credit Gate)")
    public void shouldFillInFormWithEmptyCVCFieldForCreditGate() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditButton();
        var cardInfo = DataHelper.emptyCVCField();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

}
