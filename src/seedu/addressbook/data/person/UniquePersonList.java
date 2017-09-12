package seedu.addressbook.data.person;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.DuplicateDataException;



/**
 * A list of persons. Does not allow null elements or duplicates.
 *
 * @see Person#equals(Object)
 * @see Utils#elementsAreUnique(Collection)
 */
public class UniquePersonList implements Iterable<Person> {

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicatePersonException extends DuplicateDataException {
        protected DuplicatePersonException() {
            super("Operation would result in duplicate persons");
        }
    }

    /**
     * Signals that an operation targeting a specified person in the list would fail because
     * there is no such matching person in the list.
     */
    public static class PersonNotFoundException extends Exception {}

    private final List<Person> internalList = new ArrayList<>();

    private static final String COMMAND_SORT_PARAMETER_NAME = "name";
    private static final String COMMAND_SORT_PARAMETER_PHONE = "phone";
    private static final String COMMAND_SORT_PARAMETER_EMAIL = "email";

    /**
     * The first index of the address book. Is 0 if empty
     */
    private static final int SMALLEST_INDEX_OF_ADDRESSBOOK = 0;

    /**
     * Constructs empty person list.
     */
    public UniquePersonList() {}

    /**
     * Constructs a person list with the given persons.
     */
    public UniquePersonList(Person... persons) throws DuplicatePersonException {
        final List<Person> initialTags = Arrays.asList(persons);
        if (!Utils.elementsAreUnique(initialTags)) {
            throw new DuplicatePersonException();
        }
        internalList.addAll(initialTags);
    }

    /**
     * Constructs a list from the items in the given collection.
     * @param persons a collection of persons
     * @throws DuplicatePersonException if the {@code persons} contains duplicate persons
     */
    public UniquePersonList(Collection<Person> persons) throws DuplicatePersonException {
        if (!Utils.elementsAreUnique(persons)) {
            throw new DuplicatePersonException();
        }
        internalList.addAll(persons);
    }

    /**
     * Constructs a shallow copy of the list.
     */
    public UniquePersonList(UniquePersonList source) {
        internalList.addAll(source.internalList);
    }

    /**
     * Returns an unmodifiable java List view with elements cast as immutable {@link ReadOnlyPerson}s.
     * For use with other methods/libraries.
     * Any changes to the internal list/elements are immediately visible in the returned list.
     */
    public List<ReadOnlyPerson> immutableListView() {
        return Collections.unmodifiableList(internalList);
    }


