package seedu.addressbook.data.tag;

import seedu.addressbook.data.exception.InvalidOperationException;
import java.lang.NullPointerException;
import seedu.addressbook.data.person.Person;

public class Tagging {
    public static Character ADD_TAG = '+';
    public static Character REMOVE_TAG = '-';
    private Character action;
    private Person person;
    private Tag uniqueTag;

    public Tagging(Person inputPerson, Tag inputUniqueTag, Character inputAction) throws NullPointerException
            , InvalidOperationException {
        if(inputPerson == null) {
            throw new NullPointerException("Tagging constructor - Null Person input");
        }
        if(uniqueTag == null) {
            throw new NullPointerException("Tagging constructor - Null Tag input");
        }
        if(!inputAction.equals(ADD_TAG) && !inputAction.equals(REMOVE_TAG)) {
            throw new InvalidOperationException("Tagging constructor - Unrecognized action");
        }
        action = inputAction;
        person = inputPerson;
        uniqueTag = inputUniqueTag;
    }

    public Person getPerson(){
        return person;
    }

    public Character getAction() {
        return action;
    }

    public Tag getUniqueTag() {
        return uniqueTag;
    }

    @Override
    public String toString() {
        return action + " " + person.getName() + " " + "[" + uniqueTag.tagName + "]";
    }
}
