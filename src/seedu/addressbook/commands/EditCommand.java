package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * Edits a person's name in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the name of the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX NAME\n"
            + "Example: " + COMMAND_WORD + " 1" + " Charlie";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_INVALID_PERSON_NAME = "Invalid name to change to.";

    private final String desiredName;


    public EditCommand(int targetVisibleIndex, String changeToName) {
        super(targetVisibleIndex);
        desiredName = changeToName;
    }

    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            addressBook.removePerson(target);
            Person editedPerson = convertAndEditPerson(target, desiredName);
            addressBook.addPerson(editedPerson);
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (UniquePersonList.PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (IllegalValueException e) {
            return new CommandResult(MESSAGE_INVALID_PERSON_NAME);
        }
    }

    private Person convertAndEditPerson(ReadOnlyPerson initialPerson, String changeToName)
                                                            throws IllegalValueException {

        Person convertedPerson = new Person( new Name(changeToName),
                                            initialPerson.getPhone(),
                                            initialPerson.getEmail(),
                                            initialPerson.getAddress(),
                                            initialPerson.getTags() );

        return convertedPerson;
    }


}
