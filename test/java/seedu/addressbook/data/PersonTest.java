package seedu.addressbook.data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import static junit.framework.TestCase.assertEquals;

public class PersonTest {
    private Tag tagScientist;
    private Tag tagMathematician;

    private Person aliceBetsy;
    private Person bobChaplin;
    private Person charlieDouglas;

    private AddressBook emptyAddressBook;


    @Before
    public void setUp() throws Exception {
        Person.nextSequenceNumber = 1;

        tagScientist     = new Tag("scientist");
        tagMathematician = new Tag("mathematician");

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

        emptyAddressBook = new AddressBook();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void sequenceNumberTest() throws Exception {
        emptyAddressBook.addPerson(bobChaplin);
        emptyAddressBook.addPerson(charlieDouglas);

        assertEquals(2, charlieDouglas.getSequenceNumber());

        emptyAddressBook.removePerson(charlieDouglas);
        emptyAddressBook.addPerson(aliceBetsy);

        assertEquals(3, aliceBetsy.getSequenceNumber());

    }
}
