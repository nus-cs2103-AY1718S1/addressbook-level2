package seedu.addressbook.commands;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Internally sorts the address book database according to names in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SORT_SUCCESS = "Address book has been sorted!";

    @Override
    public CommandResult execute(){
        addressBook.sort();
        return new CommandResult(MESSAGE_SORT_SUCCESS);
    }
}
