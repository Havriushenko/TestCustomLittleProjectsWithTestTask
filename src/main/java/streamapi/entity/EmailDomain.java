package streamapi.entity;

/**
 * Domain types.
 */
public enum EmailDomain {

    GMAIL("gmail.com"),
    RAMBLER("rambler.com"),
    MAC("mac.com"),
    ABCLOUDZ("abcloudz.com");

    String domain;

    EmailDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }
}
