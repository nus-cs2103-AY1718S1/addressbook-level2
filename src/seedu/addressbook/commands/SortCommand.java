package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book in alphabetical order as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    private static List SortCommand(List<ReadOnlyPerson> allPersons) {
        List<ReadOnlyPerson> toBeDisplayed = new ArrayList<ReadOnlyPerson>(allPersons);
        ObjectComparator comparator = new ObjectComparator();
        Collections.sort(toBeDisplayed, comparator);
        return toBeDisplayed;
    }


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> toBeDisplayed = SortCommand(allPersons);
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), toBeDisplayed);
    }
}


 class ObjectComparator implements Comparator<ReadOnlyPerson> {

    public int compare(ReadOnlyPerson obj1, ReadOnlyPerson obj2) {
        String person1 = obj1.getName().toString();
        String person2 = obj2.getName().toString();
        return person1.compareToIgnoreCase(person2);
    }

}
