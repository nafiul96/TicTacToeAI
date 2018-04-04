
/**
 * MD NAFIUL AZIM
 * CSE_214_HOMEWORK-3
 * ID: 110548047
 *
 * @author nafi
 */
import java.util.ArrayList;

/**
 * This class has an inheritance relation with ActionCommand abstract class and
 * implements all the abstract methods of the super class. The job of this class
 * is to move a photo in the slide from one place to another if possible
 *
 * @author nafi
 */
public class MoveCommand extends ActionCommand {

    private int source, destinition;

    /**
     * Creates an instance of the MoveCommand object
     *
     * @param type - type of the action. In this case MOVE
     * @param photo- the photo with respect to which the action will be
     * performed
     * @param pos1 - the source position
     * @param pos2 - the destination position
     */
    public MoveCommand(ActionType type, String photo, int pos1, int pos2) {
        super(type, photo);
        this.source = pos1;
        this.destinition = pos2;
    }

    /**
     * Overrides the super methods. It is implemented to move the source picture
     * to the desired position if possible. Otherwise it will throw exception
     *
     * @param slideShow
     */
    @Override
    public void perform(ArrayList<String> slideShow) {

        if ((source * destinition) <= 0 || (source > slideShow.size() || source < 0) || (destinition < 0 || destinition > slideShow.size())) {

            throw new IndexOutOfBoundsException("Invalid Position");
        } else {
            slideShow.add(destinition, slideShow.remove(source));
            System.out.println(" Move from Position " + this.source + " to Position " + this.destinition);
        }
    }

    /**
     * Generates the inverse the current move done to the photo
     *
     * @return the inverse of the move
     */
    @Override
    public ActionCommand getInverse() {

        return new MoveCommand(this.type, this.getPhoto(), this.destinition, this.source);
    }

    /**
     * Getter for the source position
     *
     * @return current value of source
     */
    public int getSource() {
        return source;
    }

    /**
     * Getter for the destinition
     *
     * @return current value of destinition
     */
    public int getDestinition() {
        return destinition;
    }

    /**
     * The description of the MOVE action
     *
     * @return The String representation of the type, source position, and
     * destination position of the current move
     */
    @Override
    public String toString() {

        return this.type + " Image " + " from " + this.source + " to " + this.destinition;
    }

}
