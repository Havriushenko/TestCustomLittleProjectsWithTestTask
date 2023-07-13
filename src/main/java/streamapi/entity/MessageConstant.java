package streamapi.entity;

public enum MessageConstant {

    EXCEPTION_ENTITY_NOT_FOUND_BY_EMAIL("Can not find Account by email= ");

    private final String value;

    MessageConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
