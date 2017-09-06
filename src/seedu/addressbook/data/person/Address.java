package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 123456";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    public final String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String[] addressComponents = address.split(", ");

        this.isPrivate = isPrivate;
        for (int i = 0; i < addressComponents.length; i++) {
            if (i == 0) {
                this.block = new Block(addressComponents[0], isPrivate);
            }
            if (i == 1) {
                this.street = new Street(addressComponents[1], isPrivate);
            }
            if (i == 2) {
                this.unit = new Unit(addressComponents[2], isPrivate);
            }
            if (i == 3) {
                this.postalCode = new PostalCode(addressComponents[3], isPrivate);
            }
        }
        String addressString = new String();
        if (this.block != null) {
            addressString = this.block.toString();
        }
        if (this.street != null) {
            addressString = addressString.concat(", " + this.street.toString());
        }
        if (this.unit != null) {
            addressString = addressString.concat(", " + this.unit.toString());
        }
        if (this.postalCode != null) {
            addressString = addressString.concat(", " + this.postalCode.toString());
        }
        value = addressString;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
