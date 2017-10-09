package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Keeps a record for each transaction related to tags, like adding/removing a tag from a specific
 * person, removing a specific tag from all persons who have that tag. Notice that a list of objects
 * instantiated by this class will be kept in {@link seedu.addressbook.data.AddressBook} class.
 */
public class Tagging {
    public enum TaggingOperations {
        ADD, REMOVE
    }

    private final Person person;
    private final Tag tag;
    private final TaggingOperations operation;

    public Tagging(Person person, Tag tag, TaggingOperations operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public TaggingOperations getOperation() {
        return operation;
    }
}
