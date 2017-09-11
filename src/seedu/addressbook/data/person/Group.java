package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's group in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidGroup(String)}
 */
public class Group {

    public static final String MESSAGE_GROUP_CONSTRAINTS = "Person's group should be spaces or alphabetic characters";
    public final String groupName;
    private static final String WORK = "work";
    private static final String FAMILY = "family";
    private static final String FRIENDS = "friends";

    /**
     * Validates given group.
     *
     * @throws IllegalValueException if given group string is invalid.
     */
    public Group(String group) throws IllegalValueException {
        String trimmedGroupName = group.trim();
        if (!isValidGroup(trimmedGroupName)) {
            throw new IllegalValueException(MESSAGE_GROUP_CONSTRAINTS);
        }
        this.groupName = trimmedGroupName;
    }

    /**
     * Returns true if the given string is a valid group name.
     */
    public static boolean isValidGroup(String test) { return (test.equalsIgnoreCase(WORK) ||
            test.equalsIgnoreCase(FAMILY) || test.equalsIgnoreCase(FRIENDS)); }

    @Override
    public String toString() {
        return groupName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Group // instanceof handles nulls
                && this.groupName.equals(((Group) other).groupName)); // state check
    }

    @Override
    public int hashCode() {
        return groupName.hashCode();
    }

}