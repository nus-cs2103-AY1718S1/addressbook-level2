package seedu.addressbook.commands;

import java.util.*;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice/Alice/ALICE bob/Bob/BOB...";

    private final Set<String> keywords;


    public FindCommand(Set<String> keywords) {

        // Updated features:
        // Keyword matching is case-insensitive.
        String[] tempKeywords = keywords.toArray(new String[0]);
        for (int i = 0; i < tempKeywords.length; ++i) {
            tempKeywords[i] = tempKeywords[i].toLowerCase();
        }
        keywords.clear();
        keywords.addAll(Arrays.asList(tempKeywords));

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
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
            if (!Collections.disjoint(toLowerCase(wordsInName), keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    private static Set<String> toLowerCase(Set<String> words) {
        final Set<String> lowerCasedWords = new HashSet<>();
        for (String word : words) {
            lowerCasedWords.add(word.toLowerCase());
        }
        return lowerCasedWords;
    }
}
