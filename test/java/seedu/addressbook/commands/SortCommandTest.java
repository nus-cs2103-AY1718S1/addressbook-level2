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
    private AddressBook emptyAddressBook;
    private AddressBook addressBookSort;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> displayList;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61231234", false),
                new Email("john@gmail.com", false), new Address("34A Alpha Road", false), new UniqueTagList());
        Person amyWhite = new Person(new Name("Amy White"), new Phone("81238123", false),
                new Email("amy@gmail.com", false), new Address("44E Beta Road", false), new UniqueTagList());
        Person berryChew = new Person(new Name("Berry Chew"), new Phone("96199444", false),
                new Email("berry@gmail.com", false), new Address("553 Charlie Road", false), new UniqueTagList());
        Person eddieTan = new Person(new Name("Eddie Tan"), new Phone("98394857", false),
                new Email("eddie@gmail.com", false), new Address("894 Delta Road", false), new UniqueTagList());


        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, amyWhite, berryChew, eddieTan);
        addressBookSort = TestUtil.createAddressBook(amyWhite, berryChew, eddieTan, johnDoe);

        emptyDisplayList = TestUtil.createList();
        displayList = TestUtil.createList(amyWhite, berryChew, eddieTan, johnDoe);
    }

    @Test
    public void execute_emptySort() throws Exception {
        // empty Addressbook
        assertSortWithEmptyAddressBook(emptyDisplayList);
    }

    @Test
    public void execute_sort() throws Exception{
        assertSortWithAddressBook(displayList);
    }

    private void assertSortWithEmptyAddressBook(List<ReadOnlyPerson> expectedList){
        SortCommand sortCmd = new SortCommand();
        sortCmd.setData(emptyAddressBook,null);
        assertSortBehavior(sortCmd, expectedList);
    }

    private void assertSortWithAddressBook(List<ReadOnlyPerson> expectedList){
        SortCommand sortCmd = new SortCommand();
        sortCmd.setData(addressBookSort, displayList);
        assertSortBehavior(sortCmd, expectedList);
    }

    private static void assertSortBehavior(Command sortCommand, List<ReadOnlyPerson> expectedList){
        CommandResult result = sortCommand.execute();
        assertEquals(expectedList, result.getRelevantPersons().get());
    }
}