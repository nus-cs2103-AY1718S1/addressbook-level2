package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {

    private Person person;
    private Tag tag;
    private String change;

    /**
     *
     * @param person whom @tag is added/deleted
     * @param tag that is associated with @person
     * @param change indicates whether the tag is added or delete. "+" indicates add and "-" otherwise.
     */
    public Tagging(Person person, Tag tag, String change) {
        this.person = person;
        this.tag = tag;
        this.change = change;
    }

    @Override
    public String toString() {
        return change + " " + person.getName().fullName + " [" + tag + "]";
    }
}
