package seedu.addressbook.commands;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private static final int FIND_DISTANCE_TOLERANCE = 3;

    private final Set<String> keywords;

    public FindCommand(Set<String> keywords) {
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
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords,
     * within a levenshtein distance of {@link #FIND_DISTANCE_TOLERANCE}.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (doesPersonsNameContainAnyKeyword(person, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Returns whether a person's name contains some of the specified keywords, within a levenshtein
     * distance of {@link #FIND_DISTANCE_TOLERANCE}.
     *
     * @param person   to search
     * @param keywords for searching
     * @return whether person's name contains keywords
     */
    private boolean doesPersonsNameContainAnyKeyword(ReadOnlyPerson person, Set<String> keywords) {
        final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
        for (String a : wordsInName) {
            for (String b : keywords) {
                if (Utils.levenshteinDistance(a, b) < FIND_DISTANCE_TOLERANCE) {
                    return true;
                }
            }
        }
        return false;
    }

}
