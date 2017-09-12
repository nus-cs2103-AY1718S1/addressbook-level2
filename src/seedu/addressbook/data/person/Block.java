package seedu.addressbook.data.person;

/**
 * Represents a Person's block in the address book.
 */

public class Block {

    public final String value;

    public Block (String block) {
        this.value = block.trim();
    }

    public String getBlock() {
        return this.value;
    }
}
