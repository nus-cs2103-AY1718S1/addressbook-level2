package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> sortedPersons = sortPersonsAlphabetically();
        return new CommandResult(getMessageForPersonSortShownSummary(sortedPersons), sortedPersons);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> sortPersonsAlphabetically() {
        final List<ReadOnlyPerson> sortedPersons = new ArrayList<>();



        return sortedPersons;
    }

}
