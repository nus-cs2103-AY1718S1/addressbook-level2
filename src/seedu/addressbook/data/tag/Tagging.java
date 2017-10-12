package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {
    private ReadOnlyPerson person;
    private Tag tag;
    private boolean isTagAdded;

    public Tagging(ReadOnlyPerson person, Tag tag, boolean isTagAdded) {
        this.person = person;
        this.tag = tag;
        this.isTagAdded = isTagAdded;
    }

    public Tag getTag() {
        return tag;
    }

    private String getTagSign() {
        return isTagAdded ? "+" : "-";
    }

    @Override
    public String toString() {
        return getTagSign() + " " + person.getName() + " " + tag;
    }
}
