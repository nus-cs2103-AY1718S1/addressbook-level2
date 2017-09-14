package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import static org.junit.Assert.assertEquals;

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
        sortedAddressBook = new AddressBook(new UniquePersonList(bobChaplin, aliceBetsy, davidElliot, charlieDouglas),
                new UniqueTagList(tagMathematician, tagScientist, tagEconomist, tagPrizeWinner));

    }

    @Test
    public void sortTest() throws Exception {
        new SortCommand();
        assertEquals(unsortedAddressBook, sortedAddressBook);
    }

}