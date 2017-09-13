package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */

/**
 * 2017/09/12 Updates:
 * ### Implement a class `[LO-ImplementClass]`

 ##### Side readings

 * [Code smell: Primitive Obsession](https://sourcemaking.com/refactoring/smells/primitive-obsession) -
 Using primitives instead of small objects for simple tasks

 ##### Exercise: Split `Address` into more classes

 * Assume the address is entered in the following format `a/BLOCK, STREET, UNIT, POSTAL_CODE` <br>
 e.g. `a/123, Clementi Ave 3, #12-34, 231534`
 * Split the `Address` class as follows.<br>
 <img src="images/AddressClasses.png" width='250'/>
 * Update the user guide and tests to match.
 *
 */

public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String CORRECT_FORMAT = "'a/BLOCK, STREET, UNIT, POSTAL_CODE'";
    public static final String CORRECT_INDIVIDUAL_FORMAT= "This element is not valid";
    //MESSAGE_ADDRESS_CONSTRAINTS should be paired with the corresponding format.
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "The address is entered in the following format ";
    public static final String ADDRESS_SPLIT_REGEX = ",";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    public final String block;
    public final String street;
    public final String unit;
    public final String postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        if(!isValidAddress(trimmedAddress, ADDRESS_SPLIT_REGEX)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS + CORRECT_FORMAT);
        } else {
            value = trimmedAddress;
            String[] trimmedAddressSet = value.split(ADDRESS_SPLIT_REGEX);
            if(trimmedAddressSet.length != 4) {
                throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS + CORRECT_FORMAT);
            }
            this.isPrivate = isPrivate;
            for(int i = 0; i < trimmedAddressSet.length; i++) {
                if (!isValidAddress(trimmedAddressSet[i], ADDRESS_VALIDATION_REGEX)) {
                    throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS + CORRECT_INDIVIDUAL_FORMAT);
                }
            }
            this.block = trimmedAddressSet[0];
            this.street = trimmedAddressSet[1];
            this.unit = trimmedAddressSet[2];
            this.postalCode = trimmedAddressSet[3];
        }
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test, String regex) {
        return test.matches(regex);
    }

    @Override
    public String toString()
    {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block) && this.street.equals(((Address) other).street) &&
                this.unit.equals(((Address) other).unit) && this.postalCode.equals(((Address) other).postalCode));
        // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
