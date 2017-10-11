package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {

    public enum TagOperations {
        ADD, REMOVE
    }

    private final Person person;
    private final Tag tag;
    private final TagOperations tagOps;

    public Tagging(Person person, Tag tag, TagOperations tagOps) {
        this.person = person;
        this.tag = tag;
        this.tagOps = tagOps;
    }

    public Person getPerson() {
        return this.person;
    }

    public Tag getTag(){
        return this.tag;
    }

    public TagOperations getTagOps() {
        return this.tagOps;
    }

}
