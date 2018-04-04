
/**
 * MD NAFIUL AZIM
 * CSE_214_HOMEWORK-3
 * ID: 110548047
 *
 * @author nafi
 */
import java.util.ArrayList;

/**
 * This class has inheritance relation with the ActionCommand class. The job of
 * the class is to Remove photo from Slide Show
 *
 * @author nafi
 */
public class RemoveCommand extends ActionCommand {

    int position;

    /**
     * Creates instance of remove command
     *
     * @param type - type of the action which is always remove
     * @param photo - the photo to be removed
     * @param pos - the current position of the photo
     */
    public RemoveCommand(ActionType type, String photo, int pos) {
        super(type, photo);
        this.position = pos;

    }

    /**
     * Performs the actual remove.
     *
     * @param slideshow - The ArrayList representation of slideShow
     */
    @Override
    public void perform(ArrayList<String> slideshow) {

        if (position <= 0) {

            throw new IndexOutOfBoundsException("Invalid position!");
        } else {
            slideshow.remove(position);
            System.out.println(super.getPhoto() + " has been removed from position " + position);
        }
    }

    /**
     * Generates the inverse action command of remove which is add
     *
     * @return
     */
    @Override
    public ActionCommand getInverse() {
        AddCommand temp = new AddCommand(ActionType.ADD, this.getPhoto(), this.position);
        return temp;
    }

    /**
     * Getter for position field
     *
     * @return returns the current value of the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Setter for the position field
     *
     * @param position - new position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Describes the action command
     *
     * @return - String representation of the Action Command with type, photo,
     * and the position
     */
    @Override
    public String toString() {

        return this.type + " " + this.getPhoto() + " from position " + this.position;
    }

}
