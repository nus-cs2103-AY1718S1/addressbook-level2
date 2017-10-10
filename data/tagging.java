package seedu.addressbook.data.tag;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.person.Person;

/**
 * Represents the addition or removal of a tag from a person
 */
public class Tagging {
    private Person person;
    private Tag tag;
    private boolean isAdded;

    public Tagging(Person person, Tag tag, boolean isAdded) {
        this.person = person;
        this.tag = tag;
        this.isAdded = isAdded;
    }

    private String getSign() {
        if (isAdded) return "+";
        else return "-";
    }

    @Override
    public String toString() {
        return this.getSign() + " " + this.person.getName() + " [" + this.tag.tagName + "]";
    }
}