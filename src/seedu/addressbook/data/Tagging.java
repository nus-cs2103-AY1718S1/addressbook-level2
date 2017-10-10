package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * Represents the addition and deletion of a Tag for a Person.
 */
public class Tagging {

    private Person person;
    private Tag tag;
    private boolean isAdd;

    public Tagging(Person person, Tag tag, boolean isAdd) {
        this.person = person;
        this.tag = tag;
        this.isAdd = isAdd;
    }

    private String getSign(boolean isAdd) {
        if (isAdd) {
            return "+";
        } else {
            return "-";
        }
    }

    @Override
    public String toString() {
        return getSign(isAdd) + " " + person.getName() + " [" + tag.tagName + "]";
    }
}
