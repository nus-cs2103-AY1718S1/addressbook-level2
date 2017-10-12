package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {

    public static final String MESSAGE_ADDITION = "+";
    public static final String MESSAGE_DELETION = "-";

    private ReadOnlyPerson person;
    private Tag tag;
    private boolean isTagAdded;

    public Tagging(ReadOnlyPerson person, Tag tag, boolean isTagAdded) {
        this.person = person;
        this.tag = tag;
        this.isTagAdded = isTagAdded;
    }

    public ReadOnlyPerson getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return (isTagAdded ? MESSAGE_ADDITION : MESSAGE_DELETION) + " " + person.getName() + " " + tag.tagName;
    }
}
