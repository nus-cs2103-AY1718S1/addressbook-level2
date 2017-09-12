package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {
    private AddressBook testAddressBook;

    private List<ReadOnlyPerson> testPersonList;
    private List<ReadOnlyPerson> sortedDisplayList;
    
    @Before
    public void initialise() throws Exception{
        Person johnDoe = new Person(new Name("John Doe"), new Phone("91234567", false),
                new Email("johnd@gmail.com", false), new Address("Okhlm Road 123", false), new UniqueTagList());
        Person maryJane = new Person(new Name("Mary Jane"), new Phone("98442351", false),
                new Email("maryj@gmail.com", false), new Address("21 Kolon Drive", false), new UniqueTagList());
        Person blane = new Person(new Name("Blane"), new Phone("87663712", false),
                new Email("blane@gmail.com", false), new Address("Cinnabar Island 3", false), new UniqueTagList());
        Person garyOak = new Person(new Name("Gary Oak"), new Phone("85663813", false),
                new Email("garyO@gmail.com", false), new Address("21 Pallet Town", false), new UniqueTagList());
        
        testAddressBook = TestUtil.createAddressBook(johnDoe, maryJane, blane, garyOak);
        testPersonList = TestUtil.createList(johnDoe, maryJane, blane, garyOak);
        sortedDisplayList = TestUtil.createList(blane, garyOak, johnDoe, maryJane);
    }
    
    @Test
    public void assertCheckSortOrder() {
        SortCommand testSort = new SortCommand();
        testSort.setData(testAddressBook, testPersonList);
        CommandResult result = testSort.execute();

        List<? extends ReadOnlyPerson> resultPersonList = result.getRelevantPersons().get();
        for(int i = 0; i < resultPersonList.size(); i++) {
            ReadOnlyPerson person1 = resultPersonList.get(i);
            ReadOnlyPerson person2 = sortedDisplayList.get(i);
            assertEquals(person1.getName(), person2.getName());
        }
    }
}
