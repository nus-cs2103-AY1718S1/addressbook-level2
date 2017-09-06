package seedu.addressbook.data.person;

public class Block {
    private String myBlock;

    Block (String inputBlock){
        myBlock=inputBlock;
    }

    public String getBlockFromClass(){
        return myBlock;
    }

    public void editBlock(String newBlock){
        myBlock=newBlock;
    }

}
