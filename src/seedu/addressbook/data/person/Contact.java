package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact details in the addressbook, which includes phone, email, and address
 * 
 */
public class Contact {
    //regex and error message to be supplied by subclasses
    public final String VALIDATION_REGEX;
    public final String MESSAGE_CONSTRAINTS;
    
    public final String value;
    private boolean isPrivate;
   

    /**
     * Validates given contactDetails
     * 
     * @throws IllegalValueException if given contact details does not match given validation regex
     */
    public Contact(String contactDetails, boolean isPrivate, String regex, String constraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = contactDetails.trim();
        this.VALIDATION_REGEX = regex;
        this.MESSAGE_CONSTRAINTS = constraints;
        if(!isValidData(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if the given string is a valid contact detail.
     */
    public boolean isValidData(String test) {
        return test.matches(VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return value; 
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
