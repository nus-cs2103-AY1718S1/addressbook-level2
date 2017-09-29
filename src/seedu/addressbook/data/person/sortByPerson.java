package seedu.addressbook.data.person;

import java.util.*;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.DuplicateDataException;

class sortByPerson implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        String o1Name = o1.getName().toString();
        String o2Name = o2.getName().toString();

        if (o1Name.compareTo(o2Name) < 0) {
            return -1;
        }
        else if (o1Name.compareTo(o2Name) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
