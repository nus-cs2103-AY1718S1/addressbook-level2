package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;



public class SortCommandTest {
    /**
     * This test adds random names in an unsorted order, calls the sort function, then iterates through the list to
     * test if the list has indeed been correctly sorted.
     */

    @Test
    public void sortCommand_correctlySortsList() {

        Person a = TestUtil.generateTestPerson();
        Person b = TestUtil.generateTestPerson();
        b.setName("Aohn Doe");
        Person c = TestUtil.generateTestPerson();
        c.setName("Lohn Doe");
        Person d = TestUtil.generateTestPerson();
        d.setName("Bohn Doe");
        Person e = TestUtil.generateTestPerson();
        e.setName("Fohn Doe");

        UniquePersonList personList;

        try {
            personList = new UniquePersonList(a, b, c, d, e);
        } catch (UniquePersonList.DuplicatePersonException error) {
            return;
        }

        AddressBook book = new AddressBook(personList, new UniqueTagList());
        book.sort();

        Iterator peopleIterator = book.getAllPersons().iterator();

        Person f = null;
        Person g = null;
        Person h = null;
        Person i = null;
        Person j = null;

        if(peopleIterator.hasNext()) {
            f = (Person) peopleIterator.next();
        }
        if(peopleIterator.hasNext()) {
            g = (Person) peopleIterator.next();
        }
        if(peopleIterator.hasNext()) {
            h = (Person) peopleIterator.next();
        }
        if(peopleIterator.hasNext()) {
            i = (Person) peopleIterator.next();
        }
        if(peopleIterator.hasNext()) {
            j = (Person) peopleIterator.next();
        }
        assertEquals(f.getName().toString(), "Aohn Doe");
        assertEquals(g.getName().toString(), "Bohn Doe");
        assertEquals(h.getName().toString(), "Fohn Doe");
        assertEquals(i.getName().toString(), "John Doe");
        assertEquals(j.getName().toString(), "Lohn Doe");
    }
}
