package seedu.addressbook.commands;

import java.util.HashSet;
import java.util.Set;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * Update a person's information in the address book
 */
public class UpdateCommand extends Command{

    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Update a person's information in the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";
    public static final String MESSAGE_PERSON_NOT_FOUND = "%1$s could not be found in address book";
    public static final String MESSAGE_SUCCESS = "Person is updated as: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";
    public static final String MESSAGE_UNNECESSARY_UPDATE = "Same information as existing one, no need to update";

    private final Person toUpdate;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public UpdateCommand(String name,
                      String phone, boolean isPhonePrivate,
                      String email, boolean isEmailPrivate,
                      String address, boolean isAddressPrivate,
                      Set<String> tags) throws IllegalValueException {
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        this.toUpdate = new Person(
                new Name(name),
                new Phone(phone, isPhonePrivate),
                new Email(email, isEmailPrivate),
                new Address(address, isAddressPrivate),
                new UniqueTagList(tagSet)
        );
    }

    public UpdateCommand (Person toUpdate){
        this.toUpdate = toUpdate;
    }

    @Override
    public CommandResult execute() {
        try {
            ReadOnlyPerson target = getPersonByName(toUpdate.getName());
            if (target.equals(toUpdate)){
                return new CommandResult(MESSAGE_UNNECESSARY_UPDATE);
            }
            addressBook.removePerson(target);
        } catch (PersonNotFoundException pnfe){
            return new CommandResult(String.format(MESSAGE_PERSON_NOT_FOUND, toUpdate.getName()));
        }

        try {
            addressBook.addPerson(toUpdate);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toUpdate));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
    }

    /**
     *
     * @param name The name of the target person
     * @return
     * @throws PersonNotFoundException
     */
    public ReadOnlyPerson getPersonByName (Name name) throws PersonNotFoundException{
        for (ReadOnlyPerson person: addressBook.getAllPersons()){
            if (person.getName().equals(name))
                return person;
        }

        throw new PersonNotFoundException();
    }

    public ReadOnlyPerson getPerson() {
        return toUpdate;
    }
}
