package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and swaps any two people in the list.
 * Keyword matching is case sensitive.
 */
public class SwapCommand extends Command {

    public static final String COMMAND_WORD = "swap";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds and swap the position of two people whose names "
            + "contain any of the specified keywords (case-sensitive).\n"
            + "Parameters: KEYWORD KEYWORD\n"
            + "Example: " + COMMAND_WORD + " alice bob";

    private final Set<String> keywords;

    public SwapCommand(Set<String> keywords) {this.keywords = keywords; }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        String results;
        if (hasValidPersonsFound(personsFound)){
            addressBook.swapPerson(personsFound);
            results = "Swap completed";
        }
        else{
            results = "Swap failed, both names have to be case-sensitive and must exist in the address book.";
        }
        return new CommandResult(results);
    }

    /**
     * Checks if there are exactly two persons in the list matching the given keywords.
     *
     * @param personsFound persons found containing any keywords
     * @return truth value of having exactly two persons found having the same keywords
     */
    private static boolean hasValidPersonsFound(List<ReadOnlyPerson> personsFound){
        if (personsFound.size() == 2) {
            return true;
        }
        else {
            return false;
        }
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
            if (!Collections.disjoint(wordsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }
}
