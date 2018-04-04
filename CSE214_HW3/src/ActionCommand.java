
/**
 * MD NAFIUL AZIM
 * CSE_214_HOMEWORK-3
 * ID: 110548047
 *
 * @author nafi
 */
import java.util.ArrayList;

/**
 * This class creates the ActionCommands the user wants to perform. This class
 * contains two abstract methods- perform and getInverse which must be
 * implemented by the subclasses of this class.
 *
 * @author nafi
 */
public abstract class ActionCommand {

    private int positionOne, positionTwo;
    private String photo;
    final ActionType type;

    /**
     * The Constructor for the ActionCommand Type which creates instance of
     * ActionCommand type of object
     *
     * @param type - The type of Action, i.e: ADD, SWAP, MOVE. This is a
     * <code>Enum</code> type.
     * @param photo - The String representation of the specific reference photo
     * to which the action is performed. Depends on implementation, this field
     * maybe of greater use or none.
     */
    public ActionCommand(ActionType type, String photo) {

        this.type = type;
        this.photo = photo;
    }

    /**
     * One of the abstract methods in this class. We recommend that the
     * programmer who is using this class must implement this class in order to
     * perform any changes to the SlideShow, i.e: Add picture, Remove picture.
     *
     * @param slideShow - The ArrayList for the SlideShow to which the change is
     * applicable
     */
    public abstract void perform(ArrayList<String> slideShow);

    /**
     * One of the two abstract methods of this class. We recommend the user who
     * is using this ActionType Object must create a subclass representing the
     * opposite operation of a given ActionType. Then, implement the Method in a
     * way to return the inverse operation as ActionType object.
     */
    public abstract ActionCommand getInverse();

    /**
     * The getter method for positionOne field variable
     *
     * @return - the value stored in positionOne field variable
     */
    public int getPositionOne() {
        return positionOne;
    }

    /**
     * Setter for the position two variable
     *
     * @param positionOne - new positionOne value
     */
    public void setPositionOne(int positionOne) {
        this.positionOne = positionOne;
    }

    /**
     * Getter for positionTwo
     *
     * @return - Current value of the positionTwo variable
     */
    public int getPositionTwo() {
        return positionTwo;
    }

    /**
     * Setter for positionTwo field variable
     *
     * @param positionTwo - new value for position two
     */
    public void setPositionTwo(int positionTwo) {
        this.positionTwo = positionTwo;
    }

    /**
     * Getter for the photo relative to which the action is performed
     *
     * @return
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Setter for the photo relative to which the action will be performed
     *
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
