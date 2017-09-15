package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument phoneNum.
 * Keyword matching is case sensitive.
 */
public class PhoneCommand extends Command {

    public static final String COMMAND_WORD = "phone";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose phone number is contained "
            + "in the specified phone numbers and displays them as a list with index numbers.\n"
            + "Parameters: PHONE_NUM [MORE_PHONE_NUM]...\n"
            + "Example: " + COMMAND_WORD + " 1234 991 0000";

    private final Set<String> phoneNum;

    public PhoneCommand(Set<String> phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * Returns a copy of phoneNum in this command.
     */
    public Set<String> getPhoneNum() {
        return new HashSet<>(phoneNum);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsContainingAnyPhoneNum(phoneNum);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified phoneNum.
     *
     * @param phoneNum for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsContainingAnyPhoneNum(Set<String> phoneNum) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final String personNum = person.getPhone().toString();
            if (phoneNum.contains(personNum)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}

