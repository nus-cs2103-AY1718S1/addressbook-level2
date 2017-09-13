package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {

    private AddressBook addressbook = TestUtil.createAddressBook();
    private static final UniqueTagList EMPTY_TAG_LIST = new UniqueTagList();
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();
    private static List<ReadOnlyPerson> personList = Collections.emptyList();
    Person p1;
    Person p2;
    Person p3;

    String[] names;

    @Before
    public void setUp() throws Exception {
        p1 = new Person (new Name("Emma"), new Phone("98765231", true), new Email("emma@gmail.com", true),
                new Address("Baker Street", true), EMPTY_TAG_LIST);

        p2 = new Person (new Name("Alice"), new Phone("87753428", true), new Email("alice@gmail.com", true),
                new Address("Baker Street", true), EMPTY_TAG_LIST);

        p3 = new Person (new Name("Bob"), new Phone("95533524", true), new Email("bob@gmail.com", true),
                new Address("Baker Street", true), EMPTY_TAG_LIST);

        names = new String[] {"Alice", "Bob", "Emma"};
    }

    @Test
    public void sortCommand_sortList() throws Exception {
        AddCommand commandp1 = new AddCommand(p1.getName().toString(), p1.getPhone().toString(), p1.getPhone().isPrivate(),
            p1.getEmail().toString(), p1.getEmail().isPrivate(), p1.getAddress().toString(), p1.getAddress().isPrivate(), EMPTY_STRING_LIST);

        AddCommand commandp2 = new AddCommand(p2.getName().toString(), p2.getPhone().toString(), p2.getPhone().isPrivate(),
                p2.getEmail().toString(), p2.getEmail().isPrivate(), p2.getAddress().toString(), p2.getAddress().isPrivate(), EMPTY_STRING_LIST);

        AddCommand commandp3 = new AddCommand(p3.getName().toString(), p3.getPhone().toString(), p3.getPhone().isPrivate(),
                p3.getEmail().toString(), p3.getEmail().isPrivate(), p3.getAddress().toString(), p3.getAddress().isPrivate(), EMPTY_STRING_LIST);

        commandp1.setData(addressbook, personList);
        CommandResult result1 = commandp1.execute();

        commandp2.setData(addressbook, personList);
        CommandResult result2 = commandp2.execute();

        commandp3.setData(addressbook, personList);
        CommandResult result3 = commandp3.execute();

        SortCommand sort = new SortCommand();
        sort.setData(addressbook, personList);
        CommandResult resultSort = sort.execute();

        UniquePersonList people = addressbook.getAllPersons();
        int index = 0;
        for (Person person : people) {
            assertEquals(person.getName().toString(), names[index]);
            index++;
        }

    }
}