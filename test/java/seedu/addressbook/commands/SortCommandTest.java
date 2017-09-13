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
    private AddressBook testAddressBook;

    private List<ReadOnlyPerson> testPersonList;
    private List<ReadOnlyPerson> sortedDisplayList;

    @Before
    public void instantiate() throws Exception{
        Person SadamSandler = new Person(new Name("Sadam Sandler"), new Phone("92215550", false),
                new Email("sandleradam@gmail.com", false),
                new Address("Hollywood", false),new UniqueTagList());

        Person zendayaMaree = new Person(new Name("Zendaya Maree"), new Phone("92218880", false),
                new Email("zendaya@gmail.com", false),
                new Address("Oakland", false), new UniqueTagList());

        Person brooksWackerman= new Person(new Name("Brooks Wackerman"), new Phone("92217770", false),
                new Email("a7xbrooks@gmail.com", false),
                new Address("Huntington", false), new UniqueTagList());

        Person claudioMarchisio = new Person(new Name("Claudio Marchisio"), new Phone("92219990", false),
                new Email("juventusmarchisio@gmail.com", false),
                new Address("Naples", false), new UniqueTagList());

        testAddressBook = TestUtil.createAddressBook(SadamSandler, zendayaMaree, brooksWackerman, claudioMarchisio);
        testPersonList = TestUtil.createList(SadamSandler, zendayaMaree, brooksWackerman, claudioMarchisio);
        sortedDisplayList = TestUtil.createList(brooksWackerman, claudioMarchisio, SadamSandler, zendayaMaree);
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
}