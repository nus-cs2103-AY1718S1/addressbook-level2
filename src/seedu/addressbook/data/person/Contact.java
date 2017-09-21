package seedu.addressbook.data.person;

public class Contact {
    public static String EXAMPLE;
    public static String MESSAGE_CONSTRAINTS;
    public static String VALIDATION_REGEX;

    public String value;
    public boolean isPrivate;

    /**
     * Returns true if the given string is a valid contact.
     */
    public static boolean isValid(String test) {
        return test.matches(VALIDATION_REGEX);
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
