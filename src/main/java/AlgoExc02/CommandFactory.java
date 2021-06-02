package AlgoExc02;

import compare.*;
import data.CourseName;
import data.Student;
import lists.DoublyLinkedList;
import lists.Listable;
import lists.SinglyLinkedList;
import sort.InsertionSort;
import sort.QuickSort;
import sort.Sortable;
import search.Search;

import java.util.LinkedList;

import static AlgoExc02.App.buildCLIMenu;
import static AlgoExc02.App.selectCommand;

public class CommandFactory {


    private static Listable<Student> doublyLinkedListlist = new DoublyLinkedList<>();

    static public LinkedList<ICommand> returnsCommandList() {
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(singlyLinkedListlist());
        cmds.add(doublyLinkedListlist());

        return cmds;
    }
    private static Listable<Student> list;
    static public LinkedList<ICommand> returnsCommandListSLL() {
        list = new SinglyLinkedList<>();
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(addLast());
        cmds.add(insertAt());
        cmds.add(addFirst());
        cmds.add(appendsToEnd());
        cmds.add(returnStudentAt());
        cmds.add(printAll());
        cmds.add(size());
        cmds.add(removeAt());
        cmds.add(removeAll());
        cmds.add(searchFor());
        cmds.add(sortBy());

        return cmds;
    }

    static public LinkedList<ICommand> returnsCommandListDLL() {
        list = new DoublyLinkedList<>();
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(addLast());
        cmds.add(insertAt());
        cmds.add(addFirst());
        cmds.add(appendsToEnd());
        cmds.add(returnStudentAt());
        cmds.add(printAll());
        cmds.add(size());
        cmds.add(removeAt());
        cmds.add(removeAll());
        cmds.add(searchFor());
        cmds.add(sortBy());


        return cmds;
    }


    static public LinkedList<ICommand> returnsCommandListSearchBy() {
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(searchByPrename());
        cmds.add(searchBySurname());
        cmds.add(searchByCourseNumber());
        cmds.add(searchByMatriculationNumber());

        return cmds;
    }

    private static void sort(Listable<Student> list, Sortable<Student> algo, Comparator<Student> comp) {
        algo.sort(list, comp, 0, CommandFactory.list.size()-1);
    }

    static public LinkedList<ICommand> returnsCommandListSortMethod() {
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(insertionSort());
        cmds.add(quickSort());


        return cmds;
    }

    private static Sortable<Student> sortable;
    private static String SORTETWITH;
    static public LinkedList<ICommand> returnsCommandListInsertionSortBy() {
        sortable = new InsertionSort<>();
        SORTETWITH = "the list was sortet with insertion sort";
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(sortByCourseNumber());
        cmds.add(sortByMatriculationNumber());

        return cmds;
    }
    static public LinkedList<ICommand> returnsCommandListQuickSortBy() {
        sortable = new QuickSort<>();
        SORTETWITH = "the list was sortet with quicksort";
        LinkedList<ICommand> cmds = new LinkedList<ICommand>();
        cmds.add(createExitCommand());
        cmds.add(sortByCourseNumber());
        cmds.add(sortByMatriculationNumber());

        return cmds;
    }

    static public Student createStudent() {
        String prename = Console.readStringFromStdIn(" Please enter prename: ");
        String surname = Console.readStringFromStdIn(" Please enter surname: ");
        CourseName courseName = Console.readEnumFromStdIn(" Please enter a valid HTW Bachelor course name: ");
        int matriculationNumber = Console.readIntegerFromStdIn(" Please enter matriculation number: ");;
        return new Student(prename, surname, courseName, matriculationNumber);
    }

    private static int getIndexSizeAllowed() throws NullPointerException{
        boolean a = true;
        int index = 0;
        while(a) {
           index = Console.readIntegerFromStdIn(" Please enter index: ");
            if (index > list.size() || index < 0) {
                System.out.println("Index out of bounds, try again");
            } else {
                a = false;

            }
        }
        return index;
    }
    private static int getIndex() throws NullPointerException{
        boolean a = true;
        int index = 0;
        while(a) {
            index = Console.readIntegerFromStdIn(" Please enter index: ");
            if (index >= list.size() || index < 0) {
                System.out.println("Index out of bounds, try again");
            } else {
                a = false;
            }
        }
        return index;
    }

    private static ICommand singlyLinkedListlist() {
        return new ICommand() {

            @Override
            public String execute() {

                LinkedList<ICommand> commands = CommandFactory.returnsCommandListSLL();
                do {
                    System.out.println(buildCLIMenu(commands, "Console-Application: Exercise-2  \tLara Neubauer da Costa Schertel 575697\n" + "\nYou selected SinglyLinkedList:\n"));
                    ICommand selectedCMD = selectCommand(commands);
                    System.out.println(selectedCMD.execute());
                } while (true);

            }

            @Override
            public String description() {
                return " SinglyLinkedList";
            }
        };
    }

