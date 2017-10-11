package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;

public class Tagging {

    private Person personTagged;
    private Tag tagTagged;
    private boolean isTagAdded;

    public Tagging(Person person, Tag tag, boolean isItAdded) {
        personTagged = person;
        tagTagged = tag;
        isTagAdded = isItAdded;
    }

    public String printResult() {
        return taggingSign() + this.personTagged + " [" + this.tagTagged + "] ";
    }

    public String taggingSign() {
        return isTagAdded ? "+" : "-";
    }

}
