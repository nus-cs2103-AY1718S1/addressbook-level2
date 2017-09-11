package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.WriteOnlyPerson;

import java.util.List;

import static seedu.addressbook.ui.TextUi.DISPLAYED_INDEX_OFFSET;

/**
 * Represents an executable command.
 */
public class Command {
    protected AddressBook addressBook;
    protected List<? extends ReadOnlyPerson> relevantReadOnlyPersons;
    protected List<? extends WriteOnlyPerson> relevantWriteOnlyPersons;
    private int targetIndex = -1;

    /**
     * @param targetIndex last visible listing index of the target person
     */
    public Command(int targetIndex) {
        this.setTargetIndex(targetIndex);
    }

    protected Command() {
    }

    /**
     * Constructs a feedback message to summarise an operation that displayed a listing of persons.
     *
     * @param personsDisplayed used to generate summary
     * @return summary message for persons displayed
     */
    public static String getMessageForPersonListShownSummary(List<? extends ReadOnlyPerson> personsDisplayed) {
        return String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, personsDisplayed.size());
    }

    /**
     * Executes the command and returns the result.
     */
    public CommandResult execute(){
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    };

    /**
     * Supplies the data the command will operate on.
     */
    public void setReadOnlyData(AddressBook addressBook, List<? extends ReadOnlyPerson> relevantReadOnlyPersons) {
        this.addressBook = addressBook;
        this.relevantReadOnlyPersons = relevantReadOnlyPersons;
    }

    public void setWriteOnlyData(AddressBook addressBook, List<? extends WriteOnlyPerson> relevantWriteOnlyPersons) {
        this.addressBook = addressBook;
        this.relevantWriteOnlyPersons = relevantWriteOnlyPersons;
    }

    /**
     * Extracts the the target person in the last shown list from the given arguments.
     *
     * @throws IndexOutOfBoundsException if the target index is out of bounds of the last viewed listing
     */
    protected ReadOnlyPerson getTargetReadOnlyPerson() throws IndexOutOfBoundsException {
        return relevantReadOnlyPersons.get(getTargetIndex() - DISPLAYED_INDEX_OFFSET);
    }

    protected WriteOnlyPerson getTargetWriteOnlyPerson() throws  IndexOutOfBoundsException {
        return relevantWriteOnlyPersons.get(getTargetIndex() - DISPLAYED_INDEX_OFFSET);
    }

    public int getTargetIndex() {
        return targetIndex;
    }

    public void setTargetIndex(int targetIndex) {
        this.targetIndex = targetIndex;
    }
}
