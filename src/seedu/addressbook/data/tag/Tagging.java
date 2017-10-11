package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Stores the various changes to a person's tag (i.e. adding/deleting of a tag on a person)
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

    @Override
    public String toString() {
        return operation + " " + person.getName().fullName + " " + tag.toString();
    }
}
