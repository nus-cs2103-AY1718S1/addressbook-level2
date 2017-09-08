package seedu.addressbook.data.person;

public class Block {

    private String blockNumber;

    public Block(String address){

        this.blockNumber = address.trim();

    }
    public String getBlock(){

        return this.blockNumber;
    }
}
