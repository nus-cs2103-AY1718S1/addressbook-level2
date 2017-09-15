package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

public class Block {
    private String block;

    public Block(String block){
        this.block = block;
    }

    public String getBlock() {
        return block;
    }
}
