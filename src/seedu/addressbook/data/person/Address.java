package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private  Block blockNumber = new Block();
    private  Street streetName = new Street();
    private Unit unitNumber = new Unit();
    private  PostalCode postalCode = new PostalCode();
    private final String fullAddress;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        final String[] splitAddress = trimmedAddress.split(",");
        if(splitAddress.length >= 1)
            blockNumber.setBlockNum(splitAddress[0].trim());
        if(splitAddress.length >= 2)
            streetName.setStreetName(splitAddress[1].trim());
        if(splitAddress.length >= 3)
            unitNumber.setUnitString(splitAddress[2].trim());
        if(splitAddress.length == 4)
        postalCode.setPostalCode(splitAddress[3].trim());

        fullAddress =  convertToString(blockNumber, streetName, unitNumber, postalCode);

    }

    private String convertToString(Block block, Street street, Unit unit, PostalCode pCode) {
        String address = "";

        if(!block.getBlockNum().equals("")) {
            address += block.getBlockNum();
        }
        if(!street.getStreetName().equals("")) {
           address += ", " + street.getStreetName();
        }
        if(!unit.getUnitString().equals("")) {
            address += ", " + unit.getUnitString();
        }
        if(!pCode.getPostalCode().equals("")) {
            address += ", " + pCode.getPostalCode();
        }

        return address;
    }


    public Block getBlock() {
        return blockNumber;
    }

    public Unit getUnit() {
        return unitNumber;
    }

    public Street getStreet() {
        return streetName;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public String getFullAddress() {return fullAddress;}

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullAddress;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.fullAddress.equals(((Address) other).fullAddress)); // state check
    }

    @Override
    public int hashCode() {
        return fullAddress.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block {
    String blockNumber;

    public Block() {
        blockNumber = "";
    }

    public void setBlockNum(String number) {
        blockNumber = number;
    }

    public String getBlockNum() {
        return blockNumber;
    }
}

class Street {
    private String streetName;

    public Street() {
        streetName = "";
    }

    public void setStreetName(String name) {
        streetName = name;
    }

    public String getStreetName() {
        return streetName;
    }
}

class Unit {
    private String unitString;

    public Unit() {
        unitString = "";
    }

    public void setUnitString(String unit) {
        unitString = unit;
    }

    public String getUnitString() {
        return unitString;
    }
}

class PostalCode {
    private String postalCode;

    public PostalCode() {
        postalCode = "";
    }

    public void setPostalCode(String postal) {
        postalCode = postal;
    }

    public String getPostalCode() {
        return postalCode;
    }
}

