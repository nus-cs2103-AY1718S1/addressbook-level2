package seedu.addressbook.commands;

import com.sun.org.apache.regexp.internal.RE;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts and Displays all persons in the address book as a list with index numbers temporarily.\n"
            + "Example: " + COMMAND_WORD;
    public static final int NUMBER_ZERO = 0;
    public static final int NUMBER_ONE = 1;

    @Override
    public CommandResult execute() {
        ArrayList<ReadOnlyPerson> sortedAllPersons = new ArrayList<ReadOnlyPerson>();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

        for(ReadOnlyPerson singlePerson : allPersons) {
            sortedAllPersons.add(singlePerson);
        }

        /**
         * Sorts the list of Persons by name, alphabetically.
         */
        for(int i = NUMBER_ZERO; i < sortedAllPersons.size(); i++) {
            for(int j = i + NUMBER_ONE; j<sortedAllPersons.size(); j++) {
                if((sortedAllPersons.get(i)+"").compareTo(sortedAllPersons.get(j)+"") > NUMBER_ZERO)
                    Collections.swap(sortedAllPersons, i, j);
            }
        }

        return new CommandResult(getMessageForPersonListShownSummary(sortedAllPersons), sortedAllPersons);
    }
}
