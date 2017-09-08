package seedu.addressbook.data.person;

/**
 * Represents the block number in a persons address
 */
public class Block {

    private final String blockNumber;

    public Block(String block) {
        blockNumber = block;
    }

    public String getBlockNumber() {
        return  blockNumber;
    }
}
