package seedu.addressbook.data.person;

/**
 * Represents a Person's Address' unit number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */

public class Unit {

    public static final String EXAMPLE = "#01-653";
    public static final String MESSAGE_UNIT_CONSTRAINTS =
                "Person phone numbers should only contain the hashtag symbol and numbers";
    public static final String UNIT_VALIDATION_REGEX = "\\d+";

    public final String value;
    private boolean isPrivate;


}
