package seedu.addressbook.data.person;


/**
 * Contains contact information of Person.
 */
public class Contact {

    public String value;
    private boolean isPrivate;

    public Contact(String contact, boolean isPrivate) {
        this.isPrivate = isPrivate;
        value = contact;
    }

    /**
     * Returns true if the given string is a valid form or phone/email/address.
     */
    public static boolean isValid(String test, String regex) {
       return test.matches(regex);
    }

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
