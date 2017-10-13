package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {

    private Person person;
    private Tag tag;
    private String operation;

    public Tagging(Person person, Tag tag, String operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public String getOperation() {
        return operation;
    }

}
