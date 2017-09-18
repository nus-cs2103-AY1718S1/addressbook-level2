package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds and lists all persons in address book whose number contains all the digits specified in sequence.
 * Number matching is sequence-sensitive, "689" will not match "896".
 */

public class FindPhoneCommand extends Command {

    public static final String COMMAND_WORD = "pfind";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose phone number contains "
            + "the specified digits in sequence and displays them as a list with index numbers.\n"
            + "Separate different search terms with space.\n"
            + "Add negative sign '-' before number sequence to indicate exclusion of all results with the number "
            + "sequence instead.\n"
            + "Parameters: NUMBER [MORE NUMBERS ...]\n"
            + "Example: " + COMMAND_WORD + " 689 -68 89";

    private final ArrayList<Integer> inclusivePhoneNumberTerms;
    private final ArrayList<Integer> exclusivePhoneNumberTerms;

    public FindPhoneCommand(String[] numbersString) {
        inclusivePhoneNumberTerms = new ArrayList<Integer>();
        exclusivePhoneNumberTerms = new ArrayList<Integer>();
        classifySearchTerms(numbersString, inclusivePhoneNumberTerms, exclusivePhoneNumberTerms);
    }

    /**
     * Splits an array of number sequence in String format into inclusive and exclusive search terms
     * and add these terms into their respective lists supplied as parameters
     * @param numbersString an array of String with number sequences
     * @param inclusiveTerms a list for inclusive search terms to be added to
     * @param exclusiveTerms a list for exclusive search terms to be added to
     */
    private void classifySearchTerms(String[] numbersString, List inclusiveTerms, List exclusiveTerms) {
        for (String number : numbersString) {
            int phoneNumberTerm = Integer.parseInt(number);
            if (phoneNumberTerm < 0) {
                exclusiveTerms.add(Math.abs(phoneNumberTerm));
            } else {
                inclusiveTerms.add(phoneNumberTerm);
            }
        }
    }

    /**
     * Checks if specified person has phone number containing any sequence in list of search terms
     * @param person a ReadOnlyPerson object to check
     * @param searchTerms a list of search terms to check against
     * @return true if specified person has phone number that contains any sequence in list of search terms,
     *          false otherwise
     */
    private boolean checkPersonPhoneNumberAgainstSequencesInList(ReadOnlyPerson person, List<Integer> searchTerms) {
        for (int singleSearchTerm : searchTerms) {
            if (person.getPhone().toString().contains(singleSearchTerm + "")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a copy of the phone number to search by
     */
    public ArrayList<Integer> getInclusivePhoneNumberTerms() { return inclusivePhoneNumberTerms; }
    public ArrayList<Integer> getExclusivePhoneNumberTerms() { return exclusivePhoneNumberTerms; }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound =
                getPersonsWithNameContainingPhoneNumber(inclusivePhoneNumberTerms, exclusivePhoneNumberTerms);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified number sequence in the
     * inclusiveTerms list, and none of the specified number sequence in the exclusiveTerms list
     *
     * @param list of inclusive search terms
     * @param list of exclusive search terms
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingPhoneNumber(List<Integer> inclusiveTerms,
                                                                         List<Integer> exclusiveTerms) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (checkPersonPhoneNumberAgainstSequencesInList(person, exclusiveTerms)) {
                continue;
            }
            if (checkPersonPhoneNumberAgainstSequencesInList(person, inclusiveTerms)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
