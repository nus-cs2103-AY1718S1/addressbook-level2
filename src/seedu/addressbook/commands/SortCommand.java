package seedu.addressbook.commands;

import seedu.addressbook.data.exception.DuplicateDataException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand extends Command {
    private static String argument;
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = "Sorts all persons by a chosen criterion\n" +
                                                "Example: " + COMMAND_WORD + "name/phone/email";
    public static final String MESSAGE_EMPTY = "Addressbook is empty";
    public static final String MESSAGE_WRONG_ARGUMENT = "Wrong arguments";

    public SortCommand(String argument) {
        this.argument = argument;
    }

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> temp_allPersons = addressBook.getAllPersons().immutableListView();
        if (temp_allPersons.isEmpty()) return new CommandResult(MESSAGE_EMPTY);

        switch (argument) {
            case " name": {
                ArrayList<ReadOnlyPerson> allPersons = new ArrayList<>(temp_allPersons);

                Collections.sort(allPersons, new Comparator<ReadOnlyPerson>() {
                    @Override
                    public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                        return o1.getName().toString().compareToIgnoreCase(o2.getName().toString());
                    }
                });

                addressBook.clear();

                for (int i = 0; i < allPersons.size(); i++) {
                    try {
                        addressBook.addPerson(new Person(allPersons.get(i)));
                    }
                    catch (DuplicateDataException e) {
                        System.out.println("It wont happen anyway");
                    }
                }

                break;
            }
            case " phone": {
                ArrayList<ReadOnlyPerson> sortable = new ArrayList<>();
                ArrayList<ReadOnlyPerson> non_sortable = new ArrayList<>();

                for (int i = 0; i < temp_allPersons.size(); i++) {
                    if (temp_allPersons.get(i).getPhone().isPrivate()) non_sortable.add(temp_allPersons.get(i));
                    else sortable.add(temp_allPersons.get(i));
                }

                Collections.sort(non_sortable, new Comparator<ReadOnlyPerson>() {
                    @Override
                    public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                        return o1.getName().toString().compareToIgnoreCase(o2.getName().toString());
                    }
                });

                Collections.sort(sortable, new Comparator<ReadOnlyPerson>() {
                    @Override
                    public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                        return o1.getPhone().toString().compareToIgnoreCase(o2.getPhone().toString());
                    }
                });

                addressBook.clear();

                for (int i = 0; i < non_sortable.size(); i++) {
                    try {
                        addressBook.addPerson(new Person(non_sortable.get(i)));
                    }
                    catch (DuplicateDataException e) {
                        System.out.println("It wont happen anyway");
                    }
                }

                for (int i = 0; i < sortable.size(); i++) {
                    try {
                        addressBook.addPerson(new Person(sortable.get(i)));
                    }
                    catch (DuplicateDataException e) {
                        System.out.println("It wont happen anyway");
                    }
                }

                break;
            }
            case " email": {
                ArrayList<ReadOnlyPerson> sortable = new ArrayList<>();
                ArrayList<ReadOnlyPerson> non_sortable = new ArrayList<>();

                for (int i = 0; i < temp_allPersons.size(); i++) {
                    if (temp_allPersons.get(i).getEmail().isPrivate()) non_sortable.add(temp_allPersons.get(i));
                    else sortable.add(temp_allPersons.get(i));
                }

                Collections.sort(non_sortable, new Comparator<ReadOnlyPerson>() {
                    @Override
                    public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                        return o1.getName().toString().compareToIgnoreCase(o2.getName().toString());
                    }
                });

                Collections.sort(sortable, new Comparator<ReadOnlyPerson>() {
                    @Override
                    public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                        return o1.getEmail().toString().compareToIgnoreCase(o2.getEmail().toString());
                    }
                });

                addressBook.clear();

                for (int i = 0; i < non_sortable.size(); i++) {
                    try {
                        addressBook.addPerson(new Person(non_sortable.get(i)));
                    }
                    catch (DuplicateDataException e) {
                        System.out.println("It wont happen anyway");
                    }
                }

                for (int i = 0; i < sortable.size(); i++) {
                    try {
                        addressBook.addPerson(new Person(sortable.get(i)));
                    }
                    catch (DuplicateDataException e) {
                        System.out.println("It wont happen anyway");
                    }
                }

                break;
            }
            default:
                return new CommandResult(MESSAGE_WRONG_ARGUMENT);
        }

        temp_allPersons = addressBook.getAllPersons().immutableListView();
        if (argument.equals(" name")) return new CommandResult("Sorted by name", temp_allPersons);
        else return new CommandResult("Sorted by" + argument + ". Private" + argument + "s were placed in front and sorted by name", temp_allPersons);
    }
}
