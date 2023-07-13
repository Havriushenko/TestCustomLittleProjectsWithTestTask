package mock;

import streamapi.entity.Account;
import streamapi.entity.Birthday;
import streamapi.entity.Sex;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;

public class Mock {

    public static Account getMockAccountOne() {
        return Account.builder()
            .id(1)
            .firstName("Masha")
            .lastName("Mishulina")
            .email("masha@gmail.com")
            .birthday(Birthday.builder()
                .day(25)
                .mouth(Month.AUGUST)
                .year(Year.now())
                .build())
            .balance(BigDecimal.valueOf(3054321))
            .sex(Sex.FEMALE)
            .build();
    }

    public static Account getMockAccountTwo() {
        return Account.builder()
            .id(2)
            .firstName("Vasiliy")
            .lastName("Zhdanov")
            .email("vasia@rambler.com")
            .birthday(Birthday.builder()
                .day(18)
                .mouth(Month.DECEMBER)
                .year(Year.now())
                .build())
            .balance(BigDecimal.valueOf(523012323))
            .sex(Sex.MALE)
            .build();
    }

    public static Account getMockAccountThree() {
        return Account.builder()
            .id(3)
            .firstName("Asher")
            .lastName("Abrahim")
            .email("Asher@mac.com")
            .birthday(Birthday.builder()
                .day(7)
                .mouth(Month.MARCH)
                .year(Year.now())
                .build())
            .balance(BigDecimal.valueOf(234231))
            .sex(Sex.MALE)
            .build();
    }

    public static Account getMockAccountFour() {
        return Account.builder()
            .id(4)
            .firstName("Nata")
            .lastName("Shevchuk")
            .email("nata@gmail.com")
            .birthday(Birthday.builder()
                .day(9)
                .mouth(Month.DECEMBER)
                .year(Year.now())
                .build())
            .balance(BigDecimal.valueOf(10023))
            .sex(Sex.FEMALE)
            .build();
    }
}
