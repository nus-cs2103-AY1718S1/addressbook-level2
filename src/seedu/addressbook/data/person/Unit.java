package seedu.addressbook.data.person;

public class Unit {
    private String myUnit;

    Unit (String inputUnit){
        myUnit=inputUnit;
    }

    public String getUnitFromClass(){
        return myUnit;
    }

    public void editUnit(String newUnit){
        myUnit=newUnit;
    }

}
