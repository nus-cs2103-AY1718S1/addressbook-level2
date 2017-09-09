package seedu.addressbook.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Returns true if any of the given items are null.
     */
    public static boolean isAnyNull(Object... items) {
        for (Object item : items) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if every element the given collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
            if (itemAlreadyExists) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts all strings in a collection to lowercase.
     *
     * @param toLowercase source collection
     * @return string collection with all lowercase elements
     */
    public static Collection<String> getLowercaseCollection(Collection<String> toLowercase) {
        return toLowercase.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
