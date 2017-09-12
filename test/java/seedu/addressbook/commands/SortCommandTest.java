package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SortCommandTest  {
    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    private List<ReadOnlyPerson> expectedSortedList = new ArrayList<ReadOnlyPerson>();

    @Test
    public void execute() throws UniquePersonList.DuplicatePersonException {
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

        UniquePersonList actualSortedList = new UniquePersonList(td.amy, td.bill, td.candy, td.dan);
        actualSortedList.sort("name");
        assertSort(actualSortedList);




        //assert by phone
        expectedSortedList.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getPhone().toString().compareTo(o2.getPhone().toString());
            }
        });

        actualSortedList.sort("phone");
        assertSort(actualSortedList);

        //assert by email
        expectedSortedList.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getEmail().toString().compareTo(o2.getEmail().toString());
            }
        });

        actualSortedList.sort("email");
        assertSort(actualSortedList);

        //assert by address
        expectedSortedList.sort(new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getAddress().toString().compareTo(o2.getAddress().toString());
            }
        });

        actualSortedList.sort("address");
        assertSort(actualSortedList);

    }

    public void assertSort(UniquePersonList actualSortedList){

        assertEquals(expectedSortedList, actualSortedList.immutableListView());
    }



}