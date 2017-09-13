package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;


/**
 * Edits a person identified using it's last displayed index from the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX [p]p/PHONE\n"
            + "Example: " + COMMAND_WORD + " 1 pp/12345678";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Editted Person to: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private Person editted;
    private String phone;
    private boolean isPhonePrivate;

    public EditCommand(int targetVisibleIndex , String phone, boolean isPhonePrivate){
        super(targetVisibleIndex);
        this.phone = phone;
        this.isPhonePrivate = isPhonePrivate;
    }


    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();

            editted = new Person(target.getName(),
                    new Phone(phone,isPhonePrivate),
                    target.getEmail(),
                    target.getAddress(),
                    target.getTags());

            addressBook.removePerson(target);
            addressBook.addPerson(editted);
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, editted));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        } catch (IllegalValueException e) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
    }

}
