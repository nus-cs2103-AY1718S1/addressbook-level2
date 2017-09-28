package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SortCommandTest {
    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    private List<ReadOnlyPerson> expectedSortedList = new ArrayList<ReadOnlyPerson>();

    @Test
    public void execute(){
        expectedSortedList.add(td.amy);
        expectedSortedList.add(td.bill);
        expectedSortedList.add(td.candy);
        expectedSortedList.add(td.dan);

        //assert by name
        expectedSortedList.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getName().toString().compareTo(o2.getName().toString());
            }
        });

        assertSortCommand(SortCommand.PersonComparator.BY_NAME);

        //assert by phone
        expectedSortedList.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getPhone().toString().compareTo(o2.getPhone().toString());
            }
        });

        assertSortCommand(SortCommand.PersonComparator.BY_PHONE);

        //assert by email
        expectedSortedList.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getEmail().toString().compareTo(o2.getEmail().toString());
            }
        });

        assertSortCommand(SortCommand.PersonComparator.BY_EMAIL);

        //assert by address
        expectedSortedList.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getAddress().toString().compareTo(o2.getAddress().toString());
            }
        });

        assertSortCommand(SortCommand.PersonComparator.BY_ADDRESS);

    }

    public void assertSortCommand(SortCommand.PersonComparator sortType){
        SortCommand command = createSortCommand(sortType);

        assertEquals(expectedSortedList,command.getSortedList());
    }

    public SortCommand createSortCommand(SortCommand.PersonComparator sortType){
        SortCommand command = new SortCommand(sortType);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }


}