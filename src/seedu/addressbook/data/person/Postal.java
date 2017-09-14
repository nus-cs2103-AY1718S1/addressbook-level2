package seedu.addressbook.data.person;

public class Postal {
    private String postalNum;
    public Postal(String postalNum) {
        this.postalNum = postalNum;
    }
    public String getPostalNum() {
        return postalNum;
    }
    public void setPostalNum(String postalNum) {
        this.postalNum = postalNum;
    }
}