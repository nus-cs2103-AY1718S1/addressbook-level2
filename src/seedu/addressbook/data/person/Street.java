package seedu.addressbook.data.person;

public class Street {
    private String street;

    public Street (String fullAddress) {
        street = SplitAddressByComma.splitAddress(fullAddress)[1];
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return getStreet();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Street) {
            Street toBeCompared = (Street) obj;
            return this.getStreet().equals(toBeCompared.getStreet());
        }
        return false;
    }
}
