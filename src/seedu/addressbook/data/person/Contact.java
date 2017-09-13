package seedu.addressbook.data.person;

public class Contact {

    private boolean isPrivate;
    public final String value;

    public Contact(String value, boolean isPrivate) {
        this.isPrivate = isPrivate;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
