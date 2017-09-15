package seedu.addressbook.data.affiliation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.DuplicateDataException;

/**
 * A list of affiliations. Does not allow nulls or duplicates.
 *
 * @see Affiliation#equals(Object)
 * @see Utils#elementsAreUnique(Collection)
 */

public class UniqueAffiliationList implements Iterable<Affiliation>{

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicateAffiliationException extends DuplicateDataException {
        protected DuplicateAffiliationException() {
            super("Operation would result in duplicate affiliations.");
        }
    }

    private final List<Affiliation> internalList = new ArrayList<>();

    /**
     * Constructs an empty AffiliationList.
     */
    public UniqueAffiliationList() {}

    /**
     * Constructs a affiliations list with the given affiliations.
     */
    public UniqueAffiliationList(Affiliation... affiliations) throws DuplicateAffiliationException {
        final List<Affiliation> initialAffiliations = Arrays.asList(affiliations);
        if (!Utils.elementsAreUnique(initialAffiliations)) {
            throw new DuplicateAffiliationException();
        }
        internalList.addAll(initialAffiliations);
    }

    /**
     * Constructs a affiliations list with the given affiliations.
     */
    public UniqueAffiliationList(Collection<Affiliation> affiliations) throws DuplicateAffiliationException {
        if (!Utils.elementsAreUnique(affiliations)) {
            throw new DuplicateAffiliationException();
        }
        internalList.addAll(affiliations);
    }

    /**
     * Constructs a affiliations list with the given affiliations.
     */
    public UniqueAffiliationList(Set<Affiliation> affiliations) {
        internalList.addAll(affiliations);
    }

    /**
     * Constructs a shallow copy of the given affiliations list.
     */
    public UniqueAffiliationList(UniqueAffiliationList source) {
        internalList.addAll(source.internalList);
    }

    /**
     * Returns a new Set that is a deep copy of all affiliations in this list.
     * This set is mutable and change-insulated against the internal list.
     */
    public Set<Affiliation> toSet() {
        return new HashSet<>(internalList);
    }


    /**
     * Returns true if the list contains an equivalent affiliation as the given argument.
     */
    public boolean contains(Affiliation toCheck) {
        return internalList.contains(toCheck);
    }

    /**
     * Adds all the given affiliations to this list.
     *
     * @throws DuplicateAffiliationException if the argument affiliations list contains affiliation(s) that already exist in this list.
     */
    public void addAll(UniqueAffiliationList affiliations) throws DuplicateAffiliationException {
        if (!Collections.disjoint(this.internalList, affiliations.internalList)) {
            throw new DuplicateAffiliationException();
        }
        this.internalList.addAll(affiliations.internalList);
    }

    /**
     * Adds every affiliation from the argument list that does not yet exist in this list.
     */
    public void mergeFrom(UniqueAffiliationList affiliations) {
        final Set<Affiliation> alreadyInside = this.toSet();
        for (Affiliation affiliation : affiliations) {
            if (!alreadyInside.contains(affiliation)) {
                internalList.add(affiliation);
            }
        }
    }

    /**
     * Clears all affiliations in list.
     */
    public void clear() {
        internalList.clear();
    }

    /**
     * Replaces the Tags in this list with those in the argument tag list.
     */
    public void setAffiliations(UniqueAffiliationList replacement) {
        this.internalList.clear();
        this.internalList.addAll(replacement.internalList);
    }

    @Override
    public Iterator<Affiliation> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueAffiliationList // instanceof handles nulls
                && this.internalList.equals(((UniqueAffiliationList) other).internalList));
    }



}
