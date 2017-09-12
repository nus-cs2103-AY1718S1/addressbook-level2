package seedu.addressbook.data.person;

public class Block {
    private String blockNo;
    final public static int BLOCK_VALUE_NO = 0;

    public Block(String blockNo){
        this.blockNo = blockNo;
    }

    public String getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(String blockNo) {
        this.blockNo = blockNo;
    }
}
