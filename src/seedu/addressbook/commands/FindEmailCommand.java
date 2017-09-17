package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose email contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindEmailCommand extends Command {

    public static final String COMMAND_WORD = "find_email";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose email contains "
            + "the specified email address (case-sensitive) and displays entire information of persons found\n"
            + "Parameters: FULL_EMAIL\n"
            + "Example: " + COMMAND_WORD + " alice@gmail.com";

    private final Set<String> keywords;

    public FindEmailCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithEmailContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithEmailContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInEmail = new HashSet<>(person.getEmail().getWordsInEmail());
            if (!Collections.disjoint(wordsInEmail, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
