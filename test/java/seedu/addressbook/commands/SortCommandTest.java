package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.*;

public class SortCommandTest {

    private AddressBook sortedAddressBook;
    private AddressBook jumbledBook;
    private AddressBook alreadySorted;

    @Before
    public void setUp() throws Exception {
        Person C = new Person(new Name("C"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person B = new Person(new Name("B"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person D = new Person(new Name("D"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person A = new Person(new Name("A"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        sortedAddressBook =  TestUtil.createAddressBook(A,B,C,D);
        jumbledBook = TestUtil.createAddressBook(C, B, D, A);
        alreadySorted = TestUtil.createAddressBook(A,B,C,D);
    }


    @Test
    public void testSort(){
        jumbledBook.sortBook();
        assertListSorted(jumbledBook);
        alreadySorted.sortBook();
        assertListSorted(alreadySorted);
    }

    public void assertListSorted(AddressBook toCompare){
        assertEquals(sortedAddressBook, toCompare );
    }
}