package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
    public static final String EXAMPLE = "123456";
    public static final String MESSAGE_POSTALCODE_CONSTRAINTS = "postal code should only contain one 6-digit number";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d{6}";

    private final String value;

    public PostalCode (String PostalCode) throws IllegalValueException {
        String trimmedPostalCode = PostalCode.trim();
        if(!isValidPostalCode(trimmedPostalCode)){
            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    private static boolean isValidPostalCode (String test) { return test.matches(POSTALCODE_VALIDATION_REGEX); }

    @Override
    public String toString () { return value; }
}
