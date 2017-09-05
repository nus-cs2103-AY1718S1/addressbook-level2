package seedu.addressbook.data.person;

public class Block extends AddressComponent{
    
    private final static String PARSE_BLOCK_FROM_ADDRESS_REGEX = "a/(.*?),.*$";
    
    public Block(String blockNumber) {
        super(blockNumber);
    }
    
    public static Block getFromAddress(String address) {
        Block re = new Block(extractValueFromAddress(address, PARSE_BLOCK_FROM_ADDRESS_REGEX));
        return re;
    } 
}
