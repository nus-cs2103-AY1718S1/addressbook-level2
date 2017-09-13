package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Set<String> keywords;

    private static final boolean MATCHED = true;
    private static final boolean NOT_MATCHED = false;

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
        final List<ReadOnlyPerson> personsFound = getPersonsWithDetailsContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names or public phone numbers
     * contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithDetailsContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (nameMatchesKeyword(person, keywords) ||
                    (!person.getPhone().isPrivate() && phoneMatchesKeyword(person, keywords)) ) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Checks if any part of a person's name matches any of the specified keywords.
     *
     * @return true if there is a match, false otherwise.
     */
    private boolean nameMatchesKeyword(ReadOnlyPerson person, Set<String> allKeywords) {
        final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
        if (!Collections.disjoint(wordsInName, allKeywords)) {
            return MATCHED;
        }

        return NOT_MATCHED;
    }

    /**
     * Checks if a person's phone number matches any of the specified keywords.
     *
     * @return true if there is a match, false otherwise.
     */
    private boolean phoneMatchesKeyword(ReadOnlyPerson person, Set<String> allKeywords) {
        final Set<String> phoneNumber = new HashSet<>();
        phoneNumber.add(person.getPhone().toString());
        if (!Collections.disjoint(phoneNumber, allKeywords)) {
            return MATCHED;
        }

        return NOT_MATCHED;
    }

}
