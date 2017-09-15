package seedu.addressbook.data.person;

public class Block {
    private String blockNum;
    public Block(String bNum) { this.blockNum = bNum;}

    public String getBlock() {
        return blockNum;
    }

    public void setBlock(String blockNumber) {
        this.blockNum = blockNum;
    }
}