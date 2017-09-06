package seedu.addressbook.data.person;


/**
 * Represents an Address' Block in the address book.
 * Guarantees: is an string.
 */

public class Block {
    private String blockNo;

    public Block(String blockNumber) {
        this.blockNo = blockNumber;
    }

    public String getBlock() {
        return blockNo;
    }


}
