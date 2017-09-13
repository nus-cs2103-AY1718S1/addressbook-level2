package seedu.addressbook.data.person;

public class SubAddress {
    private String subAddress;
    public SubAddress(String office){
        this.subAddress = office;
    }
    public void setSubAddress(String office) {
        this.subAddress = office;
    }
    public String getSubAddress() {
        return subAddress;
    }
}
