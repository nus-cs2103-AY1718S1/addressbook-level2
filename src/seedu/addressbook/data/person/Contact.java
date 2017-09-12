package seedu.addressbook.data.person;

public class Contact {

    public final String value;
    private boolean isPrivate;

    public Contact(String newValue,boolean privateStatus){
        this.value=newValue;
        this.isPrivate=privateStatus;
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
