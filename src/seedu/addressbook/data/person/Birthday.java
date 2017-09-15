package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Birthday {
    public static final String EXAMPLE = "1979-01-01";
    public static final String MESSAGE_BIRTHDAY_CONSTRAINTS =
            "Person birthday should be in the yyyy-MM-dd format";
    //public static final String BIRTHDAY_VALIDATION_REGEX = "\\d+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given birthday dates.
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
     * Returns true if the given string is a valid birthday format.
     */
    public static boolean isValidBirthday(String test) {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(test.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
        //return test.matches(BIRTHDAY_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Birthday // instanceof handles nulls
                && this.value.equals(((Birthday) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
