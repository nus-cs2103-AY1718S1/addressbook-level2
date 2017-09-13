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
        Person sadamSandler = new Person(new Name("Sadam Sandler"), new Phone("92215550", false),
                new Email("sandlersadam@gmail.com", false),
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

        testAddressBook = TestUtil.createAddressBook(sadamSandler, zendayaMaree, brooksWackerman, claudioMarchisio);
        testPersonList = TestUtil.createList(sadamSandler, zendayaMaree, brooksWackerman, claudioMarchisio);
        sortedDisplayList = TestUtil.createList(brooksWackerman, claudioMarchisio, sadamSandler, zendayaMaree);
    }

    @Test
    public void assertCheckSortOrder() {
        SortCommand sortTest = new SortCommand();
        sortTest.setData(testAddressBook, testPersonList);
        CommandResult result = sortTest.execute();

        List<? extends ReadOnlyPerson> resultPersonList = result.getRelevantPersons().get();
        for(int index = 0; index < resultPersonList.size(); index++) {
            ReadOnlyPerson firstPerson = resultPersonList.get(index);
            ReadOnlyPerson secondPerson = sortedDisplayList.get(index);
            assertEquals(firstPerson.getName(), secondPerson.getName());
        }
    }
}