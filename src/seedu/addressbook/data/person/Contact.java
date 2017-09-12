package seedu.addressbook.data.person;

public class Contact {
    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate){
        this.value = value;
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString(){
            return value;
    }
    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Contact && this.value.equals(((Contact) other).value));
    }
    @Override
    public int hashCode(){
        return value.hashCode();
    }
    public boolean isPrivate(){
        return isPrivate;
    }
}

