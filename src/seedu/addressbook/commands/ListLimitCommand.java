package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

public class ListLimitCommand extends Command{
    public static final String COMMAND_WORD = "listlimit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Limits and displays only the specific number of persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    public ListLimitCommand(int targetVisibleIndex) {
        super(targetVisibleIndex);
    }

    public CommandResult execute() {
        int limit = getTargetIndex();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> limitPersons = new ArrayList<ReadOnlyPerson>();
        if(limit>allPersons.size()) {
            limit = allPersons.size();
        }
        for(int i=0; i<limit; i++) {
            limitPersons.add(allPersons.get(i));
        }
        return new CommandResult(getMessageForPersonListShownSummary(limitPersons), limitPersons);
    }
}
