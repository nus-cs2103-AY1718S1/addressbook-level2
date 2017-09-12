package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts the list of persons based on a parameter
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of persons based on a parameter, "
            + "such as name, phone or email. \n"
            + "Parameters: KEYWORD [PARAMETER]...\n"
            + "Example: " + COMMAND_WORD + " name";

    private final String parameter;

    public String getParameter() {
        return parameter;
    }

    public SortCommand(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

}
