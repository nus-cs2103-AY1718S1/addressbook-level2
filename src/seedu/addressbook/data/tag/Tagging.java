package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {

    private ReadOnlyPerson person;
    private Tag tag;
    private boolean hasBeenAdded;

    public Tagging (ReadOnlyPerson person, Tag tag, boolean hasBeenAdded) {
        this.person = person;
        this.tag = tag;
        this.hasBeenAdded = hasBeenAdded;
    }

    public String displayTagging() {
        String sign;
        if (hasBeenAdded){
            sign = "+";
        } else {
            sign = "-";
        }
        return String.format("%s %s [%s]", sign, person.getName(), tag.tagName);
    }

}
