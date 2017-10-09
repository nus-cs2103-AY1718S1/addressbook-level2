package seedu.addressbook.data.tag;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {
    private ReadOnlyPerson person;
    private Tag tag;
    private TagActionType action;

    public Tagging (ReadOnlyPerson person, Tag tag, TagActionType action){
        this.person = person;
        this.tag = tag;
        this.action = action;
    }

    public void setPerson(ReadOnlyPerson person) {

        this.person = person;
    }

    public void setTag(Tag tag) {

        this.tag = tag;
    }

    public Tag getTag() {

        return tag;
    }

    public Name getName() {

        return person.getName();
    }

    @Override
    public String toString() {
        if (action == TagActionType.ADD) {
            return Messages.MESSAGE_ADD + person.getName() + tag.toString();
            
        } else if (action == TagActionType.DELETE) {
            return Messages.MESSAGE_DELETE + person.getName() + tag.toString();
            
        } else {
            return "";
        }
    }
}
