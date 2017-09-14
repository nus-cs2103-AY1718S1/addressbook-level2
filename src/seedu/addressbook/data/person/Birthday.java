package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's birthday in the address book, in ddmm format.
 * Guarantees: immutable; is valid as declared in {@link #isValidBirthday(String)}
 */

public class Birthday extends Contact {
    public static final String EXAMPLE = "0101";
    public static final String MESSAGE_BIRTHDAY_CONSTRAINTS = "Person birthday should only contain numbers";
    public static final String BIRTHDAY_VALIDATION_REGEX = "\\d+";

    /**
     * Validates given birthday.
     *
     * @throws IllegalValueException if given birthday string is invalid.
     */
    public Birthday(String birthday, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedBirthday = birthday.trim();
        if (!isValidBirthday(trimmedBirthday)) {
            throw new IllegalValueException(MESSAGE_BIRTHDAY_CONSTRAINTS);
        }
        this.value = trimmedBirthday;
    }

    /**
     * Returns true if the given string is a valid person birthday.
     */
    public static boolean isValidBirthday(String test) {
        return test.matches(BIRTHDAY_VALIDATION_REGEX);
    }

}
