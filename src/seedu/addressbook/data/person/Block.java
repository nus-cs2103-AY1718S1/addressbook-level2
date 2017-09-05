package seedu.addressbook.data.person;

/**
 * Block: part of the Address class
 */
public class Block extends AddressComponent{

    // Substring before the first comma or end of line
    private final static String PARSE_BLOCK_FROM_ADDRESS_REGEX = "^(.*?)(?:,|$)"; 
    
    public Block(String blockNumber) {
        super(blockNumber);
    }
    
    public static Block getFromAddress(String address) {
        Block re = new Block(extractValueFromAddress(address, PARSE_BLOCK_FROM_ADDRESS_REGEX));
        return re;
    } 
}
