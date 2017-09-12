package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts the list of persons based on a parameter
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of persons based on a parameter, "
            + "such as name, phone or email. Only 1 parameter is allowed.\n"
            + "Parameters: KEYWORD [PARAMETER]...\n"
            + "Example: " + COMMAND_WORD + " name";

    public static final String MESSAGE_SUCCESS = "Finished sorting by %1$s";

    private final String parameter;

    public SortCommand(String parameter) {
        this.parameter = parameter;
    }

    /**
     * Returns a copy of the parameter in this command.
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * Sorts the persons in the address book based on the parameter chosen
     * @return A success message if sorting works
     */
    @Override
    public CommandResult execute() {
        addressBook.sortByParameter(parameter);
        return new CommandResult(String.format(MESSAGE_SUCCESS, parameter));
    }
}
