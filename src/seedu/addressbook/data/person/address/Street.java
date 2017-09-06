package seedu.addressbook.data.person.address;

public class Street {
    public final String streetName;

    public Street(String streetName){
        this.streetName = streetName;
    }

    public String getStreetName() {
        return this.streetName;
    }
}
