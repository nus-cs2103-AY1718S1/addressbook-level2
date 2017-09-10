package seedu.addressbook.data.person;

public class PostalCode {
    public String value;

    public PostalCode(String postalcode) {
        this.value = postalcode;
    }

    public String toString() {
        return value;
    }
}
