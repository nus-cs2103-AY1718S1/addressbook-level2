package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Searches any person in address book whose phone number contains any of the argument keywords.
 * Keyword is a n-digit number (0 < n < 9).
 * Searching will not return the name of a person if his number is kept private.
 */
public class SearchWithPhoneCommand extends Command {

    public static final String COMMAND_WORD = "search phone number";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Search all persons whose number contains any of "
            + "the specified keywords and displays them as a list with index numbers.\n"
            + "Parameters: NUMBERS AS KEYWORDS... \n"
            + "Example: " + COMMAND_WORD + " 1234";

    private final Set<String> keywords;

    public SearchWithPhoneCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonWithPhoneNumberContainingKeywordCmd(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves a list of persons whose phone number contains any of the keywords,
     * and the number is not kept private.
     *
     * @param keywords numbers for searching
     * @return a list of person found
     */
    private List<ReadOnlyPerson> getPersonWithPhoneNumberContainingKeywordCmd(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedList = new ArrayList<>();
        for (ReadOnlyPerson person: addressBook.getAllPersons()) {
            if (person.getPhone().isPrivate()) {
                continue;
            }
            final Set<String> numberFromBook = new HashSet<String>(person.getPhone().getNumber());
            if (!Collections.disjoint(numberFromBook, keywords)) {
                matchedList.add(person);
            }
        }
        return matchedList;
    }
}
