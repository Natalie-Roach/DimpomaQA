package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.util.Locale;

public class DataHelper {

    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class cardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static String cardNumberApproved() {
        return "4444444444444441";
    }

    public static String cardNumberDeclined() {
        return "4444444444444442";
    }

    public static String invalidCardNumber() {
        return "111";
    }

    public static String validMonth() {
        LocalDate validMonth = LocalDate.now();
        int month = validMonth.getMonthValue() + 3;
        return String.format("%02d", month);
    }

    public static String validYear() {
        LocalDate validYear = LocalDate.now();
        int year = validYear.getYear() - 1999;
        return Integer.toString(year);
    }

    public static String nonExistentMonth() {
        return "33";
    }

    public static String invalidYear() {
        return "1";
    }

    public static String expiredYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 3;
        return Integer.toString(year);
    }


    public static String owner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().fullName();
    }

    public static String invalidOwner() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String invalidOwnerNumbers() {
        return "12345";
    }

    public static String CVC() {
        return "999";
    }

    public static String invalidCVC() {
        return "1";
    }

    public static cardInfo approvedField() {
        return new cardInfo(cardNumberApproved(), validMonth(), validYear(), owner(), CVC());
    }

    public static cardInfo declinedField() {
        return new cardInfo(cardNumberDeclined(), validMonth(), validYear(), owner(), CVC());
    }

    public static cardInfo invalidCardNumberField() {
        return new cardInfo(invalidCardNumber(), validMonth(), validYear(), owner(), CVC());
    }

    public static cardInfo nonExistentMonthField() {
        return new cardInfo(cardNumberApproved(), nonExistentMonth(), validYear(), owner(), CVC());
    }

    public static cardInfo invalidYearField() {
        return new cardInfo(cardNumberApproved(), validMonth(), invalidYear(), owner(), CVC());
    }

    public static cardInfo expiredYearField() {
        return new cardInfo(cardNumberApproved(), validMonth(), expiredYear(), owner(), CVC());
    }

    public static cardInfo invalidOwnerField() {
        return new cardInfo(cardNumberApproved(), validMonth(), validYear(), invalidOwner(), CVC());
    }

    public static cardInfo invalidOwnerNumbersField() {
        return new cardInfo(cardNumberApproved(), validMonth(), validYear(), invalidOwnerNumbers(), CVC());
    }

    public static cardInfo invalidCVCField() {
        return new cardInfo(cardNumberApproved(), validMonth(), validYear(), owner(), invalidCVC());
    }

    public static cardInfo emptyCardNumberField() {
        return new cardInfo(" ", validMonth(), validYear(), owner(), CVC());
    }

    public static cardInfo emptyMonthField() {
        return new cardInfo(cardNumberApproved(), " ", validYear(), owner(), CVC());
    }

    public static cardInfo emptyYearField() {
        return new cardInfo(cardNumberApproved(), validMonth(), " ", owner(), CVC());
    }

    public static cardInfo emptyOwnerField() {
        return new cardInfo(cardNumberApproved(), validMonth(), validYear(), " ", CVC());
    }

    public static cardInfo emptyCVCField() {
        return new cardInfo(cardNumberApproved(), validMonth(), validYear(), owner(), " ");
    }

}
