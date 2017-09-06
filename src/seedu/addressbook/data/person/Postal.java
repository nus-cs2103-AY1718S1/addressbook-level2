package seedu.addressbook.data.person;

/**
 * Represents an Address' Postal Code in the address book.
 * Guarantees: is an string.
 */

public class Postal {
    private String postalCode;

    public Postal(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostal() {
        return postalCode;
    }


}
