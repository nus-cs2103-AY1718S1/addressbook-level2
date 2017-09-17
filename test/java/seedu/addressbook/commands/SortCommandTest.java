package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {
    @Test
     public void executeSortTest() {

                Person a = TestUtil.generateTestPerson();
                Person b = TestUtil.generateTestPerson();
                b.setName("Apple");
                Person c = TestUtil.generateTestPerson();
                c.setName("Strawberry");
                Person d = TestUtil.generateTestPerson();
                d.setName("Mango");
                Person e = TestUtil.generateTestPerson();
                e.setName("Cherry");

            UniquePersonList personList;

            try {
                personList = new UniquePersonList(a, b, c, d, e);
            } catch (UniquePersonList.DuplicatePersonException error) {
                return;
            }

            AddressBook book = new AddressBook(personList, new UniqueTagList());
            personList.sort();

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
                assertEquals(f.getName().toString(), "John Doe");
                assertEquals(g.getName().toString(), "Apple");
                assertEquals(h.getName().toString(), "Strawberry");
                assertEquals(i.getName().toString(), "Mango");
                assertEquals(j.getName().toString(), "Cherry");
            }
}
