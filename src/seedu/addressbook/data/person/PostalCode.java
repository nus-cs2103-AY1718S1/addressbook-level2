package seedu.addressbook.data.person;

public class PostalCode {
    private String myPostalCode;

    PostalCode (String inputPostalCode){
        myPostalCode=inputPostalCode;
    }

    public String getPostalCodeFromClass(){
        return myPostalCode;
    }

    public void editPostalCode(String newPostalCode){
        myPostalCode=newPostalCode;
    }

}
