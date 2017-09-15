package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.HashSet;
import java.util.Set;

/**
 * Changes tags of a person in the address book
 */
public class ChangeTagCommand extends Command{

    public static final String COMMAND_WORD = "changetag";

    private Set<String> newTags;

    public ChangeTagCommand(int targetIndex, Set<String> newTags) {
        super(targetIndex);
        this.newTags = newTags;

    }
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Change tags of person "
            + "identified by the index number in the last shown person listing.\n"
            + "Parameters: INDEX [t/TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 t/friend t/NUS";


    public static final String MESSAGE_SUCCESS = "Person tag changed: %1$s";


    @Override
    public CommandResult execute(){
        try {
            final ReadOnlyPerson target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            final Set<Tag> tagSet = new HashSet<>();
            for (String tagName : newTags) {
                tagSet.add(new Tag(tagName));
            }
            Person toAdd = new Person(
                    new Name(target.getName().toString()),
                    new Phone(target.getPhone().toString(), target.isPhonePrivate()),
                    new Email(target.getEmail().toString(), target.isEmailPrivate()),
                    new Address(target.getAddress().toString(), target.isAddressPrivate()),
                    new UniqueTagList(tagSet)
            );
            addressBook.removePerson(target);
            addressBook.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd.getAsTextHidePrivate()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (UniquePersonList.PersonNotFoundException e) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (UniquePersonList.DuplicatePersonException e) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (IllegalValueException e) {
            return new CommandResult(Messages.MESSAGE_INVALID_COMMAND_FORMAT);
        }
    }

}
