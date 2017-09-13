package seedu.addressbook.commands;

import java.util.*;
import java.lang.String;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

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
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        String[] keywordsIntermediate= keywords.toArray(new String[0]);
        for (int i=0;i<keywordsIntermediate.length;++i){
            keywordsIntermediate[i]=keywordsIntermediate[i].toLowerCase();
        }
        keywords.clear();
        keywords.addAll(Arrays.asList(keywordsIntermediate));
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final List<String> wordsIntermediate= person.getName().getWordsInName();
            ListIterator<String> wordIterator = wordsIntermediate.listIterator();
            while (wordIterator.hasNext())
            {
                wordIterator.set(wordIterator.next().toLowerCase());
            }
            final Set<String> wordsInName = new HashSet<>(wordsIntermediate);
            if (!Collections.disjoint(wordsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
