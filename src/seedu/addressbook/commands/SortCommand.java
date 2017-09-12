package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.ArrayList;
import java.util.List;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + "Sort the persons by their name.\n";
    public static final String MESSAGE_SORT_PERSON_SUCCESS = "Sort command succeed";

    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().muatbleListView();

        for(int i=1;i<allPersons.size();i++){
            for (int j=0;j<allPersons.size()-i;j++){
                Person current= allPersons.get(j);
                Person next=allPersons.get(j+1);
                if(current.getName().fullName.compareTo(next.getName().fullName)==1){
                    allPersons.set(j,next);
                    allPersons.set(j+1,current);
                }

            }
        }
        return new CommandResult(MESSAGE_SORT_PERSON_SUCCESS+"\n"+getMessageForPersonListShownSummary(allPersons), allPersons);

    }
}
