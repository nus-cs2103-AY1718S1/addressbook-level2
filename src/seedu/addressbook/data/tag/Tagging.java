package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represent Tags that are changed during operations
 */
public class Tagging {
    private Person person;
    private Tag tag;
    private String operation;

    public Tagging(Person person, Tag tag, String operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }

    public String getInfo() {
        return operation + " " + person.getName().fullName + " [" + tag.tagName + "]";
    }


}
