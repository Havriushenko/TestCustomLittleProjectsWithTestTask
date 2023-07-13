package streamapi;

import streamapi.entity.Account;
import streamapi.entity.Sex;
import streamapi.exception.EntityNotFoundException;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static streamapi.entity.MessageConstant.EXCEPTION_ENTITY_NOT_FOUND_BY_EMAIL;

public class CrazyStreams {

    private Collection<Account> accounts;

    public CrazyStreams(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Returns {@link Optional} that contains an {@link Account} with the max value of balance
     *
     * @return account with max balance wrapped with optional
     */
    public Optional<Account> findRichestPerson() {
        return accounts.stream().max(comparing(Account::getBalance));
//        return accounts.stream().max(Comparator.comparing(a -> a.getBalance()));
    }

    /**
     * Return a {@link List} of {@link Account} that have a birthday month equal to provided.
     *
     * @param birthdayMonth a month of birth
     * @return a list of accounts
     */
    public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
        return accounts.stream()
            .filter(a -> a.getBirthday().getMouth().equals(birthdayMonth))
            .collect(Collectors.toList());
    }

    /**
     * Returns a map that separates all accounts into two lists - male and female. Map has two keys {@code true} indicates
     * a male list, and {@code false} indicates female list.
     *
     * @return a map where key is true or false and value is list of male and female accounts
     */
    public Map<Boolean, List<Account>> partitionMaleAccounts() {
        return accounts.stream()
            .collect(Collectors.partitioningBy(a -> a.getSex().equals(Sex.MALE)));
    }

    /**
     * Returns a {@link Map} that stores accounts grouped by its email domain. A pam key is {@link String} whitch is an
     * email domain like "gmail.com". The value is a {@link List} of {@link Account} objects with a specific email domain.
     *
     * @return a map where key is an email domain and value is a list of all account with such email
     */
    public Map<String, List<Account>> groupAccountByEmailDomain() {
        return accounts.stream()
            .collect(Collectors.groupingBy(accounts -> extractEmailDomain(accounts)));
    }

    private static String extractEmailDomain(Account account) {
        return account.getEmail().split("@")[1];
    }

    /**
     * Returns a number of letters in all first and last names
     *
     * @return total number of letters of first and last names of all accounts
     */
    public int getNumOfLettersInFirstAndLastNames() {
        return accounts.stream().mapToInt(a -> a.getFirstName().length() + a.getLastName().length())
            .sum();
    }

    /**
     * Returns a total balance of all accounts.
     *
     * @return total balance of all accounts
     */
    public BigDecimal calculateTotalBalance() {
        return accounts.stream()
            .map(Account::getBalance)
//            .reduce(BigDecimal.ZERO, ((bigDecimal, bigDecimal2) -> bigDecimal.add(bigDecimal2)))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Return a {@link List} of {@link Account} objects sorted by first and last name.
     *
     * @return list of accounts sorted by first and last names
     */
    public List<Account> sortByFirstAndLastName() {
        return accounts.stream()
            .sorted(comparing(Account::getFirstName).thenComparing(Account::getLastName))
            .collect(Collectors.toList());
    }

    /**
     * Checks if there is at least one account with provided email domain
     *
     * @param emailDomain
     * @return true if there is an account that has an email with provided domain
     */
    public boolean containsAccountWithEmailDomain(String emailDomain) {
        return accounts.stream()
            .map(account -> extractEmailDomain(account))
            .anyMatch(domain -> domain.equals(emailDomain));
    }

    /**
     * Return account balance by its email. Throws {@link EntityNotFoundException} with message
     * "Can not find Account by email={email}" if account is not found
     *
     * @param email
     * @return account balance
     */
    public BigDecimal getBalanceByEmail(String email) {
        return accounts.stream()
            .filter(account -> account.getEmail().equals(email))
            .findAny()
//            .get()
//            .getBalance();
            .map(Account::getBalance)
            .orElseThrow(() -> new EntityNotFoundException(EXCEPTION_ENTITY_NOT_FOUND_BY_EMAIL + email));
    }

    /**
     * Collects all existing accounts into {@link Map} where a key is account id, and the value is {@link Account} instance.
     *
     * @return map of accounts by its ids
     */
    public Map<Integer, Account> collectAccountsById() {
        return accounts.stream()
//            .collect(Collectors.toMap(account -> account.getId(),a -> a));
//            .collect(Collectors.toMap(Account::getId, Function.identity()));
            .collect(Collectors.toMap(Account::getId, identity()));
    }

    /**
     * Filters accounts by the year when an account was created. Collects account balances by its emails into a {@link Map}.
     * The key is{@link Account#email} and the value is {@link Account#balance}
     *
     * @param year
     * @returnmap of account by its ids the were created in a particular year
     */
    public Map<String, BigDecimal> collectBalancesByEmailForAccountsCreatedOn(int year) {
        throw new IllegalArgumentException();
    }

    /**
     * Returns a {@link Map} where key is {@link Account#lastName} and values is a {@link Set} that contains first names
     * of all accounts with a specific last name.
     *
     * @return a map where key is a last name and value is a set of first names
     */
    public Map<String, Set<String>> groupFirstNamesByLastNames() {
        throw new IllegalArgumentException();
    }

    /**
     * Returns a {@link Map} where key is a birthday month, and value is a {@link String} that stores comma and space
     * -separated first names (e.g. "Polly, Dylan, Clark"), of all accounts that have the same birthday month
     *
     * @return a map where a key is birthday month and value is comma-separated first names
     */
    public Map<Month, String> groupCommaSeparatedFirstNamesByBirthdayMonth() {
        throw new IllegalArgumentException();
    }

    /**
     * Returns a {@link Map} where key is a {@link Month} of {@link Account#creationDate}, and value is total balance
     * of all accounts that have the some value creation month.
     *
     * @return a map where key is a creation month and value is total balance of all accounts created in that month
     */
    public Map<Month, BigDecimal> groupTotalBalanceByCreationMonth() {
        throw new IllegalArgumentException();
    }

    /**
     * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences in
     * {@link Account#firstName}.
     *
     * @return a map where key is a letter and value is its count in all first names
     */
    public Map<Character, Long> getCharacterFrequencyInFirstNames() {
        throw new IllegalArgumentException();
    }

    /**
     * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences ignoring
     * case, in all {@link Account#firstName} and {@link Account#lastName}. All letters should stored in lower case.
     *
     * @return a map where key is a letter and value is its count ignoring case in all first and last names
     */
    public Map<Character, Long> getCharacterFrequencyIgnoreCaseInFirstAndLastNames() {
        throw new IllegalArgumentException();
    }
}
