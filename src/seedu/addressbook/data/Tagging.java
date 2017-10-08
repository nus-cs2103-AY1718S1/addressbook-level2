package seedu.addressbook.data;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

/**
 * Represents association between data.person.Person and data.tag.Tag
 */
public class Tagging {

    private final Tag tag;
    private final ReadOnlyPerson person;
    private final boolean wasAdded;

    /**
     * Constructs a tagging with the given data.
     *
     * @param person is a person to whom tag is added/deleted
     * @param tag is the tag being added/deleted
     * @param wasAdded has value true if person is added and false if person is deleted
     */
    public Tagging(ReadOnlyPerson person, Tag tag, boolean wasAdded) {
        this.tag = tag;
        this.person = person;
        this.wasAdded = wasAdded;
    }

    /**
     * Returns true if tag was added and false if it was deleted
     */
    public boolean wasAdded() {
        return wasAdded;
    }

    public ReadOnlyPerson getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }
}
