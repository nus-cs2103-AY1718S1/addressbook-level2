package seedu.addressbook.data.person;

/**
 * Represents a Person's unit number in the address book.
 */


public class Unit {

    private String unitNum;

    /**
     * Constructs a Unit using the given String
     * @param unitNum
     */
    public Unit(String unitNum){
        this.unitNum = unitNum;
    }

    /**
     * Sets the unit number of the Person's address
     * @param unitNum
     */
    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    /**
     *
     * @return Person's unit number
     */
    public String getUnitNum() {
        return unitNum;
    }
    
}
