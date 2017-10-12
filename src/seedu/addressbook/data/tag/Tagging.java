package seedu.addressbook.data.tag;

/**
 * Represents an adding or a deleting of a tag
 */
public class Tagging {

    public final String tagName;
    public final String action;
    public final String person;

    public Tagging(String person, String action, String tagName) {
        this.person = person;
        this.action = action;
        this.tagName = tagName;
    }

    public String getAction() {
        return action;
    }

    public String getTagName() {
        return tagName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tagging // instanceof handles nulls
                && this.person.equals(((Tagging) other).person)
                && this.tagName.equals(((Tagging) other).tagName)
                && this.action.equals(((Tagging) other).action)); // state check
    }

    @Override
    public int hashCode() {
        return tagName.hashCode();
    }

    @Override
    public String toString() {
        return action + " " + person + " [" + tagName + "]";
    }
}
