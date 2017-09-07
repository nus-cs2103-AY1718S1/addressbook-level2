package seedu.addressbook.data.person;

public class Block {
    private String blockNumber;

    public Block(String value) {
        this.blockNumber = value;
    }

    public void setBlockNumber(String value) {
        this.blockNumber = value;
    }

    public String getBlockNumber() {
        return this.blockNumber;
    }
}
