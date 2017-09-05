package seedu.addressbook.data.person;

public class Block{
    public final String value;

    /**
     * Validates given address.
     */
    public Block(String block) {

        this.value = block;
    }

    public String getBlock(){
        return this.value;
    }

}
