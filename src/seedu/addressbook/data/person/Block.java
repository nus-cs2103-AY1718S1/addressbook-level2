package seedu.addressbook.data.person;

/**
 * Object to keep Block value of Address
 */
public class Block {
    private String _block;

    /**
     * Constructor
     *
     * @param block
     */
    public Block(String block) {
        _block = block;
    }

    /*Getter and Setters*/
    public String getBlock() {
        return _block;
    }
    public void setBlock(String newBlock) {
        _block = newBlock;
    }
}
