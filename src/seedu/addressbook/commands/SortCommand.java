package seedu.addressbook.commands;

import seedu.addressbook.data.person.UniquePersonList;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": sorts persons in the list\n" + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "list sorted successfully";

    public SortCommand() {

    }

    @Override
    public CommandResult execute() {
        addressBook.sort();
        //addressBook.getAllPersons();
        return new CommandResult( MESSAGE_SUCCESS);
    }

}
