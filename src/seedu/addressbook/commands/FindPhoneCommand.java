package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Finds and lists all persons in address book whose number contains all the digits specified in sequence.
 * Number matching is sequence-sensitive, "689" will not match "896".
 */

public class FindPhoneCommand extends Command {

    public static final String COMMAND_WORD = "pfind";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose phone number contains "
            + "the specified digits in sequence and displays them as a list with index numbers.\n"
            + "Parameters: NUMBER\n"
            + "Example: " + COMMAND_WORD + " 689";

    private final int phoneNumber;

    public FindPhoneCommand(int number) { this.phoneNumber = number; }

    /**
     * Returns a copy of the phone number to search by
     */
    public int getPhoneNumber() { return phoneNumber; }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingPhoneNumber(phoneNumber);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingPhoneNumber(int number) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (person.getPhone().toString().contains(number + ""))
                matchedPersons.add(person);
        }
        return matchedPersons;
    }

}
