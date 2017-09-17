package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Sorts all persons in the address book in alphabetical order and returns list to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        addressBook.sortAddressBook();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForSortedPersonList(), allPersons);
    }
}