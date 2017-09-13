package seedu.addressbook.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import seedu.addressbook.data.person.*;
import seedu.addressbook.data.person.UniquePersonList.DuplicatePersonException;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the entire address book. Contains the data of the address book.
 * <p>
 * Guarantees:
 * - Every tag found in every person will also be found in the tag list.
 * - The tags in each person point to tag objects in the master list. (== equality)
 */
public class AddressBook {

    private final UniquePersonList allPersons;
    private final UniqueTagList allTags; // can contain tags not attached to any person

    /**
     * Creates an empty address book.
     */
    public AddressBook() {
        allPersons = new UniquePersonList();
        allTags = new UniqueTagList();
    }

    /**
     * Constructs an address book with the given data.
     * Also updates the tag list with any missing tags found in any person.
     *
     * @param persons external changes to this will not affect this address book
     * @param tags    external changes to this will not affect this address book
     */
    public AddressBook(UniquePersonList persons, UniqueTagList tags) {
        this.allPersons = new UniquePersonList(persons);
        this.allTags = new UniqueTagList(tags);
        for (Person p : allPersons) {
            syncTagsWithMasterList(p);
        }
    }

    /**
     * Ensures that every tag in this person:
     * - exists in the master list {@link #allTags}
     * - points to a Tag object in the master list
     */
    private void syncTagsWithMasterList(Person person) {
        final UniqueTagList personTags = person.getTags();
        allTags.mergeFrom(personTags);

        // Create map with values = tag object references in the master list
        final Map<Tag, Tag> masterTagObjects = new HashMap<>();
        for (Tag tag : allTags) {
            masterTagObjects.put(tag, tag);
        }

        // Rebuild the list of person tags using references from the master list
        final Set<Tag> commonTagReferences = new HashSet<>();
        for (Tag tag : personTags) {
            commonTagReferences.add(masterTagObjects.get(tag));
        }
        person.setTags(new UniqueTagList(commonTagReferences));
    }

    /**
     * Adds a person to the address book.
     * Also checks the new person's tags and updates {@link #allTags} with any new tags found,
     * and updates the Tag objects in the person to point to those in {@link #allTags}.
     *
     * @throws DuplicatePersonException if an equivalent person already exists.
     */
    public void addPerson(Person toAdd) throws DuplicatePersonException {
        allPersons.add(toAdd);
        syncTagsWithMasterList(toAdd);
    }

    /**
     * Returns true if an equivalent person exists in the address book.
     */
    public Person editPerson(Person toEdit, String arg, int targetIndex) throws IllegalValueException {

            String[] splitArg = arg.split(" ");
            final Set<Tag> tagSet = new HashSet<>();
            for (int i = 0; i < splitArg.length; i++) {
                String prefix = splitArg[i].substring(0, 2);
                String newValue = splitArg[i].substring(2);
                switch (prefix) {
                    case ("n/"):
                      //  newValue = getToBeEditedName(newValue);
                        toEdit.setName(new Name(arg.substring(2)));
                        break;
                    case ("p/"):
                        toEdit.setPhone(new Phone(newValue, false));
                        break;
                    case ("e/"):
                        toEdit.setEmail(new Email(newValue, false));
                        break;
                    case ("a/"):
                        toEdit.setAddress(new Address(arg.substring(2), false));
                        break;
                    case ("t/"):
                        tagSet.add(new Tag(newValue));
                        if (i == splitArg.length - 1) {
                            toEdit.setTags(new UniqueTagList(tagSet));
                        }
                        break;
                }

            }
        allPersons.edit(toEdit,targetIndex-1);


        return toEdit;
    }

    /**
     * Return full string of the name to be changed
     */
    public String getToBeEditedName(String arg) {
        int indexEnd=arg.indexOf("/");
      //  String[] splitArg = arg.split(" ");
     //   StringBuilder stringBuilder=new StringBuilder();

//        for (int i = 0; i < splitArg.length; i++) {
//            String prefix = splitArg[i].substring(0, 2);
//            if (prefix.equals("/a") || prefix.equals("/p") || prefix.equals("/e") || prefix.equals("/t") ){
//                stringBuilder.append(splitArg[i-1]);
//                break;
//            }
//        }
        String editedName=arg.substring(0,indexEnd-2);
        return editedName;
    }

    /**
     * Returns true if an equivalent person exists in the address book.
     */
    public boolean containsPerson(ReadOnlyPerson key) {
        return allPersons.contains(key);
    }

    /**
     * Removes the equivalent person from the address book.
     *
     * @throws PersonNotFoundException if no such Person could be found.
     */
    public void removePerson(ReadOnlyPerson toRemove) throws PersonNotFoundException {
        allPersons.remove(toRemove);
    }

    /**
     * Clears all persons and tags from the address book.
     */
    public void clear() {
        allPersons.clear();
        allTags.clear();
    }

    /**
     * Returns a new UniquePersonList of all persons in the address book at the time of the call.
     */
    public UniquePersonList getAllPersons() {
        return new UniquePersonList(allPersons);
    }

    /**
     * Returns a new UniqueTagList of all tags in the address book at the time of the call.
     */
    public UniqueTagList getAllTags() {
        return new UniqueTagList(allTags);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && this.allPersons.equals(((AddressBook) other).allPersons)
                && this.allTags.equals(((AddressBook) other).allTags));
    }
}
