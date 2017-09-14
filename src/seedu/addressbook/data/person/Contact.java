package seedu.addressbook.data.person;


/**
 * Represents a Person's contact information in the address book.
 * Deals with Address, Phone, Email.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {

    public String value;
    public boolean isPrivate;

    public void trimmer (String info, boolean isPrivate) {
        String trimmed = info.trim();
        this.isPrivate = isPrivate;
        this.value = trimmed;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }


}
