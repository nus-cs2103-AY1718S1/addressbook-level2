package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {


    public static final String MESSAGE_ADDICTION = "+";
    public static final String MESSAGE_DELETION = "-";


    private ReadOnlyPerson person;
    private Tag tag;
    private boolean tagAdded;

    public Tagging(ReadOnlyPerson person, Tag tag, boolean tagAdded) { 
        this.person = person;
        this.tag = tag;
        this.tagAdded = tagAdded;
    }

    public ReadOnlyPerson getPerson() { 
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public String printTag() {
        return (tagAdded ? MESSAGE_ADDICTION : MESSAGE_DELETION) + this.person.getName() 
                + " [" + this.tag.tagName + "] ";
    }
    
}