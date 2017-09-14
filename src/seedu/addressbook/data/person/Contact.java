package seedu.addressbook.data.person;

public class Contact implements Printable{

    public final String value;
    private boolean isPrivate;

    public Contact (String value, boolean isPrivate){
        this.value = value;
        this.isPrivate = isPrivate;
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

    @Override
    public String getPrintableString() {
        return this.getClass().toString()+": "+this.toString();
    }
}
