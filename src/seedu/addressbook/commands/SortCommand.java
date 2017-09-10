package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": sorts all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SORT_SUCCESS = "List successfully sorted!";


    @Override
    public CommandResult execute() {
        if (addressBook.isEmpty()) {
            return new CommandResult(Messages.MESSAGE_EMPTY_ADDRESSBOOK);
        }
        addressBook.executeSort();

        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(MESSAGE_SORT_SUCCESS + "\n" +
                getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
