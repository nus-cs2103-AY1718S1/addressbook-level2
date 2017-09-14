package seedu.addressbook.data.person;

import java.util.Comparator;

/**
 * Compare the names of 2 persons alphabetically
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().toString().compareToIgnoreCase(o2.getName().toString());
    }

}
