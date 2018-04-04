
/**
 * MD NAFIUL AZIM
 * CSE_214_HOMEWORK-3
 * ID: 110548047
 *
 * @author nafi
 */
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * This is the Driver Class which contains the main Method. All the user inputs
 * are passed through this class, then executed and processed through Auxiliary
 * Classes to produce outcomes
 *
 * @author nafi
 */
public class SlideShowManager {

    private static Scanner input = new Scanner(System.in);
    private static UndoRedoStack undo = new UndoRedoStack();
    private static UndoRedoStack redo = new UndoRedoStack();
    private static ArrayList<String> slideshow;
    public static int maxIndex = 0;

    /**
     * The main Method
     *
     * @param args - just for Command Line running purpose
     */
    public static void main(String[] args) {

        slideshow = new ArrayList<>();
        slideshow.add("SlideShow \n ---------------------------------------------");
        menuDriver();

        System.out.println("Thank you, and Good Bye!");
    }

    /**
     * Prints out the menu list
     */
    public static void mainMenu() {

        System.out.println("Main Menu:");
        System.out.print("A) Add Photo,");
        System.out.print("R) Remove Photo,");
        System.out.print("S) Swap Photos,");
        System.out.print("M) Move Photo,");
        System.out.print("P) Print,");
        System.out.print("Z)Undo,");
        System.out.print("Y)Redo,");
        System.out.print("Q)Quit \n");
    }

    /**
     * Drives and processes the Menu by using different user input.
     */
    public static void menuDriver() {

        boolean done = false;
        String s = "";
        int id = 0;
        int spot = 0;
        while (!done) {

            mainMenu();
            System.out.println("Select an option:");
            s = (input.next()).toLowerCase();
            input.nextLine();
            switch (s) {

                case "a":
                    addPhoto();
                    break;
                case "r":
                    removePhoto();
                    break;
                case "s":
                    swapPhotos();
                    break;
                case "m":
                    movePhoto();
                    break;
                case "z":
                    undoAct();
                    break;
                case "y":
                    redoAct();
                    break;
                case "p":
                    print();
                    System.out.println();
                    System.out.println("Undo Stack: \n --------------------------");
                    undo.printStack();
                    System.out.println();
                    System.out.println("Redo Stack: \n --------------------------");
                    redo.printStack();
                    System.out.println();
                    break;
                case "q":
                    done = true;
                    System.out.println("Thank you for using this Menu App");
                    break;
                default:
                    System.out.println("Not an Option. Try Again");

            }
        }
    }

    /**
     * Adds photo to the SlideShow when it is legal, otherwise prints out error
     * message to the user. redo Stack is cleared each time.
     */
    public static void addPhoto() {
        try {
            System.out.print("The Photo Name: ");
            String photo = input.nextLine();
            System.out.println("Position: ");
            int pos = input.nextInt();
            input.nextLine();
            ActionCommand add = new AddCommand(ActionType.ADD, photo, pos);
            add.perform(slideshow);
            undo.push(add);
            redo.removeAllElements();
        } catch (IndexOutOfBoundsException e) {

            System.err.println("Can't add here");
        } catch (Exception e) {

            System.err.println("Inlvaid input!");
        }

    }

    /**
     * Removes Photo from SlideShow when the position is legal, otherwise prints
     * error message to the user. redo Stack is cleared each time
     */
    public static void removePhoto() {

        try {
            System.out.println("Please enter the position: ");
            int pos = input.nextInt();
            String removed = slideshow.get(pos);
            ActionCommand act = (ActionCommand) new RemoveCommand(ActionType.REMOVE, removed, pos);
            act.perform(slideshow);
            undo.push(act);
            redo.removeAllElements();
        } catch (IndexOutOfBoundsException ex) {

            System.err.println("Wrong Position!");
        } catch (Exception e) {

            System.err.println("Invalid input!");
        }
    }

    /**
     * Switches the position of two photos when it is legal, otherwise prints
     * error message to the reader redo stack is cleared each time
     */
    public static void swapPhotos() {
        try {
            System.out.println("Please enter the source position: ");
            int src = input.nextInt();
            System.out.println("Please enter the destinition position: ");
            int dest = input.nextInt();
            ActionCommand temp = new SwapCommand(ActionType.SWAP, slideshow.get(src), src, dest);
            temp.perform(slideshow);
            undo.push(temp);
            redo.removeAllElements();
        } catch (IndexOutOfBoundsException e) {

            System.err.println("Invalid choice of position. Such position combination does not exist");
        } catch (Exception e) {

            System.err.println("Invalid input");
        }
    }

    /**
     * Moves a photo from one place to another when a valid input is provided,
     * otherwise prints out error message redo Stack is cleared each time
     */
    public static void movePhoto() {

        try {
            System.out.println("Please enter the source position: ");
            int source = input.nextInt();
            System.out.print("Please enter the destinition position: ");
            int dest = input.nextInt();
            input.nextLine();
            ActionCommand move = new MoveCommand(ActionType.MOVE, slideshow.get(source), source, dest);
            move.perform(slideshow);
            undo.push(move);
            redo.removeAllElements();
        } catch (IndexOutOfBoundsException e) {

            System.err.println("Invalid position");
        } catch (Exception e) {

            System.err.println("Invalid Input!");
        }

    }

    /**
     * Undo an action by calculating the inverse of the peek of the undo stack
     * and pushing the pop of undo stack to redo stack
     */
    public static void undoAct() {
        try {
            ActionCommand temp = undo.peek().getInverse();
            redo.push(undo.pop());
            temp.perform(slideshow);
        } catch (EmptyStackException ex) {

            System.err.println("Nothing here to do!");
        } catch (Exception ex) {
            System.err.println("Error!!!");
        }

    }

    /**
     * Redo an action by picking from the top of the redo stack and later on pop
     * the action from the redo stack and push into the undo stack. Warning:
     * This Stack is cleared once the User perform a new Action excepts for
     * another undo or another redo.
     */
    public static void redoAct() {
        try {
            ActionCommand temp = redo.peek();
            undo.push(redo.pop());
            temp.perform(slideshow);
        } catch (EmptyStackException e) {

        } catch (Exception ex) {

        }

    }

    /**
     * Prints out the Slide Show
     */
    public static void print() {

        System.out.println("Slide Show: ");
        for (int i = 0; i < slideshow.size(); i++) {

            if (slideshow.get(i) != null) {
                if (i > 0) {
                    System.out.println(i + ". " + slideshow.get(i));
                } else {

                    System.out.println(slideshow.get(i));
                }
            }
        }
    }

}
