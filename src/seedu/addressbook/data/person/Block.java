package seedu.addressbook.data.person;

/**
 * Represents a Person's block number in the address book.
 */

public class Block {

    private String blockNum;

    /**
     * Constructs a Block using the given String
     * @param blockNum
     */
    public Block(String blockNum){
        this.blockNum = blockNum;
    }

    /**
     * Sets the block number of the Person's address
     * @param blockNum
     */
    public void setBlockNum(String blockNum) {
        this.blockNum = blockNum;
    }

    /**
     *
     * @return Person's block number
     */
    public String getBlockNum() {
        return blockNum;
    }

}
