package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Sorts all the persons in the address book by alphabetical order
 */

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address by alphabetical order by their name. \n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedList = sortName(addressBook.getAllPersons().immutableListView());
        return new CommandResult(getMessageForPersonSortedListShownSummary(sortedList), sortedList);
    }
    private List<ReadOnlyPerson> sortName(List<ReadOnlyPerson> testList) {
        NameComparator nameComparator = new NameComparator();
        List<ReadOnlyPerson> sortedContacts = new ArrayList<>();
        for (ReadOnlyPerson person: addressBook.getAllPersons()) {
            sortedContacts.add(person);
        }
        Collections.sort(sortedContacts, nameComparator);

        return sortedContacts;
    }
}
    class NameComparator implements Comparator<ReadOnlyPerson> {
        public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2) {
            return p1.getName().fullName.toUpperCase().compareTo(p2.getName().fullName.toUpperCase());
        }
    }
