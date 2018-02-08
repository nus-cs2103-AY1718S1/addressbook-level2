package seedu.addressbook.data.person;

/**
 * Represents the block of a person's address.
 */
public class Block {
    private static String block;

    public Block (String block) {
        this.block = block;
    }

    public String getBlock() {
        return block;
    }
    public void setBlock(String block) {
        this.block = block;
    }
}
