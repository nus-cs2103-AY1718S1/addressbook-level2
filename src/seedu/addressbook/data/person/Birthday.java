package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Birthday extends Contact {

    public static final String EXAMPLE = "30,12,1996";
    public static final String MESSAGE_BIRTHDAY_CONSTRAINTS = "Person Birthdays should be: DD,MM,YYYY";
    public static final String BIRTHDAY_VALIDATION_REGEX = "[0-3][0-9][,][0-1][0-9][,][0-2][0-9][0-9][0-9]";

    /**
     * Validates given birthday.
     *
     * @throws IllegalValueException if given birthday string is invalid.
     */
    public Birthday(String birthday, boolean isPrivate) throws IllegalValueException {
        super(birthday.trim(), isPrivate);
        String trimmedBirthday = value.trim();
        if (!isValidBirthday(trimmedBirthday)) {
            throw new IllegalValueException(MESSAGE_BIRTHDAY_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidBirthday(String test) {
        return test.matches(BIRTHDAY_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Birthday // instanceof handles nulls
                && this.value.equals(((Birthday) other).value)); // state check
    }
}
