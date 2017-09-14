package seedu.addressbook.commands;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the address book by either name, phone, email"
            + " or address.\n"
            + "Example 1: " + COMMAND_WORD + " name\n"
            + "Example 2: " + COMMAND_WORD + " phone\n"
            + "Example 3: " + COMMAND_WORD + " email\n"
            + "Example 4: " + COMMAND_WORD + " address";

    public static final String MESSAGE_SUCCESS = "Address book successfully sorted by %1$s";

    private String sortBy;

    public SortCommand(String arg) {
        sortBy = arg;
    }

    @Override
    public CommandResult execute() {
        addressBook.sortBy(sortBy);
        return new CommandResult(String.format(MESSAGE_SUCCESS, sortBy));
    }
}
