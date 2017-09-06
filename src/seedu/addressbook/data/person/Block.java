package seedu.addressbook.data.person;

public class Block {
    String blockName;

    public Block(String block) {
        blockName = block;
    }

    String getBlockName() {
        return blockName;
    }

    void setBlockName(String block) {
        blockName = block;
    }
}