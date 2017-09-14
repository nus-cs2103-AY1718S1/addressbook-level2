package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static seedu.addressbook.commands.SortCommand.MESSAGE_SUCCESS;

public class SortCommandTest {

    private AddressBook unsortedAddressBook;
    private AddressBook sortedAddressBook;

    private Person aliceBetsy;
    private Person bobChaplin;
    private Person charlieDouglas;
    private Person davidElliot;

    private Tag tagPrizeWinner;
    private Tag tagScientist;
    private Tag tagMathematician;
    private Tag tagEconomist;

    private List<ReadOnlyPerson> allPersons;

    @Before
    public void setUp() throws Exception {
        tagPrizeWinner   = new Tag("prizewinner");
        tagScientist     = new Tag("scientist");
        tagMathematician = new Tag("mathematician");
        tagEconomist     = new Tag("economist");

        aliceBetsy     = new Person(new Name("Alice Betsy"),
                new Phone("91235468", false),
                new Email("alice@nushackers.org", false),
                new Address("8 Computing Drive, Singapore", false),
                new UniqueTagList(tagMathematician));

        bobChaplin     = new Person(new Name("Bob Chaplin"),
                new Phone("94321500", false),
                new Email("bob@nusgreyhats.org", false),
                new Address("9 Computing Drive", false),
                new UniqueTagList(tagMathematician));

        charlieDouglas = new Person(new Name("Charlie Douglas"),
                new Phone("98751365", false),
                new Email("charlie@nusgdg.org", false),
                new Address("10 Science Drive", false),
                new UniqueTagList(tagScientist));

        davidElliot    = new Person(new Name("David Elliot"),
                new Phone("84512575", false),
                new Email("douglas@nuscomputing.com", false),
                new Address("11 Arts Link", false),
                new UniqueTagList(tagEconomist, tagPrizeWinner));

        unsortedAddressBook = new AddressBook(new UniquePersonList(bobChaplin, aliceBetsy, davidElliot, charlieDouglas),
                new UniqueTagList(tagMathematician, tagScientist, tagEconomist, tagPrizeWinner));
        sortedAddressBook = new AddressBook(new UniquePersonList(aliceBetsy, bobChaplin, charlieDouglas, davidElliot),
                new UniqueTagList(tagMathematician, tagScientist, tagEconomist, tagPrizeWinner));
        allPersons = Arrays.asList(aliceBetsy, bobChaplin, charlieDouglas, davidElliot);
    }

    @Test
    public void checkUnsorted() throws Exception {
        assertNotEquals(unsortedAddressBook.getAllPersons(), sortedAddressBook.getAllPersons());
    }

    @Test
    public void sortTest() throws Exception {
        assertSortBehavior(new SortCommand(), sortedAddressBook, unsortedAddressBook, allPersons, MESSAGE_SUCCESS);
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that SortCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     * 2. The original addressbook data is not sorted after executing SortCommand.
     */
    private static void assertSortBehavior(Command sortCommand, AddressBook sortedAddressBook
            , AddressBook unsortedAddressBook, List<ReadOnlyPerson> relevantPersons, String expectedMessage) {
        AddressBook addressBookToSort = TestUtil.clone(unsortedAddressBook);

        sortCommand.setData(addressBookToSort, relevantPersons);
        CommandResult result = sortCommand.execute();

        // feedback message is as expected
        assertEquals(expectedMessage, result.feedbackToUser);

        // addressbook was sorted
        assertEquals(addressBookToSort.getAllPersons(), sortedAddressBook.getAllPersons());
    }

}