package seedu.addressbook.data.person;

public class PostalCode {
    private String code;

    public PostalCode(String code){
        this.code = code;
    }

    public void setCode(String newCode){
        this.code = newCode;
    }

    public String getCode(){
        return this.code;
    }
}
