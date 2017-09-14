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
        Person john = new Person(new Name("John"), new Phone("40440688", false),
                new Email("john@johnny.com", false), new Address("111 Hill Road", false), new UniqueTagList());
        Person jacob = new Person(new Name("jacob"), new Phone("79105057", false),
                new Email("jacob@bocaj.net", false), new Address("532 Field Road", false), new UniqueTagList());
        Person mary = new Person(new Name("Mary"), new Phone("60812742", false),
                new Email("mary@littleLamb.org", false), new Address("84A Farm Road", false), new UniqueTagList());

        addressBook = TestUtil.createAddressBook(john, jacob, mary);
        listAll = TestUtil.createList(john, jacob, mary);
    }

    @Test
    public void sortByName() {
        SortCommand sC = new SortCommand("name");
        sC.setData(addressBook, listAll);
        sC.execute();

        List allLIst = addressBook.getAllPersons().immutableListView();

        for(int i = 0; i < allLIst.size() - 1; i++) {
            assertTrue(((Person)allLIst.get(i)).getName().toString().toLowerCase()
                    .compareTo(((Person)allLIst.get(i)).getName().toString().toLowerCase()) <= 0);
        }
    }

    @Test
    public void sortByPhone() {
        SortCommand sC = new SortCommand("phone");
        sC.setData(addressBook, listAll);
        sC.execute();

        List allLIst = addressBook.getAllPersons().immutableListView();

        for(int i = 0; i < allLIst.size() - 1; i++) {
            assertTrue(((Person)allLIst.get(i)).getPhone().toString().toLowerCase()
                    .compareTo(((Person)allLIst.get(i)).getPhone().toString().toLowerCase()) <= 0);
        }
    }

    @Test
    public void sortByEmail() {
        SortCommand sC = new SortCommand("email");
        sC.setData(addressBook, listAll);
        sC.execute();

        List allLIst = addressBook.getAllPersons().immutableListView();

        for(int i = 0; i < allLIst.size() - 1; i++) {
            assertTrue(((Person)allLIst.get(i)).getEmail().toString().toLowerCase()
                    .compareTo(((Person)allLIst.get(i)).getEmail().toString().toLowerCase()) <= 0);
        }
    }

    @Test
    public void sortByAddress() {
        SortCommand sC = new SortCommand("address");
        sC.setData(addressBook,listAll);
        sC.execute();

        List allLIst = addressBook.getAllPersons().immutableListView();

        for(int i = 0; i < allLIst.size() - 1; i++) {
            assertTrue(((Person)allLIst.get(i)).getAddress().toString().toLowerCase()
                    .compareTo(((Person)allLIst.get(i)).getAddress().toString().toLowerCase()) <= 0);
        }
    }
}