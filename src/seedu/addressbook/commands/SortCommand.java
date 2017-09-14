package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Lists all persons in the address book to the user in alphabetical order.
 */

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort and display the contact list in alphabetical order\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedList = sortByName(addressBook.getAllPersons().immutableListView());
        return new CommandResult(getMessageForPersonListShownSummary(sortedList), sortedList);
    }

    private List<ReadOnlyPerson> sortByName(List<ReadOnlyPerson> dummyList) {
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