package seedu.addressbook.data.person;

public class Contact {

    public final String value;
    private boolean isPrivate;


    public Contact(String contact, boolean isPrivate){
        value = contact;
        this.isPrivate = isPrivate;
    }


    public static boolean isValid(String test, String regexCheck) {
        return test.matches(regexCheck);
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
