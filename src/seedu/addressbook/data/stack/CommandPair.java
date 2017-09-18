package seedu.addressbook.data.stack;

import seedu.addressbook.data.person.Person;

public class CommandPair {
    private Person person;
    private int isAdd;

    public CommandPair(Person person, int isAdd) {
        this.person = person;
        this.isAdd = isAdd;
    }

    public Person getPerson() {
        return person;
    }

    public int isAdd() {
        return isAdd;
    }
}