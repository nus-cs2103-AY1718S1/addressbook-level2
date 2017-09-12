package seedu.addressbook.data.person;

abstract class Contact {

    public String value;
    protected boolean isPrivate;
    protected String trimmedString;

    public Contact(String string, boolean isPrivate)  {
        trimmedString = string.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedString;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
