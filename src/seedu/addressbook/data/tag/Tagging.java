package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents Tags that are changed during AddressBook operations.
 */
public class Tagging {
    private Person person;
    private Tag tag;
    private String op;

    public Tagging(Person person, Tag tag, String op) {
        this.person = person;
        this.tag = tag;
        this.op = op;
    }

    public String getTaggingsChanged() {
        return op + " " + person.getName() + " [" + tag.tagName + "]";
    }

}
