package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents the addition or removal of a tag from a person
 */
public class Tagging {
    private final Person person;
    private final Tag tag;
    private final boolean isAdded;

    public Tagging(Person person, Tag tag, boolean isAdded) {
        this.person = person;
        this.tag = tag;
        this.isAdded = isAdded;
    }

    @Override
    public String toString() {
        String output = "";

        if(isAdded) String.join(output, "+ ");
        else String.join(output, "- ");

        String.join(output, person.getName().toString()," [", tag.tagName, "]\n");

        return output;
    }
}
