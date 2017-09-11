package seedu.addressbook.commands;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String COMMAND_ARG_NAME = "name";
    public static final String COMMAND_ARG_PHONE = "phone";
    public static final String COMMAND_ARG_EMAIL = "email";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all contacts in the address book" +
            " by name, phone or email.\n" +
            "Example: " + COMMAND_WORD + " name";

    public static final String MESSAGE_SORT_SUCCESS = "Address book is now sorted by %1$s.";

    public static final int SORT_COMMAND_LENGTH = 2;
    public static final int SORT_COMMAND_INDEX = 0;
    public static final int SORT_ARGUMENT_INDEX = 1;

    private String commandArg;

    public SortCommand(String command) {
        commandArg = command;
    }

    @Override
    public CommandResult execute() {
        switch (commandArg) {
            case COMMAND_ARG_NAME: return executeSortAllByName();
            case COMMAND_ARG_PHONE: return executeSortAllByPhone();
            default: return executeSortAllByEmail();
        }
    }

    private CommandResult executeSortAllByName() {

        return new CommandResult(String.format(MESSAGE_SORT_SUCCESS, commandArg));
    }

    private CommandResult executeSortAllByPhone() {

        return new CommandResult(String.format(MESSAGE_SORT_SUCCESS, commandArg));
    }

    private CommandResult executeSortAllByEmail() {

        return new CommandResult(String.format(MESSAGE_SORT_SUCCESS, commandArg));
    }
}
