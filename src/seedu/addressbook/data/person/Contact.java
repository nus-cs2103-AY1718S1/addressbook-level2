package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact details in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {
    
    public static final String EXAMPLE = "a/123, Clementi Ave, #10, 122001 e/abc@gmail.com p/098765432";
    public static final String MESSAGE_CONTACT_CONSTRAINTS = "Contact details can contain anything.";
    public static final String CONTACT_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    
    /**
     * Validates a given Address
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if the given string is a valid person contact details.
     */
    public boolean isValidContact(String test) { return test.matches(CONTACT_VALIDATION_REGEX); }

    /**
     * Checks if the contact details of two people in address book are same
     * @param other contact
     * @return true if contact details of two people are same
     */
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    
    /**
     * 
     * @return contact as a String
     */
    public String toString() {
        return value;
    }

    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
    
}
