package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {

    private Person person;
    private Tag tag;
    public enum Operation {
        Add, Remove
    }

    private Operation op;

    public Tagging(Person person, Tag tag, Operation op) {
        this.person = person;
        this.tag = tag;
        this.op = op;
    }

    public String showTagging() {
        String opString = (op == Operation.Add) ? "+" : "-";
        return String.format("%s %s [%s]", opString, person.getName().fullName, tag.tagName);
    }
}

