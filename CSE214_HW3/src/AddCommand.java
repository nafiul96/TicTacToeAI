
/**
 * MD NAFIUL AZIM
 * CSE_214_HOMEWORK-3
 * ID: 110548047
 *
 * @author nafi
 */
import java.util.ArrayList;

/**
 * This class inherits from ActionCommand abstract class and implements all the
 * abstract methods as recommended in the documentation. The job of this class
 * is to Add a photo to the SlideShow
 *
 * @author nafi
 */
public class AddCommand extends ActionCommand {

    int position;

    /**
     * The Constructor for the AddCommand
     *
     * @param type - holds the type of the command which in this case add.
     * @param photo - The photo to be added
     * @param pos - the position where photo will be added
     */
    public AddCommand(ActionType type, String photo, int pos) {
        super(type, photo);
        this.position = pos;
    }

    /**
     * This method was inherited from ActionCommand and implemented here. This
     * will perform the actual add action
     *
     * @param slideshow - The ArrayList representation of the Slideshow to which
     * the add will be performed
     */
    @Override
    public void perform(ArrayList<String> slideshow) {

        if (position <= 0) {

            throw new IndexOutOfBoundsException();
        } else {
            slideshow.add(position, this.getPhoto());
            System.out.println(this.getPhoto() + " is added to position " + this.position);
        }
    }

    /**
     * This method is inherited from ActionCommand and is used to generate the
     * inverse of ADD, which is REMOVE action
     *
     * @return - the inverse action of the current action type
     */
    @Override
    public ActionCommand getInverse() {

        RemoveCommand temp = new RemoveCommand(ActionType.MOVE, this.getPhoto(), this.position);
        return temp;
    }

    /**
     * Getter for the position field
     *
     * @return current value of position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Setter for the position field
     *
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Provides the user with the description of the action
     *
     * @return The String representation of the Action with it's type, the
     * photo, and the position
     */
    @Override
    public String toString() {

        return this.type + " " + this.getPhoto() + " to position " + this.position;
    }

}
