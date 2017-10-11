package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Represents a Tagging in the address book.
 */
public class Tagging {

    private Tag tag;
    private boolean isTagged;
    private ReadOnlyPerson person;

    public Tagging(ReadOnlyPerson person, Tag tag, boolean isTagged){
        this.person = person;
        this.tag = tag;
        this.isTagged = isTagged;
    }

    public String getTagSign(){
        if(isTagged==true) {
            return "+";
        }
        else {
            return "-";
        }
    }

    public String printTagging(){
        return getTagSign() + " " +person.getName() + " [" + tag.tagName + "]";
    }
}