    private static ICommand doublyLinkedListlist() {
        return new ICommand() {

            @Override
            public String execute() {
                LinkedList<ICommand> commands = CommandFactory.returnsCommandListDLL();
                do {
                    System.out.println(buildCLIMenu(commands, "Console-Application: Exercise-2 \tLara Neubauer da Costa Schertel 575697\n" + "\nYou selected DoublyLinkedList:\n"));
                    ICommand selectedCMD = selectCommand(commands);
                    System.out.println(selectedCMD.execute());
                } while (true);

            }

            @Override
            public String description() {
                return " DoublyLinkedList";
            }
        };
    }
    private static ICommand addLast() {
        return new ICommand() {

            @Override
            public String execute() {
                Student student = createStudent();
                list.add(student);

                return System.lineSeparator()  + student + " was added to the end of this list" + System.lineSeparator();

            }

            @Override
            public String description() {
                return " Add Student to the end of this list";
            }
        };
    }

    private static ICommand insertAt() {
        return new ICommand() {

            @Override
            public String execute() {
                Student student = createStudent();
                int index = getIndexSizeAllowed();
                list.add(index, student);

                return System.lineSeparator() + student + " was added at the index: " + index + System.lineSeparator();

            }

            @Override
            public String description() {
                return " Inserts the Student at the specified position in this list.";
            }
        };
    }

    private static ICommand addFirst() {
        return new ICommand() {

            @Override
            public String execute() {
                Student student = createStudent();
                list.addFirst(student);

                return System.lineSeparator()  + student + " was added to the beginning of this list" + System.lineSeparator();
            }
            @Override
            public String description() {
                return " Inserts the Student at the beginning of this list.";
            }
        };
    }

    private static ICommand appendsToEnd() {
        return new ICommand() {

            @Override
            public String execute() {
                Student student = createStudent();
                list.addLast(student);

                return System.lineSeparator()  + student + " was added to the end of this list" + System.lineSeparator();

            }

            @Override
            public String description() {
                return " Appends the Student to the end of this list.";
            }
        };
    }
    private static ICommand returnStudentAt() {
        return new ICommand() {

            @Override
            public String execute() {

                int index = getIndex();
                return System.lineSeparator()  + list.get(index) + " was found at the position index: " + index + System.lineSeparator();
            }
            @Override
            public String description() {
                return " Returns the Student at the specified position in this list.";
            }
        };
    }

    private static ICommand printAll() {
        return new ICommand() {

            @Override
            public String execute() {
                if(list.size() == 0){
                    return System.lineSeparator() + "There are no students to print" + System.lineSeparator();
                }
                else {
                    list.printAll();
                    return System.lineSeparator();
                }
            }
            @Override
            public String description() {
                return " Print all students to console from list.";
            }
        };
    }
    private static ICommand size() {
        return new ICommand() {

            @Override
            public String execute() {

                return  System.lineSeparator() + "The number of students in this list is " + list.size() +System.lineSeparator();
            }
            @Override
            public String description() {
                return " Returns the number of Students in this list.";
            }
        };
    }
    private static ICommand removeAt() {
        return new ICommand() {

            @Override
            public String execute() {

                if (list.size() == 0) {
                    return System.lineSeparator() + "There are no students at the list to be removed" + System.lineSeparator();
                } else {
                    int index = getIndex();
                    list.remove(index);
                    return System.lineSeparator() + "The student at the position " + index + " was removed from the list " + System.lineSeparator();
                }
            }

            @Override
            public String description() {
                return " Removes the Student at the specified position in this list.";
            }
        };
    }
    private static ICommand removeAll() {
        return new ICommand() {

            @Override
            public String execute() {

                if (list.size() == 0) {
                    return System.lineSeparator() + "There are no students at the list to be removed" + System.lineSeparator();
                } else {
                    list.clear();
                    return System.lineSeparator() + "All students were removed from this list" + System.lineSeparator();
                }
            }
            @Override
            public String description() {
                return " Removes all of the Students from this list.";
            }
        };
    }
    private static ICommand searchFor() {
        return new ICommand() {

            @Override
            public String execute() {

                LinkedList<ICommand> commands = CommandFactory.returnsCommandListSearchBy();

                    System.out.println(buildCLIMenu(commands, "Select a property to search for the student:\n"));
                    ICommand selectedCMD = selectCommand(commands);
                    System.out.println(selectedCMD.execute());

                     return  System.lineSeparator();


            }

            @Override
            public String description() {
                return " Search for student(s) by different characteristics.";
            }
        };
    }

