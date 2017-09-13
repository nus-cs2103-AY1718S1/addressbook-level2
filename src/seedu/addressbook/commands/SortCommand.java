package seedu.addressbook.commands;

import seedu.addressbook.data.person.*;
import java.util.*;

/**
 * Created by Haozhe_Haotian on 13/9/17.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String NAME = " name";
    public static final String PHONE = " phone";
    public static final String EMAIL = " email";
    public static final String ADDRESS = " address";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": a person by different fields \n "
            + "Parameters: name, phone, email, or address (choose one only!)\n"
            + "Example: " + COMMAND_WORD
            + " address";

    private String _argument;

    public SortCommand(String argument){
        _argument = argument;
    }



    //following methods returns a sorted list of persons according to the type
    public List<Person> sort(String field){
        List<Person> totalList = addressBook.getAllPersons().getInternalList();

        for (int i = 1; i < totalList.size(); i++){ //bubblesort
            for (int k = 0; k < totalList.size() - i; k++){
                String kValue = this.sortBy(totalList.get(k), field);
                String k2Value = this.sortBy(totalList.get(k+1), field);
                if (kValue.compareToIgnoreCase(k2Value) > 0){
                    Person temp = totalList.get(k); //swap operation
                    totalList.set(k, totalList.get(k+1));
                    totalList.set(k+1, temp);
                }
            }
        }

        return totalList;

    }

    private String sortBy(Person dude, String sortField){
        switch(sortField){
            case NAME:
                return dude.getName().toString();
            case PHONE:
                return dude.getPhone().toString();
            case EMAIL:
                return dude.getEmail().toString();
            case ADDRESS:
                return dude.getAddress().toString();
            default:
                return dude.getName().toString();
        }
    }


    @Override
    public CommandResult execute() {
        List<Person> allPersons = this.sort(_argument);
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }



    public static List<Integer> suyashSort(ArrayList<Integer> totalList){

        for (int i = 1; i < totalList.size(); i++){ //bubblesort
            for (int k = 0; k < totalList.size() - i; k++){
                if (totalList.get(k).compareTo(totalList.get(k+1)) > 0){
                    Integer temp = totalList.get(k); //swap operation
                    totalList.set(k, totalList.get(k+1));
                    totalList.set(k+1, temp);
                }
            }
        }
        for (Integer i : totalList) {
            System.out.println(i);
        }
        return totalList;
    }

}

