package seedu.addressbook.data.person;

/**
 * Created by Philemon1 on 5/9/2017.
 */
public class Block {
    private String block;

    public Block(String inputBlock){
        block = inputBlock;
    }
    public void editBlock(String inputBlock){
        block = inputBlock;
    }
    public String getBlock(){
        return block;
    }
}