    private static ICommand searchByPrename() {
        return new ICommand() {

            @Override
            public String execute() {
                String prename = Console.readStringFromStdIn("Please enter prename for the search: ");
                Student student = new Student(prename, null, null, 0);
                Search<Student> searchable = new Search<>();
                int i = searchable.search(list, new PrenameComparator(), student);

                if (i == 0) {
                    return  " There is no student with the searched prename number on this list" + System.lineSeparator();
                } else if (i == 1) {
                    return " is the student that you are searching for" + System.lineSeparator();
                } else {
                    return " This " + i + " students were found that have the prename " + prename + System.lineSeparator();
                }
            }

            @Override
            public String description() {
                return " Search by prename?";
            }
        };
    }
    private static ICommand searchBySurname() {
        return new ICommand() {

            @Override
            public String execute() {

                String surname = Console.readStringFromStdIn(" Please enter surname for the search: ");
                Student student = new Student(null, surname, null, 0);
                Search<Student> searchable = new Search<>();
                int i = searchable.search(list, new SurnameComparator(), student);

                if (i == 0) {
                    return  " There is no student with the searched surname number on this list" + System.lineSeparator();
                } else if (i == 1) {
                    return " is the student that you are searching for" + System.lineSeparator();
                } else {
                    return " This " + i + " students were found that have the surname " + surname + System.lineSeparator();
                }
            }

            @Override
            public String description() {
                return " Search by surname?";
            }
        };
    }
    private static ICommand searchByCourseNumber() {
        return new ICommand() {

            @Override
            public String execute() {

                CourseName courseName = Console.readEnumFromStdIn("Please enter a course name for the search: ");
                Student student = new Student(null, null, courseName, 0);
                Search<Student> searchable = new Search<>();
                int i = searchable.search(list, new CourseComparator(), student);

                if (i == 0) {
                    return " There is no student with the searched course name on this list" + System.lineSeparator();
                }else if(i == 1){
                    return " is the student that you are searching for" + System.lineSeparator();
                }else {
                    return " This " +i  + " students were found that study " + courseName.name() + System.lineSeparator();
                }

            }

            @Override
            public String description() {
                return " Search by course?";
            }
        };
    }
    private static ICommand searchByMatriculationNumber() {
        return new ICommand() {

            @Override
            public String execute() {

                int matriculationNumber = Console.readIntegerFromStdIn(" Please enter a matriculation number for the search: ");
                Student student = new Student(null, null, null, matriculationNumber);
                Search<Student> searchable = new Search<>();
                int i = searchable.search(list, new MatriculationNumberComparator(), student);

                if (i == 0) {
                    return " There is no student with the searched matriculation number on this list" + System.lineSeparator();
                }else if(i == 1){
                    return " is the student that you are searching for" + System.lineSeparator();
                }else {
                    return " This " + i + " students were found with the matriculation number: " + matriculationNumber + System.lineSeparator();
                }

            }

            @Override
            public String description() {
                return " Search by matriculation number?";
            }
        };
    }
    private static ICommand sortBy() {
        return new ICommand() {

            @Override
            public String execute() {

                LinkedList<ICommand> commands = CommandFactory.returnsCommandListSortMethod();

                System.out.println(buildCLIMenu(commands, "Select a sorting method for sorting:\n"));
                ICommand selectedCMD = selectCommand(commands);
                System.out.println(selectedCMD.execute());

                return  System.lineSeparator();

            }

            @Override
            public String description() {
                return " Sort list by different properties.";
            }
        };
    }
    private static ICommand insertionSort() {
        return new ICommand() {
            @Override
            public String execute() {
                LinkedList<ICommand> commands = CommandFactory.returnsCommandListInsertionSortBy();

                System.out.println(buildCLIMenu(commands, "Please select a property for sorting with the 'Insertionsort' algorithm:\n"));
                ICommand selectedCMD = selectCommand(commands);
                System.out.println(selectedCMD.execute());

                return  System.lineSeparator();
            }

            @Override
            public String description() {
                return " Insertion sort?";
            }

        };
    }
    private static ICommand quickSort() {
        return new ICommand() {
            @Override
            public String execute() {

                LinkedList<ICommand> commands = CommandFactory.returnsCommandListQuickSortBy();

                System.out.println(buildCLIMenu(commands, "Please select a property for sorting with the 'Quicksort' algorithm:\n"));
                ICommand selectedCMD = selectCommand(commands);
                System.out.println(selectedCMD.execute());

                return  System.lineSeparator();
            }

            @Override
            public String description() {
                return " Quick sort?";
            }

        };
    }


    private static ICommand sortByCourseNumber() {
        return new ICommand() {
            @Override
            public String execute() {

                if(list.size() == 0){
                    return System.lineSeparator() + "The list is empty, the are no students to be sorted";
                }else {
                    sort(list, sortable, new CourseComparator());
                    return System.lineSeparator() + SORTETWITH;
                }
            }

            @Override
            public String description() {
                return " Sort by course?";
            }

        };
    }

    private static ICommand sortByMatriculationNumber() {
        return new ICommand() {
            @Override
            public String execute() {
                if(list.size() == 0){
                    return System.lineSeparator() + "The list is empty, the are no students to be sorted";
                }else {
                    sort(list, sortable, new MatriculationNumberComparator());
                    return System.lineSeparator() + SORTETWITH;

                }
            }

            @Override
            public String description() {
                return " Sort by matriculation number?";
            }

        };
    }
    private static ICommand createExitCommand() {
        return new ICommand() {
            @Override
            public String execute() {
                System.out.println("CLI program closed!");
                System.exit(0);
                return null;
            }

            @Override
            public String description() {
                return " Exit";
            }

        };
    }

}