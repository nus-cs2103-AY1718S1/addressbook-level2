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

    public String getTaggingChange() {
        return isTagAdded ? "+" : "-";
    }

    public String printTagging() {
        return getTaggingChange() + this.person.getName() +  "[" + this.tag.tagName + "]";
    }
}
