package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public final String value;
    private boolean isPrivate;


    public Contact(String trimmedContact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        trimmedContact = trimmedContact.trim();
        this.value = trimmedContact;
    }

//    @Override
//    public boolean equals(Object other) {
//        return other == this // short circuit if same object
//                || (other instanceof Email // instanceof handles nulls
//                && this.value.equals(((Email) other).value)); // state check
//    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }

}
