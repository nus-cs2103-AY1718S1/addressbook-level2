package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.regex.Pattern;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link Contact#isValidContactField(String, Pattern)}
 */
public class Phone extends Contact {

    public static final String EXAMPLE = "123456789";
    public static final String MESSAGE_PHONE_CONSTRAINTS = "Person phone numbers should only contain numbers or follow "
                                                        + "the E164 phone number format prescribed by ITU.";
    public static final Pattern PHONE_VALIDATION_REGEX = Pattern.compile("^\\+?[1-9]\\d{1,14}$");

    /**
     * Constructs and validates the given phone number within the superclass, Contact
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Phone(String phone, boolean isPrivate) throws IllegalValueException {
        super(phone, isPrivate, PHONE_VALIDATION_REGEX, MESSAGE_PHONE_CONSTRAINTS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)); // state check
    }
}
