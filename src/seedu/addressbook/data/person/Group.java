package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Group {

    public static final String EXAMPLE = "Family";
    public static final String MESSAGE_GROUP_CONSTRAINTS = "Group name should be a combination of alphabetic characters and digits";
    public static final String GROUP_VALIDATION_REGEX = "\\w+";

    private String group;
    private boolean isPrivate;

    /**
     * validates given group name.
     *
     * @throws IllegalValueException if given group name is invalid
     */
    public Group(String group_name, Boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedGroup = group_name.trim();
        if(!isValidGroup(trimmedGroup)){
            throw new IllegalValueException(MESSAGE_GROUP_CONSTRAINTS);
        }
        this.group = trimmedGroup;
    }

    private Boolean isValidGroup (String test) { return test.matches(GROUP_VALIDATION_REGEX); }

    @Override
    public String toString () { return group; }

    @Override
    public int hashCode() { return group.hashCode(); }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Group // instanceof handles nulls
                && this.group.equals(((Group) other).group)); // state check
    }
}
