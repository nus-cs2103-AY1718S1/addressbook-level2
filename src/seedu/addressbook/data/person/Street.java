package seedu.addressbook.data.person;

public class Street {

    private String value;

    public Street (String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
