package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book alphabetically and display them as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Addressbook has been successfully sorted in alphabetical order.\n" ;


    @Override
    public CommandResult execute() {
        addressBook.sortPerson();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(MESSAGE_SUCCESS + getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
