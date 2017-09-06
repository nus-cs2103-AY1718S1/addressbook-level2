package seedu.addressbook.data.person;

public class Block {
    private String block;

    public Block (String fullAddress) {
        block = SplitAddressByComma.splitAddress(fullAddress)[0];
    }

    public String getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return getBlock();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Block) {
            Block toBeCompared = (Block) obj;
            return this.getBlock().equals(toBeCompared.getBlock());
        }
        return false;
    }
}
