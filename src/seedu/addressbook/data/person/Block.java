package seedu.addressbook.data.person;

public class Block {
    private String block;
        public Block(String blockNum){
            this.block = blockNum;
        }
        public void setBlockNum(String blockNum) {
            this.block = blockNum;
        }
        public String getBlockNum() {
            return block;
        }

}

