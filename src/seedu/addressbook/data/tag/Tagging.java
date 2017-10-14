package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Name;


public class Tagging {

    Name name;
    ArrayList<Tag> tags;
    String addOrRemove;

    public Tagging(Name target, String addOrRemove) {
        this.name = target;
        this.addOrRemove = addOrRemove;
        tags = new ArrayList<Tag>();
    }

    public void addTagToList(Tag toAdd) {
        this.tags.add(toAdd);
    }


    public String toString() {
        String result = "";
        if (!tags.isEmpty()) {
            for (Tag tag : tags) {
                result += addOrRemove + " " + name + " " + tag + "\n";
            }
        }
        return result;
    }
}
