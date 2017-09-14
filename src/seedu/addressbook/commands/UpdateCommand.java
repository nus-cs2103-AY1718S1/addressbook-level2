package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.UniqueTagList.DuplicateTagException;

import java.util.HashSet;
import java.util.Set;

public class UpdateCommand extends Command {
    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Updates the contact details of one existing person in the AddressBook.\n"
            + "The person is identified by the index number in the last shown person listing.\n"
            + "One or multiple contact details of that person can be updated at one time.\n"
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: INDEX [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 Smith p/86492434 e/someguy@gmail.com";

    private static final String MESSAGE_SUCCESS = "Person updated: %1$s";
    private static final String MESSAGE_DUPLICATE_TAG = "Trying to add duplicate tags to the same person.\n"
            + "Person not updated: %1$s";

    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;
    private final UniqueTagList tagList;

    public UpdateCommand(int targetVisibleIndex, String name,
                         String phone, boolean isPhonePrivate,
                         String email, boolean isEmailPrivate,
                         String address, boolean isAddressPrivate,
                         Set<String> tags) throws IllegalValueException {
        super(targetVisibleIndex);

        this.name = isBeingUpdated(name) ? new Name(name) : null;
        this.phone = isBeingUpdated(phone) ? new Phone(phone, isPhonePrivate) : null;
        this.email = isBeingUpdated(email) ? new Email(email, isEmailPrivate) : null;
        this.address = isBeingUpdated(address) ? new Address(address, isAddressPrivate) : null;

        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        tagList = new UniqueTagList(tagSet);
    }

    @Override
    public CommandResult execute() {
        final ReadOnlyPerson target;

        try {
            target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        try {
            addressBook.updatePerson(target, name, phone, email, address, tagList);
            return new CommandResult(String.format(MESSAGE_SUCCESS, target));
        } catch (DuplicateTagException dte) {
            return new CommandResult(String.format(MESSAGE_DUPLICATE_TAG, target));
        }
    }

    private boolean isBeingUpdated(String test) {
        return test != null && test.length() > 0;
    }
}
