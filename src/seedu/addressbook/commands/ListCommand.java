package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends SortableCommand {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers, "
            + "sorted by addition order or the optional specified sort orders." + "\n"
            + "Parameters: " + SORT_USAGE + "\n"
            + "Example: " + COMMAND_WORD + " n/ p/desc";
    
    public ListCommand(List<String> sortArguments) {
        super(sortArguments);
    }
    
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = getSortedPersons(addressBook.getAllPersons().immutableListView());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
