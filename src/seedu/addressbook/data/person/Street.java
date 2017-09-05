package seedu.addressbook.data.person;

public class Street {

    private String streetName;

    public Street(String streetName){
        this.streetName = streetName;
    }

    public void setStreetName(String streeName) {
        this.streetName = streeName;
    }

    public String getStreetName() {
        return streetName;
    }
}
