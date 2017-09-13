package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.HashSet;
import java.util.Set;

public class EditCommand extends Command{

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the person identified by the index number used in the last person listing.\n"
            + "Please select at least one parameter to edit besides INDEX.\n"
            + "Follow the order of the parameters below when inputting.\n"
            + "Parameters: INDEX [n/NAME] [[p]p/PHONE] [[p]e/EMAIL] [[p]a/ADDRESS]  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + "1 n/John Newname e/newemail@gmail.com t/newTag";

    public static final String MESSAGE_EDITED_PERSON_SUCCESS = "Edited Person: %1$s";

    private final Person replacement;

    public EditCommand(int targetVisibleIndex, String name,
                      String phone, boolean isPhonePrivate,
                      String email, boolean isEmailPrivate,
                      String address, boolean isAddressPrivate,
                      Set<String> tags) throws IllegalValueException {
        super(targetVisibleIndex);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }

        this.replacement = new Person(
                new Name(name),
                new Phone(phone, isPhonePrivate),
                new Email(email, isEmailPrivate),
                new Address(address, isAddressPrivate),
                new UniqueTagList(tagSet)
        );
    }

    @Override
    public CommandResult execute() {
        try{
            final ReadOnlyPerson target = getTargetPerson();
            ReadOnlyPerson editedPerson = addressBook.editPerson(target, this.replacement);
            return new CommandResult(String.format(MESSAGE_EDITED_PERSON_SUCCESS, editedPerson));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }

}
