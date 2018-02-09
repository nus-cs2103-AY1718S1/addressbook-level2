package seedu.addressbook.data.person.AddressConsists;

/**
 * Represents the block number in a person's address.
 */
public class Block {

    private String value;

    public Block(String blockNumber){
        this.value = blockNumber;
    }

    @Override
    public String toString(){
        return value;
    }
}
