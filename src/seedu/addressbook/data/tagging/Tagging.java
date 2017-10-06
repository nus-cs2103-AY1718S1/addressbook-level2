package seedu.addressbook.data.tagging;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.person.Person;

public class Tagging {
    private final boolean add;
    private final Person person;
    private final Tag tag;

    /**
     * Create an association class between person and tagging
     * @param add specifies whether it's a add or remove tag operation
     * @param person is the person has the tag
     * @param tag is the tag to be added/removed
     */
    public Tagging(boolean add, Person person, Tag tag) {
        this.add = add;
        this.person = person;
        this.tag = tag;
    }

    /**
     * Return a string version, eg
     * + Jake Woo [friend]
     * - Jake Woo [colleague]
     * + Jean Wong [client]
     */
    public String toString() {
        String sign = this.add ? "+ " : "- ";
        return sign + this.person.getName().toString() +
                "[" + this.tag.tagName + "]";
    }

}
