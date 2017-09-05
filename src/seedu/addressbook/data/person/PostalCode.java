package seedu.addressbook.data.person;

public class PostalCode {

    private String value;

    public PostalCode (String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
