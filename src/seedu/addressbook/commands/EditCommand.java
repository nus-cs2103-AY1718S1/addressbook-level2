package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.HashSet;
import java.util.Set;

/**
 * Edits a person from the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a person from the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [[p]p/PHONE] [[p]e/EMAIL] [[p]a/ADDRESS] [[p]b/BIRTHDAY]  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 a/311, Clementi Ave 2, #02-25 b/3112 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "Person edited: %1$s";
    public static final String MESSAGE_PERSON_NOT_FOUND = "Cannot find the person";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final Person toEdit;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public EditCommand(String name,
                       String phone, boolean isPhonePrivate,
                       String email, boolean isEmailPrivate,
                       String address, boolean isAddressPrivate,
                       String birthday, boolean isBirthdayPrivate,
                       Set<String> tags) throws IllegalValueException {
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        toEdit = new Person(
                new Name(name),
                (phone == null) ? null : new Phone(phone, isPhonePrivate),
                (email == null) ? null : new Email(email, isEmailPrivate),
                (address == null) ? null : new Address(address, isAddressPrivate),
                (birthday == null) ? null : new Birthday(birthday, isBirthdayPrivate),
                new UniqueTagList(tagSet)
        );
    }

    @Override
    public CommandResult execute() {
        try {
            Person modifiedPerson = addressBook.editPerson(toEdit);
            return new CommandResult(String.format(MESSAGE_SUCCESS, modifiedPerson));
        } catch (UniquePersonList.PersonNotFoundException pnfe) {
            return new CommandResult(MESSAGE_PERSON_NOT_FOUND);
        }
    }

}
