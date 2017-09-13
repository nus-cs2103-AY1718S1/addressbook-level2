package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

/**
 * Publicises a person contact information identified using it's last displayed index from the address book.
 */
public class UnprivateCommand extends Command {

    public static final String COMMAND_WORD = "unprivate";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Publicises a person contact information "
            + "identified by the index number in the last shown person listing. Append 'p'(phone), 'e'(email) or 'a'(address)" +
            " after the index to indicate which contact to publicise. \n"
            + "Parameters: INDEX CONTACT_TYPE\n"
            + "Example: " + COMMAND_WORD
            + " 1 p";

    private static final String PHONE_PREFIX = "p";
    private static final String EMAIL_PREFIX = "e";
    private static final String ADDRESS_PREFIX = "a";

    private static final String PHONE = "phone number";
    private static final String EMAIL = "email address";
    private static final String ADDRESS = "address";

    public static final String MESSAGE_UNPRIVATE_PERSON_SUCCESS = "Person's %1$s made public: %2$s";

    public static final String UNPRIVATE_PHONE_MESSAGE = "Phone number is not private";
    public static final String UNPRIVATE_EMAIL_MESSAGE = "Email address is not private";
    public static final String UNPRIVATE_ADDRESS_MESSAGE = "Address is not private";

    public UnprivateCommand(int targetVisibleIndex, String contactType) {
        super(targetVisibleIndex, contactType);
    }

    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            final int targetIndex = getTargetIndex();
            final String contactType = getContactType();
            boolean isUnprivateSuccessful = addressBook.unprivatePerson(targetIndex, contactType);
            return unprivateMessage(isUnprivateSuccessful, contactType, target);

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);

        }

    }

    public CommandResult unprivateMessage(boolean isUnprivateSuccessful, String contactType, ReadOnlyPerson target){
        switch (contactType) {
        case PHONE_PREFIX:
            if (isUnprivateSuccessful){
                return new CommandResult(String.format(MESSAGE_UNPRIVATE_PERSON_SUCCESS, PHONE, target));
            } else {
                return new CommandResult(UNPRIVATE_PHONE_MESSAGE);
            }

        case EMAIL_PREFIX:
            if (isUnprivateSuccessful){
                return new CommandResult(String.format(MESSAGE_UNPRIVATE_PERSON_SUCCESS, EMAIL, target));
            } else {
                return new CommandResult(UNPRIVATE_EMAIL_MESSAGE);
            }

        case ADDRESS_PREFIX:
            if (isUnprivateSuccessful){
                return new CommandResult(String.format(MESSAGE_UNPRIVATE_PERSON_SUCCESS, ADDRESS, target));
            } else {
                return new CommandResult(UNPRIVATE_ADDRESS_MESSAGE);
            }

        default:
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }

    }
}
