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
    private AddressBook addressBook;
    private List<ReadOnlyPerson> listAll;

    @Before
    public void setUp() throws Exception {
        Person Bobby = new Person(new Name("Bobby Tang"), new Phone("111111", false),
                new Email("bobby@gmail.com", false), new Address("111, bishan", false), new UniqueTagList());
        Person Avas = new Person(new Name("Avas Pang"), new Phone("666666", false),
                new Email("avas@gmail.com", false), new Address("666, ang mo kio", false), new UniqueTagList());
        addressBook = TestUtil.createAddressBook(Bobby, Avas);
        listAll = TestUtil.createList(Bobby, Avas);

    }

    @Test
    public void sort()  {
        SortCommand sc = new SortCommand();
        sc.setData(addressBook, listAll);
        sc.execute();

        List allList = addressBook.getAllPersons().immutableListView();

        for(int i=0; i<allList.size() -1; i++) {
            assertTrue(((Person)allList.get(i)).getName().toString().toLowerCase().compareTo(((Person)allList.get(i)).getName().toString().toLowerCase()) <= 0);
        }
    }
    }