    /**
     * Checks if the list contains an equivalent person as the given argument.
     * The {@link ReadOnlyPerson#isSamePerson} method is used for this comparison, which
     * defines a weaker notion of equality.
     */
    public boolean contains(ReadOnlyPerson toCheck) {
        for (Person p : internalList) {
            if (p.isSamePerson(toCheck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a person to the list.
     *
     * @throws DuplicatePersonException if the person to add is a duplicate of an existing person in the list.
     *    The @link{ReadOnlyPerson#isSamePerson} method is used for this comparison,
     *    which defines a weaker notion of equality.
     */
    public void add(Person toAdd) throws DuplicatePersonException {
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        internalList.add(toAdd);
    }

    /**
     * Removes the equivalent person from the list.
     *
     * @throws PersonNotFoundException if no such person could be found in the list.
     */
    public void remove(ReadOnlyPerson toRemove) throws PersonNotFoundException {
        final boolean personFoundAndDeleted = internalList.remove(toRemove);
        if (!personFoundAndDeleted) {
            throw new PersonNotFoundException();
        }
    }

    /**
     * Removes the equivalent person from the list.
     *
     * @throws PersonNotFoundException if no such person could be found in the list.
     */
    public void sort(String parameter) throws InvalidParameterException {
        switch (parameter) {
        case COMMAND_SORT_PARAMETER_NAME:
            quickSortByName(SMALLEST_INDEX_OF_ADDRESSBOOK, getLastIndexOfAddressBook());
        case COMMAND_SORT_PARAMETER_PHONE:
            quickSortByPhone(SMALLEST_INDEX_OF_ADDRESSBOOK, getLastIndexOfAddressBook());
        case COMMAND_SORT_PARAMETER_EMAIL:
            quickSortByEmail(SMALLEST_INDEX_OF_ADDRESSBOOK, getLastIndexOfAddressBook());
        default:
            throw new InvalidParameterException();
        }
    }

    private void quickSortByName(int min, int max) throws IndexOutOfBoundsException {
        if (internalList.size() == 0) {
            return;
        }
        if (min < 0 || min >= internalList.size()) {
            throw new IndexOutOfBoundsException("low is not within the range of the internalList");
        }
        if (max < 0 || max >= internalList.size()) {
            throw new IndexOutOfBoundsException("high is not within the range of the internalList");
        }
        int low = min;
        int high = max;
        String pivot = internalList.get(low + (high - low) / 2).getName().toString();
        while (low <= high) {
            while (internalList.get(low).getName().toString().compareTo(pivot) < 0) {
                low++;
            }
            while (internalList.get(high).getName().toString().compareTo(pivot) > 0) {
                high--;
            }
            if (low <= high) {
                swapPersonInArray(low, high);
                low++;
                high--;
            }
        }
        //Recursively call quickSortByName to finish sorting the ArrayList
        if (min < high) {
            quickSortByName(min, high);
        }
        if (low < max) {
            quickSortByName(low, max);
        }
    }

    private void quickSortByPhone(int min, int max) throws IndexOutOfBoundsException {
        if (internalList.size() == 0) {
            return;
        }
        if (min < 0 || min >= internalList.size()) {
            throw new IndexOutOfBoundsException("low is not within the range of the internalList");
        }
        if (max < 0 || max >= internalList.size()) {
            throw new IndexOutOfBoundsException("high is not within the range of the internalList");
        }
        int low = min;
        int high = max;
        String pivot = internalList.get(low + (high - low) / 2).getPhone().toString();
        while (low <= high) {
            while (internalList.get(low).getPhone().toString().compareTo(pivot) < 0) {
                low++;
            }
            while (internalList.get(high).getPhone().toString().compareTo(pivot) > 0) {
                high--;
            }
            if (low <= high) {
                swapPersonInArray(low, high);
                low++;
                high--;
            }
        }
        //Recursively call quickSortByEmail to finish sorting the ArrayList
        if (min < high) {
            quickSortByPhone(min, high);
        }
        if (low < max) {
            quickSortByPhone(low, max);
        }
    }

    private void quickSortByEmail(int min, int max) throws IndexOutOfBoundsException {
        if (internalList.size() == 0) {
            return;
        }
        if (min < 0 || min >= internalList.size()) {
            throw new IndexOutOfBoundsException("low is not within the range of the internalList");
        }
        if (max < 0 || max >= internalList.size()) {
            throw new IndexOutOfBoundsException("high is not within the range of the internalList");
        }
        int low = min;
        int high = max;
        String pivot = internalList.get(low + (high - low) / 2).getEmail().toString();
        while (low <= high) {
            while (internalList.get(low).getEmail().toString().compareTo(pivot) < 0) {
                low++;
            }
            while (internalList.get(high).getEmail().toString().compareTo(pivot) > 0) {
                high--;
            }
            if (low <= high) {
                swapPersonInArray(low, high);
                low++;
                high--;
            }
        }
        //Recursively call quickSortByEmail to finish sorting the ArrayList
        if (min < high) {
            quickSortByEmail(min, high);
        }
        if (low < max) {
            quickSortByEmail(low, max);
        }
    }

    /**
     * Swaps the position of 2 people in the internalList of people
     *
     * @param low The index of the first person
     * @param high The index of the second person
     */
    private void swapPersonInArray(int low, int high)
            throws IndexOutOfBoundsException {
        if (internalList.size() == 0) {
            return;
        }
        if (low < 0 || low >= internalList.size()) {
            throw new IndexOutOfBoundsException("low is not within the range of personArray");
        }
        if (high < 0 || high >= internalList.size()) {
            throw new IndexOutOfBoundsException("high is not within the range of personArray");
        }
        Person temp = internalList.get(low);
        internalList.set(low, internalList.get(high));
        internalList.set(high, temp);
    }

    /**
     * Gets the last index of the internalList
     */
    private int getLastIndexOfAddressBook() {
        return internalList.size() - 1;
    }

    /**
     * Clears all persons in list.
     */
    public void clear() {
        internalList.clear();
    }

    @Override
    public Iterator<Person> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniquePersonList // instanceof handles nulls
                        && this.internalList.equals(((UniquePersonList) other).internalList));
    }
}
