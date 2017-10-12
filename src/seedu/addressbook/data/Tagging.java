package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {

    public final String person;
    public final String tag;
    public final String operator;

    public Tagging(Person person, Tag tag, String operator) {
        this.person = person.getName().toString();
        this.tag = tag.toString();
        this.operator = operator;
    }

    public String getPrintFormat() {
        String result = operator + " " + person + " " + "[" + tag + "]";
        return result;
    }
}
