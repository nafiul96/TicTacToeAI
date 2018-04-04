
/**
 * MD NAFIUL AZIM
 * CSE_214_HOMEWORK-3
 * ID: 110548047
 *
 * @author nafi
 */
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * This class inherits from the Stack class in the java API. The job of this
 * class is to keep track of actions the user performs as Stack Data Structure
 *
 * @author nafi
 */
public class UndoRedoStack extends Stack {

    /**
     * Default constructor for the UndoRedo Stack which essentially calls for
     * the super class's Stack
     */
    public UndoRedoStack() {

        super();
    }

    /**
     * Appneds the new item to the top of the Stack
     *
     * @param a - the Action to put in
     */
    public void push(ActionCommand a) {

        super.push(a);
    }

    /**
     * Removes the Action from top of the Stack
     *
     * @return - The Action that is removed
     * @throws EmptyStackException - Assures that we are not removing anything
     * when the Stack is empty
     */
    public ActionCommand pop() throws EmptyStackException {

        if (this.isEmpty()) {

            throw new EmptyStackException();
        } else {

            return (ActionCommand) super.pop();
        }

    }

    /**
     * Getter for the top item of the Stack
     *
     * @return - the Action at the top of the Stack
     * @throws EmptyStackException - Assures that we are not accessing the top
     * while the Stack is empty
     */
    public ActionCommand peek() throws EmptyStackException {

        if (this.isEmpty()) {

            throw new EmptyStackException();
        } else {

            return (ActionCommand) super.peek();
        }
    }

    /**
     * checks to see if the Stack is empty or not.
     *
     * @return - True for the empty case, false otherwise.
     */
    public boolean isEmpty() {

        return super.isEmpty();
    }

    /**
     * Prints the Stack
     */
    public void printStack() {

        UndoRedoStack temp = new UndoRedoStack();
        //System.out.println("here");
        ActionCommand c;
        while (!this.isEmpty()) {

            c = (ActionCommand) this.pop();
            temp.push(c);
            System.out.println(c);
        }

        while (!temp.isEmpty()) {

            this.push((ActionCommand) temp.pop());
        }
    }

}
