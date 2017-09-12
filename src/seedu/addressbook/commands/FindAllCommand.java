package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindAllCommand extends Command {

    public static final String COMMAND_WORD = "findAll";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Set<String> keywords;

    public FindAllCommand(Set<String> keywords) {
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
     * Retrieves all persons in the address book whose names contain any of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
            if (hasAnyKeywordInAnyPartOfName(wordsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Checks if any keyword matches or is a sub-sequence in any part of a name
     * @param wordsInName set of words in name
     * @param keywords set of keywords
     * @return true if any part of name contains any keyword
     */

    private boolean hasAnyKeywordInAnyPartOfName(Set<String> wordsInName, Set<String> keywords) {
        Set <String> wordsInNameLowerCase = changeToLowerCase(wordsInName);
        Set <String> keywordsInLowerCase = changeToLowerCase(keywords);
        // if have elements in common (i.e. equals)
        if (!Collections.disjoint(wordsInNameLowerCase, keywordsInLowerCase)) {
            return true;
        }
        // if any part of name contains any keyword as a sub-sequence
        if (hasSequenceOfCharsInKeyWord(wordsInNameLowerCase, keywordsInLowerCase)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if any keyword is a sub-sequence of a name
     * @param wordsInName set of words in name
     * @param keywords set of keywords provided by user
     * @return true if any word in a name contains any keyword as a sub-sequence
     */
    private boolean hasSequenceOfCharsInKeyWord(Set<String> wordsInName, Set<String> keywords) {
        for (String keyword: keywords) {
            for (String eachWordInName: wordsInName) {
                if (eachWordInName.contains(keyword)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Takes in a string set coverts every string to lowercase
     * @param set to be converted
     * @return a Set of Strings in lowercase
     */
    private Set<String> changeToLowerCase (Set<String> set) {
        Set<String> lowerCaseSet= new HashSet<String>();
        for (String each_str: set) {
            lowerCaseSet.add(each_str.toLowerCase());
        }
        return lowerCaseSet;
    }

}
