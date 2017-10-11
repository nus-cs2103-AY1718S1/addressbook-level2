package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * An association class between data.Tag and data.Person
 */
public class Tagging {

    private Person person;
    private final Tag tag;
    private final boolean isTagAdded;

    public Tagging(Person person, Tag tag, boolean isTagAdded) {
        this.person = person;
        this.tag = tag;
        this.isTagAdded = isTagAdded;
    }


    @Override
    public String toString() {
        return returnTagOperation() + " " + this.person.getName() + " [" + this.tag.tagName + "] ";
    }

    private String returnTagOperation() {
        if (this.isTagAdded) {
            return "+";
        } else {
            return "-";
        }
    }

}
