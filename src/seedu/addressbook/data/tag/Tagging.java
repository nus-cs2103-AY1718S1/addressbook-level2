package seedu.addressbook.data.tag;

public class Tagging {

    private String operation;
    private String name;
    private String tag;

    public Tagging(String operation, String name, String tag){
        this.operation=operation;
        this.name=name;
        this.tag=tag;
    }

    @Override
    public String toString(){
        return operation+" "+name+"["+tag+"]";
    }
}
