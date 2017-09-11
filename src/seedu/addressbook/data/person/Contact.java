package seedu.addressbook.data.person;

public class Contact {

    public String value;

    public Contact() {
        
    }
    public String toString() {
        return value;
    }
    public int hashCode() {
        return value.hashCode();
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)) || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)) || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }
}