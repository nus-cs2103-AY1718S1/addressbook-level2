package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Sorts all persons in the address book by alphabetical order and lists to the user.
 */
public class SortCommand extends Command {

    private boolean saveSortedList;
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list sorted by alphabetical order. (UNSAVED)\n"
            + "Example: " + COMMAND_WORD +"\n"
            + COMMAND_WORD + " save: " +
            "Displays all persons in the address book as a list sorted by alphabetical order. (SAVED)\n"
            + "Example: " + COMMAND_WORD + " save";

    public SortCommand(boolean saveSortedList) {
        this.saveSortedList = saveSortedList;
    }

    @Override
    public CommandResult execute() {
        if(saveSortedList) {
            addressBook.sortAddressBook();
            List<ReadOnlyPerson> allPersons = new ArrayList<>(addressBook.getAllPersons().immutableListView());
            return new CommandResult(getMessageForSavedSortedPersonListShownSummary(allPersons), allPersons);
        } else {
            List<ReadOnlyPerson> allPersons = new ArrayList<>(addressBook.getAllPersons().immutableListView());
            allPersons.sort(Comparator.comparing(o -> o.getName().fullName));
            return new CommandResult(getMessageForUnsavedSortedPersonListShownSummary(allPersons), allPersons);
        }
    }
}
