package seedu.addressbook.data.person;

public class Block {

    private String value;

    public Block (String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
