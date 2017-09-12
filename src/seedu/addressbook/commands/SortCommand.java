package seedu.addressbook.commands;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.List;

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
        switch (commandArg.toLowerCase()) {
            case COMMAND_ARG_NAME: return executeSortAllByName();
            case COMMAND_ARG_PHONE: return executeSortAllByPhone();
            default: return executeSortAllByEmail();
        }
    }

    /**
     * Calls sortByName() to address book by name
     * @return message for successful sort by name
     */
    private CommandResult executeSortAllByName() {
        UniquePersonList allPersons = addressBook.getAllPersons();
        addressBook.sortByName();
        return new CommandResult(String.format(MESSAGE_SORT_SUCCESS, commandArg));
    }

    /**
     * Calls sortByPhone() to address book by phone
     * @return message for successful sort by phone
     */
    private CommandResult executeSortAllByPhone() {
        UniquePersonList allPersons = addressBook.getAllPersons();
        addressBook.sortByPhone();
        return new CommandResult(String.format(MESSAGE_SORT_SUCCESS, commandArg));
    }

    /**
     * Calls sortByEmail() to address book by email
     * @return message for successful sort by email
     */
    private CommandResult executeSortAllByEmail() {
        UniquePersonList allPersons = addressBook.getAllPersons();
        addressBook.sortByEmail();
        return new CommandResult(String.format(MESSAGE_SORT_SUCCESS, commandArg));
    }
}
