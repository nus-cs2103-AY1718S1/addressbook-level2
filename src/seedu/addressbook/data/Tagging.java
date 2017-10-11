package seedu.addressbook.data;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
    ReadOnlyPerson person;
    Tag tag;
    Boolean isAdded;

    Tagging(ReadOnlyPerson person, Tag tag, boolean isAdded) {
        this.person = person;
        this.tag = tag;
        this.isAdded = isAdded;
    }

    public String toPrint() {
        return getAddOrRemoveSign() + this.person.getName().toString() + " [" + this.tag.tagName.toString() + "]";
    }

    public String getAddOrRemoveSign() {
        return this.isAdded ? "+ " : "- ";
    }
}
