package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {

    private Person person;
    private Tag tag;
    private boolean hasBeenAdded;

    public Tagging (Person person, Tag tag, boolean hasBeenAdded) {
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
