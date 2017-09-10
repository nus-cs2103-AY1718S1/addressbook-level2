package seedu.addressbook.commands;


import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.ui.TextUi;

import java.util.ArrayList;

/**
 * Deletes a person identified using it's last displayed index from the address book.
 */
public class DeleteRangeCommand extends Command {

    public static final String COMMAND_WORD = "deleterange";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the range of people identified by the index number used in the last person listing.\n"
            + "Parameters: STARTINDEX ENDINDEX\n"
            + "Example: " + COMMAND_WORD + " 1" + " 2";

    public static final String MESSAGE_DELETE_RANGE_SUCCESS = "Deleted Range: ";

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    private ArrayList<Integer> targetVisibleIndices;

    public DeleteRangeCommand(ArrayList<Integer> targetVisibleIndices) {
        this.targetVisibleIndices = targetVisibleIndices;
    }

    @Override
    public CommandResult execute() {
        int startIndex = targetVisibleIndices.get(0);
        int endIndex = targetVisibleIndices.get(1);

        for (int i=startIndex;i<=endIndex;i++) {
            this.setTargetIndex(i);
            try {
                final ReadOnlyPerson target = getTargetPerson();
                addressBook.removePerson(target);

            } catch (IndexOutOfBoundsException ie) {
                return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            } catch (UniquePersonList.PersonNotFoundException pnfe) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            System.out.println(LINE_PREFIX + "Person of index " + i + " deleted");
        }

        return new CommandResult((MESSAGE_DELETE_RANGE_SUCCESS + startIndex + " to " + endIndex));
    }
}
