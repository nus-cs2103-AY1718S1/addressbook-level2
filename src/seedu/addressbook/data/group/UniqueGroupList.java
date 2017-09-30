package seedu.addressbook.data.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.DuplicateDataException;


public class UniqueGroupList implements Iterable<Group>{
    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicateGroupException extends DuplicateDataException {
        protected DuplicateGroupException() {
            super("Operation would result in duplicate groups");
        }
    }

    /**
     * Signals that an operation targeting a specified group in the list would fail because
     * there is no such matching group in the list.
     */
    public static class GroupNotFoundException extends Exception {}

    private final List<Group> internalList = new ArrayList<>();

    /**
     * Constructs empty person list.
     */
    public UniqueGroupList() {}

    /**
     * Constructs a group list with the given groups.
     */
    public UniqueGroupList(Group... groups) throws UniqueGroupList.DuplicateGroupException {
        final List<Group> initialTags = Arrays.asList(groups);
        if (!Utils.elementsAreUnique(initialTags)) {
            throw new UniqueGroupList.DuplicateGroupException();
        }
        internalList.addAll(initialTags);
    }

    /**
     * Constructs a list from the items in the given collection.
     * @param groups a collection of groups
     * @throws UniqueGroupList.DuplicateGroupException if the {@code groups} contains duplicate groups
     */
    public UniqueGroupList(Collection<Group> groups) throws UniqueGroupList.DuplicateGroupException {
        if (!Utils.elementsAreUnique(groups)) {
            throw new UniqueGroupList.DuplicateGroupException();
        }
        internalList.addAll(groups);
    }

    /**
     * Constructs a shallow copy of the list.
     */
    public UniqueGroupList(UniqueGroupList source) {
        internalList.addAll(source.internalList);
    }

    /**
     * Checks if the list contains an equivalent groups as the given argument.
     * The {@link Group#isSameGroup} method is used for this comparison, which
     * defines a weaker notion of equality.
     */
    public boolean contains(Group toCheck) {
        for (Group E : internalList) {
            if (E.isSameGroup(toCheck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a group to the list.
     *
     * @throws UniqueGroupList.DuplicateGroupException if the group to add is a duplicate of an existing group in the list.
     *    The {@link Group#isSameGroup} method is used for this comparison,
     *    which defines a weaker notion of equality.
     */
    public void add(Group toAdd) throws UniqueGroupList.DuplicateGroupException {
        if (contains(toAdd)) {
            throw new UniqueGroupList.DuplicateGroupException();
        }
        internalList.add(toAdd);
    }

    /**
     * Returns an unmodifiable java List view with elements cast as immutable {@link Group}s.
     * For use with other methods/libraries.
     * Any changes to the internal list/elements are immediately visible in the returned list.
     */
    public List<Group> immutableListView() {
        return Collections.unmodifiableList(internalList);
    }

    /**
     * Removes the equivalent group from the list.
     *
     * @throws UniqueGroupList.GroupNotFoundException if no such group could be found in the list.
     */
    public void remove(Group toRemove) throws UniqueGroupList.GroupNotFoundException {
        final boolean groupFoundAndDeleted = internalList.remove(toRemove);
        if (!groupFoundAndDeleted) {
            throw new UniqueGroupList.GroupNotFoundException();
        }
    }

    /**
     * Clears all groups in list.
     */
    public void clear() {
        internalList.clear();
    }

    @Override
    public Iterator<Group> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueGroupList // instanceof handles nulls
                && this.internalList.equals(((UniqueGroupList) other).internalList));
    }
}
