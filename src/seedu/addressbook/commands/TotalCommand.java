package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Lists the total number of contacts in your addressbook.
 */
public class TotalCommand extends Command {

    public static final String COMMAND_WORD = "total";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the total number of contacts stored in your address book.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_DETAIL =  " contacts are currently stored in your address book.";

    //constructor
    public TotalCommand () {}

    @Override
    public CommandResult execute() {

        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        int total = allPersons.size();
        return new CommandResult(Integer.toString(total) + MESSAGE_DETAIL);

    }
}
