package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {

    private Tag tag;
    private ReadOnlyPerson person;
    private char operation;

    public static char ADD_TAG = '+';
    public static char REMOVE_TAG = '-';

    public Tagging(ReadOnlyPerson person, Tag tag, char operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }

    public Tag getTag() {
        return tag;
    }

    public ReadOnlyPerson getPerson() {
        return person;
    }

    public char getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return operation + " " + person.getName() + " " + tag.toString();
    }
}
