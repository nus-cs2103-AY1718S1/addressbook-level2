package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class SortCommandTest {
    private AddressBook addressBook;

    private AddressBook unsortedList;
    private AddressBook sortedList;

    @Before
    public void setUp() throws Exception {
        Person david = new Person(new Name("David"), new Phone("44544444", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person charlie = new Person(new Name("Charlie"), new Phone("44444444", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person alice = new Person(new Name("Alice"), new Phone("22222222", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person brendan = new Person(new Name("Brendan"), new Phone("33333333", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        addressBook = TestUtil.createAddressBook(david, charlie, alice, brendan);
        unsortedList = TestUtil.createAddressBook(david, charlie, alice, brendan);
        sortedList = TestUtil.createAddressBook(alice, brendan, charlie, david);
    }
    
    @Test
    public void assertCheckSort(){
        unsortedList.sort();
        assertListSorted(unsortedList);
        sortedList.sort();
        assertListSorted(sortedList);
        }
    
    public void assertListSorted(AddressBook toCompare){
        assertEquals(sortedList, toCompare);
    }
}
