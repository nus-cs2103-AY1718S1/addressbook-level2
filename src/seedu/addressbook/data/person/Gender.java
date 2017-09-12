package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;

public class Gender {
    public static final String EXAMPLE = "Male";
    public static final String MESSAGE_GENDER_CONSTRAINTS = "Person's gender should be either 'Male' or 'Female'" +
            " with the first letter capitalized";

    public final String value;

    public Gender(String gender) throws IllegalValueException{
        String trimmedGender = gender.trim();
        if (!isValidGender(trimmedGender)) {
            throw new IllegalValueException(MESSAGE_GENDER_CONSTRAINTS);
        }
        this.value = gender;
    }

    private boolean isValidGender(String test) {
        return test.equals("Male") || test.equals("Female");
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Gender // instanceof handles nulls
                && this.value.equals(((Gender) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
