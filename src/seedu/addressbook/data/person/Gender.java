package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's Gender in the address book.
 */

public class Gender {
    public static final String EXAMPLE = "Girl";
    public static final String MESSAGE_GENDER_CONSTRAINTS = "Gender should be in alphabets";
    public static final String GENDER_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String gender;

    /**
    * Validates given Gender.
    *
    *  @throws IllegalValueException if given gender string is invalid.
    */
    public Gender(String gender) throws IllegalValueException {
        String trimmedGender = gender.trim();
        if (!isValidGender(trimmedGender)) {
            throw new IllegalValueException(MESSAGE_GENDER_CONSTRAINTS);
        }
        this.gender = trimmedGender;
    }

    /**
     *  Returns true if the given string is a valid person gender.
     */
    public static boolean isValidGender(String test) {
        return test.matches(GENDER_VALIDATION_REGEX);
    }

    @Override
    public String toString(){
        return gender;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Gender // instanceof handles nulls
                && this.gender.equals(((Gender) other).gender)); // state check
    }

    @Override
    public int hashCode() {
        return gender.hashCode();
    }

}


