package streamapi;


import mock.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streamapi.entity.Account;
import streamapi.exception.EntityNotFoundException;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static streamapi.entity.EmailDomain.ABCLOUDZ;
import static streamapi.entity.EmailDomain.GMAIL;
import static streamapi.entity.EmailDomain.RAMBLER;
import static streamapi.entity.MessageConstant.EXCEPTION_ENTITY_NOT_FOUND_BY_EMAIL;

class CrazyStreamsTest {

    private Account masha;
    private Account vasia;
    private Account asher;
    private Account nata;

    private List<Account> accounts;
    private List<Account> maleAccounts;
    private List<Account> femaleAccounts;
    private List<Account> gmailAccounts;
    private List<Account> sortedListByFirstAndLastName;
    private Map<Integer, Account> accountsMap;

    private CrazyStreams test;

    @BeforeEach
    void setUp() {
        // Accounts
        masha = Mock.getMockAccountOne();
        vasia = Mock.getMockAccountTwo();
        asher = Mock.getMockAccountThree();
        nata = Mock.getMockAccountFour();
        //Account lists
        accounts = List.of(masha, vasia, asher, nata);
        maleAccounts = List.of(vasia, asher);
        femaleAccounts = List.of(masha, nata);
        gmailAccounts = List.of(masha, nata);
        sortedListByFirstAndLastName = List.of(asher, masha, nata, vasia);
        accountsMap = Map.of(masha.getId(), masha, vasia.getId(), vasia, asher.getId(), asher, nata.getId(), nata);

        test = new CrazyStreams(accounts);
    }

    @Test
    public void findRichestPerson() {
        Optional<Account> result = test.findRichestPerson();

        assertEquals(vasia, result.get());
    }

    @Test
    public void findAccountsByBirthdayMonth() {
        List<Account> result = test.findAccountsByBirthdayMonth(Month.DECEMBER);

        assertEquals(vasia, result.get(0));
        assertEquals(nata, result.get(1));
    }

    @Test
    public void partitionMaleAccounts() {
        Map<Boolean, List<Account>> resultMap = test.partitionMaleAccounts();
        List<Account> result = resultMap.get(true);

        assertEquals(maleAccounts, result);
    }

    @Test
    public void partitionFemaleAccounts() {
        Map<Boolean, List<Account>> resultMap = test.partitionMaleAccounts();
        List<Account> result = resultMap.get(false);

        assertEquals(femaleAccounts, result);
    }

    @Test
    public void getGmailDomainAccountsWhenGroupListByDomain() {
        Map<String, List<Account>> result = test.groupAccountByEmailDomain();

        assertEquals(gmailAccounts, result.get(GMAIL.getDomain()));
    }

    @Test
    public void getRamblerDomainAccountsWhenGroupListByDomain() {
        Map<String, List<Account>> result = test.groupAccountByEmailDomain();

        assertEquals(List.of(vasia), result.get(RAMBLER.getDomain()));
    }

    @Test
    public void numOfLettersInFirstAndLastNames() {
        int result = test.getNumOfLettersInFirstAndLastNames();

        assertEquals(52, result);
    }

    @Test
    public void getTotalBalanceOfAllAccounts() {
        BigDecimal result = test.calculateTotalBalance();

        assertEquals(BigDecimal.valueOf(526310898), result);
    }

    @Test
    public void sortListByFirstAndLastName() {
        List<Account> result = test.sortByFirstAndLastName();

        assertEquals(sortedListByFirstAndLastName, result);
    }

    @Test
    public void findAccountWithRamblerDomainAndReturnTrue() {
        boolean result = test.containsAccountWithEmailDomain(RAMBLER.getDomain());

        assertTrue(result);
    }

    @Test
    public void findAccountWithAbcloudzDomainAndReturnFalse() {
        boolean result = test.containsAccountWithEmailDomain(ABCLOUDZ.getDomain());

        assertFalse(result);
    }

    @Test
    public void findBalanceByEmailAndReturnBalanceOfAccount() {
        BigDecimal result = test.getBalanceByEmail("vasia@rambler.com");

        assertEquals(vasia.getBalance(), result);
    }

    @Test
    public void findBalanceByEmailAndThrowExceptionAccountNotFound() {
        //before
        String testEmail = "test@rambler.com";

        Exception ex = assertThrows(EntityNotFoundException.class, () -> test.getBalanceByEmail(testEmail));
        String resultMessage = ex.getMessage();

        assertEquals(EXCEPTION_ENTITY_NOT_FOUND_BY_EMAIL + testEmail, resultMessage);
    }

    @Test
    public void collectAccountsByIdAndReturnMapOfAccounts() {
        Map<Integer, Account> result = test.collectAccountsById();

        assertEquals(accountsMap, result);
    }
}