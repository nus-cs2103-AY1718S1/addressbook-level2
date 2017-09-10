package seedu.addressbook.data.person;

/**
 * Represents a Person's block in the address book.
 */
public class Block {

    public String block;

    public Block (String block) {
        this.block = block;
    }

    public final void setBlock(String block) {
        this.block = block;
    }

    @Override
    public String toString() { return "Block: " + block; }

}