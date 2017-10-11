package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {

    private ReadOnlyPerson person;
    private Tag tag;
    private char operation;

    public Tagging(ReadOnlyPerson person, Tag tag, char operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return operation + " " +  person.getName() + " " + tag.toString();
    }
}
