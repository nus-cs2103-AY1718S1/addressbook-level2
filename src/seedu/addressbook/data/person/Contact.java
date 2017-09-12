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

}
