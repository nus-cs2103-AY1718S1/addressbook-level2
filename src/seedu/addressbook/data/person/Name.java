package seedu.addressbook.data.person;

import oracle.jrockit.jfr.StringConstantPool;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name implements Printable{

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if the given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    /**
     * getter for a printable String representation of this object
     * @return
     */
    public String getPrintableString() {
        return "Name: "+ toString();
    }

    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if they are the same after changing both to lowercase strings
     * and then change the orders if possible
     */
    public boolean isSimilar(Name other) {
        String[] nameStrings = fullName.split(" ");
        String[] othersNameStrings = other.fullName.split(" ");

        if (nameStrings.length != othersNameStrings.length) {
            return true;
        }

        ArrayList<String> nameLists = new ArrayList<>();
        ArrayList<String> othersNameLists = new ArrayList<>();

        for (String s: nameStrings) {
            nameLists.add(s.trim().toLowerCase());
        }
        for (String s: othersNameStrings) {
            othersNameLists.add(s.trim().toLowerCase());
        }

        for (int i = 0; i < nameLists.size(); i++){
            String testExistenceString = nameLists.get(i);
            boolean flag = false;
            for (int j = 0; j < othersNameLists.size(); j++){
                if (testExistenceString.equals(othersNameLists.get(j))){
                    flag = true;
                }
            }
            if (flag == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
