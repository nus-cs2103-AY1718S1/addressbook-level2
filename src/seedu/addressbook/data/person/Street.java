package seedu.addressbook.data.person;

/**
 * Represents a Person's Address' Street in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet(String)}
 */

public class Street {
    public static final String EXAMPLE = "Clementi Ave 2";
    public static final String MESSAGE_STREET_CONSTRAINTS =
                "Person street should only contain alphabetic characters or numbers";
    public static final String STREET_VALIDATION_REGEX = "[\\p{Alpha} ]+$";

    public final String value;
    private boolean isPrivate;
}
