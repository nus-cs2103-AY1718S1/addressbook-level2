package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;

import seedu.addressbook.util.TestUtil;

import java.util.List;

public class SortCommandTest {
    private AddressBook testAddressBook;
    private List<ReadOnlyPerson> personList;
    private List<ReadOnlyPerson> sortedPersonList;

    @Before
    public void createPersonList() throws Exception{
        Person estherPotato = new Person(new Name("Esther Potato"), new Phone("98273654", false),
                new Email("esther@not.a.real.potato", false),
                new Address("555, epsilon street, #01-123, 9876543", false), new UniqueTagList());
        Person dicksonEe = new Person(new Name("Dickson Ee"), new Phone("96574438", false),
                new Email("dickson@nus.edu.sg", true),
                new Address("444, delta street, #01-123, 9876543", false), new UniqueTagList());
        Person jamesWong = new Person(new Name("James Wong"), new Phone("91792549", false),
                new Email("jameswjl@gmail.com", false),
                new Address("468, admiralty drive, #06-127, 751468", false), new UniqueTagList());
        Person amyTan = new Person(new Name("Amy Tan"), new Phone("98837162", false),
                new Email("amytyh@hotmail.com", false),
                new Address("324, woodlands drive, #02-123, 730324", false), new UniqueTagList());
        Person juliaWong = new Person(new Name("Julia Wong"), new Phone("92474481", false),
                new Email("jw19sj@hotmail.com", false),
                new Address("234, marina ave, #28-23, 543234", false), new UniqueTagList());
        Person candiceLim = new Person(new Name("Candice Lim"), new Phone("98273611", false),
                new Email("candlim@hotmail.com", false),
                new Address("765, ang mo kio ave 6, #05-321, 634765", false), new UniqueTagList());

        testAddressBook = TestUtil.createAddressBook(estherPotato, dicksonEe, jamesWong, amyTan, juliaWong, candiceLim);
        personList = TestUtil.createList(estherPotato, dicksonEe, jamesWong, amyTan, juliaWong, candiceLim);
        sortedPersonList = TestUtil.createList(estherPotato, dicksonEe, jamesWong, amyTan, juliaWong, candiceLim);
    }

    @Test
    public void isSorted(){
        SortCommand testSort = new SortCommand();
        testSort.setData(testAddressBook, sortedPersonList);

        CommandResult results = testSort.execute();

        List<? extends ReadOnlyPerson> resultPersonList = results.getRelevantPersons().get();

        for(ReadOnlyPerson person:resultPersonList){
            assertEquals(personList.equals(person), sortedPersonList.equals(person));
        }
    }
}
