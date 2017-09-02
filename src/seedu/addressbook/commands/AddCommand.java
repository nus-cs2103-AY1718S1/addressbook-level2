package seedu.addressbook.commands;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.Postal;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";
    public static final String MESSAGE_FAILED_ADD = "This add message contains value error by violating syntax";

    public static final String STREET_CHECK_REGEX = "[a-zA-Z0-9 ]+";
    public static final String UNIT_CHECK_REGEX = "#[0-9]+-[0-9]+";

    private final Person toAdd;



    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public AddCommand(String name,
                      String phone, boolean isPhonePrivate,
                      String email, boolean isEmailPrivate,
                      String address, boolean isAddressPrivate,
                      Set<String> tags) throws IllegalValueException {
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }


        try {
            this.toAdd = new Person(
                    new Name(name),
                    new Phone(phone, isPhonePrivate),
                    new Email(email, isEmailPrivate),
                    addressObjectStringGetter(address, isAddressPrivate),
                    new UniqueTagList(tagSet));
        } catch (IllegalValueException e) {
            throw new IllegalValueException(MESSAGE_FAILED_ADD);
        }
    }

    public AddCommand(Person toAdd) {
        this.toAdd = toAdd;
    }

    public ReadOnlyPerson getPerson() {
        return toAdd;
    }

    /**
     * To get the address obejct back by a first construction of four components objects
     * Taking care of the fact that some of the values may be omitted
     * @param addressString
     * @param isAddressPrivate
     * @return the wrapped Address object
     * @throws Exception
     */
    public static Address addressObjectStringGetter ( String addressString, boolean isAddressPrivate ) throws IllegalValueException {

        // Initialization
        int i = 0;
        Block block = null;
        Postal postal = null;
        Unit unit = null;
        Street street = null;
        String[] addressList = addressString.split(",");

        // Check and put input strings components into different objects
        while (i++ < addressList.length) {
            //by checking each type characteristics to see to add to each block.
            try {
                int parsedInt = Integer.parseInt(addressList[i].trim());
                if (Block.isValidBlockNumber(parsedInt)) {
                    block = new Block (parsedInt);
                } else if (Postal.isValidPostalCode(parsedInt)) {
                    postal = new Postal (parsedInt);
                } else {
                    throw new IllegalValueException(MESSAGE_FAILED_ADD);
                }
            } catch (Exception e) {
                if (addressList[i].trim().matches(UNIT_CHECK_REGEX)) {
                    unit = new Unit(addressList[i].trim());
                } else if (addressList[i].trim().matches(STREET_CHECK_REGEX)) {
                    street = new Street(addressList[i].trim());
                } else {
                    throw new IllegalValueException(MESSAGE_FAILED_ADD);
                }
            }
        }

        // Mass check of any components not initialized
        if ( block == null ) { block = new Block ("");}
        if ( postal == null ) { postal = new Postal("");}
        if ( unit==null ) { unit = new Unit("");}
        if ( street==null ) { street = new Street("");}

        //return the address result
        return new Address(block, street, unit, postal, isAddressPrivate);
    }

    @Override
    public CommandResult execute() {
        try {
            addressBook.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
    }

}
