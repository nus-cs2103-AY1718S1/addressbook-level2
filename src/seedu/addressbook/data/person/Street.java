package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {
    public static final String EXAMPLE = "some street";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Street could be in any format";
    public static final String STREET_VALIDATION_REGEX = ".+";

    private final String value;

    public Street (String street) throws IllegalValueException {
        String trimmedStreet = street.trim();
        if(!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = trimmedStreet;
    }

    private static boolean isValidStreet (String test) { return test.matches(STREET_VALIDATION_REGEX); }

    @Override
    public String toString () { return value; }
}
