package seedu.addressbook.data.person;

/**
 * This is the parent class for Phone, Email and Address, with all the commonalities being extracted.
 * The equals method can be reused, because even though the type check is a little loose, it is not
 * possible for an address String value to be mistaken for the String value for Phone or Email, due to
 * the requirements of each class in the first place. The same goes for Phone and Email.
 */

public class Contacts {
    public final String value;
    protected boolean isPrivate;

    public Contacts(String value, boolean isPrivate){
        this.value = value;
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Contacts
                && this.value.equals(((Contacts)other).value));
    }

    public boolean isPrivate(){
        return isPrivate;
    }
}
