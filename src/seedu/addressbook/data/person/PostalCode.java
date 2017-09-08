package seedu.addressbook.data.person;

public class PostalCode {

    private String postalCode;

    public PostalCode(String address){

        this.postalCode = address.trim();

    }
    public String getPostalcode(){

        return this.postalCode;
    }
}
