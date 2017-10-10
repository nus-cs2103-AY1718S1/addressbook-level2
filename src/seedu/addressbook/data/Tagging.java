package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {

    private Person person;
    private Tag tag;
    private Boolean wasAdded;


    public Tagging(Person associatedPerson, Tag associatedTag, Boolean addedTag) {
        this.person = associatedPerson;
        this.tag = associatedTag;
        this.wasAdded = addedTag;
    }

    private String getSign() {
        if (wasAdded) {
            return "+";
        } else {
            return "-";
        }
    }

    @Override
    public String toString() {
        return this.getSign() + " " + this.person.getName() + " [" + this.tag.tagName + "]";
    }
}
