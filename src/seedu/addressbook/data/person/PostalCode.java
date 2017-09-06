package seedu.addressbook.data.person;

/**
 * Represents a Person's Address' Postal Code number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */

public class PostalCode {

    public static final String EXAMPLE = "735654";
    public static final String MESSAGE_PHONE_CONSTRAINTS = "Person Postal Code number should only contain numbers";
    public static final String PHONE_VALIDATION_REGEX = "\\d+";

    public final String value;
    private boolean isPrivate;

}
