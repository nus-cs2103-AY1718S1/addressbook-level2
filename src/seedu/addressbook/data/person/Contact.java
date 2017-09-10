package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Created by Philemon1 on 11/9/2017.
 */
public class Contact {

    public final String value;
    private boolean isPrivate;
    public static  String example;
    public static  String constraintsMessage;
    public static  String validationRegex;

    public Contact(String value, boolean isPrivate, String example, String constraints, String validationRegex) throws IllegalValueException {
        this.validationRegex = validationRegex;
        this.constraintsMessage = constraints;
        this.isPrivate = isPrivate;
        this.example = example;

        String trimmedValue = value.trim();
        if (!isValidValue(trimmedValue)) {
            throw new IllegalValueException(constraintsMessage);
        }

        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public static boolean isValidValue(String test) {
        return test.matches(validationRegex);
    }


}
