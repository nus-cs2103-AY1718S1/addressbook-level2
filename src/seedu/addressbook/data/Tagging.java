package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
    public final String tag;
    public final String person;
    public final String op;

    public Tagging (Person person, Tag tag, String op){
        this.person = person.getName().toString();
        this.tag = tag.toString();
        this.op = op;
    }

    public String getTagsChanged(){
        return op + " " + person + " [" + tag + "]";
    }
}
