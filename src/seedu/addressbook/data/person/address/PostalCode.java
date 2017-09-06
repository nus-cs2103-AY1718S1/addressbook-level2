package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
    public static final String EXAMPLE = "123456";
    public static final String MESSAGE_POSTAL_CONSTRAINTS = "Postal code should be in 6-digit format.";
    public static final String POSTAL_VALIDATION_REGEX = "\\d{6}+";
    public final String value;
  
    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
    
    public PostalCode(String postalCode) throws IllegalValueException{

        if (!isValidPostal(postalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CONSTRAINTS);
        }

        this.value = postalCode;
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    public static boolean isValidPostal(String test) {
        return test.matches(POSTAL_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }


    public String getPostalCode() {
        return this.value;
    }

}
