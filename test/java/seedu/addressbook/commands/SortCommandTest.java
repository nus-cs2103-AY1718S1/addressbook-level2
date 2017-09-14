package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import static org.junit.Assert.*;

public class SortCommandTest {

    private Person aliceBetsy;
    private Person bobChaplin;
    private Person charlieDouglas;
    private Person davidElliot;

    private AddressBook defaultAddressBook;
    private AddressBook emptyAddressBook;

    @Before
    public void setUp() throws Exception {

        aliceBetsy     = new Person(new Name("Alice Betsy"),
                new Phone("91235468", false),
                new Email("alice@nushackers.org", false),
                new Address("8 Computing Drive, Singapore", false);

        bobChaplin     = new Person(new Name("Bob Chaplin"),
                new Phone("94321500", false),
                new Email("bob@nusgreyhats.org", false),
                new Address("9 Computing Drive", false);

        charlieDouglas = new Person(new Name("Charlie Douglas"),
                new Phone("98751365", false),
                new Email("charlie@nusgdg.org", false),
                new Address("10 Science Drive", false);

        davidElliot    = new Person(new Name("David Elliot"),
                new Phone("84512575", false),
                new Email("douglas@nuscomputing.com", false),
                new Address("11 Arts Link", false);

        emptyAddressBook = new AddressBook();
        defaultAddressBook = new AddressBook(new UniquePersonList(aliceBetsy, bobChaplin),
    }

    @Test
    public void execute() throws Exception {
        emptyAddressBook.addPerson(charlieDouglas);
        emptyAddressBook.addPerson(bobChaplin);

    }

}