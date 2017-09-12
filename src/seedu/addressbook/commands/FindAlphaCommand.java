package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindAlphaCommand extends Command {

    public static final String COMMAND_WORD = "findalpha";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names start with "
            + "the specified letters (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: [letter]\n"
            + "Example: " + COMMAND_WORD + " A";

    private final String keywords;

    public FindAlphaCommand(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */


    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameStartingWith(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameStartingWith(String keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();

        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if ((person.getName().toString().charAt(0) ==  Character.toLowerCase(keywords.charAt(0))) ||
                    (person.getName().toString().charAt(0) ==  Character.toUpperCase(keywords.charAt(0))))
                matchedPersons.add(person);
        }

        return matchedPersons;
    }

}
