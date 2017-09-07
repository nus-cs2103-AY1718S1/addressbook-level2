package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.Postal;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.Tag;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edit the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX, n/, p/, e/, t/, /T\n"
            + "Example: " + COMMAND_WORD + " 1 "+"n/James Chen\n"
            + "Usage for tags: " + "t/for addition, T/for deletion";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";

    public static final String MESSAGE_EDIT_PERSON_FAIL =
            "Failed to edit this person as some updates values are illegal";

    private HashMap<String, String> updateValuesHashMap;

    private Name personName;
    private Phone personPhone;
    private Email personEmail;
    private Address personAddress;
    private Block personBlock;
    private Street personStreet;
    private Unit personUnit;
    private Postal personPostal;
    private UniqueTagList personTagsList;

    /**
     * Constructors - for target index
     * @param targetVisibleIndexToEdit
     */
    public EditCommand (int targetVisibleIndexToEdit, HashMap<String, String> updateValuesHashMap) {
        super(targetVisibleIndexToEdit);
        this.updateValuesHashMap = updateValuesHashMap;
    }

    /**
     * Default constructor
     */
    public EditCommand () {
        super();
    }

    /**
     * Edit Command execution process using target index and HashMap parsed
     * @return the CommandResult of this editing
     */
    @Override
    public CommandResult execute() throws IllegalValueException{
        try {
            final ReadOnlyPerson target = getTargetPerson();
            personName = target.getName();
            personPhone = target.getPhone();
            personEmail = target.getEmail();
            personAddress = target.getAddress();
            personBlock = target.getBlock();
            personStreet = target.getStreet();
            personPostal = target.getPostal();
            personUnit = target.getUnit();
            personTagsList = target.getTags();

            // Update information - including passing of tagging information
            personName = updateNameObject(personName, updateValuesHashMap);
            personPhone = updatePhoneObejct(personPhone, updateValuesHashMap);
            personEmail = updateEmailObject(personEmail, updateValuesHashMap);
            personAddress = updateAddressObject(personAddress, updateValuesHashMap);
            personTagsList = updateTagsObject(personTagsList, updateValuesHashMap, target);

            // Construct the new person
            Person person = new Person(personName, personPhone, personEmail, personAddress, personTagsList);

            // Remove this person to be added back later
            addressBook.removePerson(target);

            // Add the new person to the address book
            addressBook.addPerson(person);

            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, person));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (UniquePersonList.PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }

    }

    public Name updateNameObject (Name originalName, HashMap<String, String> updateValuesHashMap)
            throws IllegalValueException {
        String value = updateValuesHashMap.get("n");
        try {
            if (value != null) {
                Name updatedName = new Name(value);
                return updatedName;
            }
        }catch (IllegalValueException e) {
            throw new IllegalValueException(MESSAGE_EDIT_PERSON_FAIL);
        }
        return originalName;
    }

    public Phone updatePhoneObejct (Phone originalPhone, HashMap<String, String> updateValuesHashMap)
            throws IllegalValueException {
        String value = updateValuesHashMap.get("p");
        try {
            if (value != null) {
                Phone updatedPhone = new Phone(value, originalPhone.isPrivate());
                return updatedPhone;
            }
        } catch (IllegalValueException e) {
            throw new IllegalValueException(MESSAGE_EDIT_PERSON_FAIL);
        }
        return originalPhone;
    }

    public Email updateEmailObject (Email originalEmail, HashMap<String, String> updateValuesHashMap)
            throws IllegalValueException {
        String value = updateValuesHashMap.get("e");
        try {
            if (value != null) {
                Email updatedEmail = new Email(value, originalEmail.isPrivate());
                return updatedEmail;
            }
        } catch (IllegalValueException e) {
            throw new IllegalValueException(MESSAGE_EDIT_PERSON_FAIL);
        }
        return originalEmail;
    }

    /**
     * This is the update Address function returning the newly updated address object
     * We make this smart enough that you can only rewrite a component of address but cannot delete a component
     * Enhancements:
     * Every newly created component will be compared with original one to be updated
     * @param originalAddress - the original address object
     * @param updateValuesHashMap - gives the raw address string input, which is parsed exactly the same as add command
     * @return the updated address object
     * @throws IllegalValueException
     */
    public Address updateAddressObject (Address originalAddress, HashMap<String, String> updateValuesHashMap)
            throws IllegalValueException {
        // First step, initialization, get back original components and the update raw string
        String value = updateValuesHashMap.get("a");
        try {
            if (value != null) {
                Address updatedAddress = AddCommand.addressObjectStringGetter(value, originalAddress.isPrivate());
                return updatedAddress;
            }
        } catch (IllegalValueException e) {
                throw new IllegalValueException(MESSAGE_EDIT_PERSON_FAIL);
        }
        return originalAddress;
    }

    /**
     * Function to generate unique tags list to help create the new person to be added back
     * @param origianlTagsList - the previous unique tag list
     * @param updateValuesHashMap - the hashMap generated from the command line input
     * @param target - the target person in concern
     * @return the resulted newly updated unique tag list
     * @throws IllegalValueException
     */
    public UniqueTagList updateTagsObject (UniqueTagList origianlTagsList, HashMap<String, String> updateValuesHashMap,
                                           ReadOnlyPerson target)
            throws IllegalValueException {
        // initialization
        String additionTagsString = updateValuesHashMap.get("t");
        String deletionTagsString = updateValuesHashMap.get("T");
        Set<Tag> tagsSetOperating = origianlTagsList.toSet();

        // Operations
        if (additionTagsString != null) {
            String[] additionStringArray = additionTagsString.split(",");
            passTaggingsInfoByUpdatingPersonToBeDeleted(additionStringArray, true, addressBook, target);
            ArrayList<Tag> additionArrayList = new ArrayList<>();
            for (String s : additionStringArray) {
                additionArrayList.add(new Tag(s));
                tagsSetOperating.add(new Tag(s));
            }
        }
        if (deletionTagsString != null) {
            String[] deletionStringArray = deletionTagsString.split(",");
            passTaggingsInfoByUpdatingPersonToBeDeleted(deletionStringArray, false, addressBook, target);
            ArrayList<Tag> deletionArrayList = new ArrayList<>();
            for (String s : deletionStringArray) {
                deletionArrayList.add(new Tag(s));
                tagsSetOperating.remove(new Tag(s));
            }
        }
        return new UniqueTagList(tagsSetOperating);

    }

    /**
     * Function processing the update operations of the tags
     * tags are deleted on the person in concern
     * More importantly, this just facilitates the passing of the tags
     * @param updatingStringArray - String array containing tags String representation
     * @param isAddition - true as addition and false as deletion
     * @param addressBook - the current addressBook program
     * @param person - person in concern
     * @throws IllegalValueException
     */
    public void passTaggingsInfoByUpdatingPersonToBeDeleted(String[] updatingStringArray,
                                                            boolean isAddition, AddressBook addressBook,
                                                            ReadOnlyPerson person) throws IllegalValueException{

        if (isAddition) {
            try {
                for (String s : updatingStringArray) {
                    Tag stringToTag = new Tag(s);
                    addressBook.addTagToPerson(person, stringToTag);
                }
            } catch (IllegalValueException e) {
                throw new IllegalValueException(MESSAGE_EDIT_PERSON_FAIL);
            }
        } else {
            try {
                for (String s : updatingStringArray) {
                    Tag stringToTag = new Tag(s);
                    addressBook.deleteTagFromPerson(person, stringToTag);
                }
            } catch (IllegalValueException e) {
                throw new IllegalValueException(MESSAGE_EDIT_PERSON_FAIL);
            }
        }
    }

}
