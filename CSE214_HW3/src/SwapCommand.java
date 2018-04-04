
/**
 * MD NAFIUL AZIM
 * CSE_214_HOMEWORK-3
 * ID: 110548047
 *
 * @author nafi
 */
import java.util.ArrayList;

/**
 * This class has inheritance relation with the abstract class ActionCommand.
 * Upon implementing all the abstract methods of its parent class, this class
 * performs the swap of two positions
 *
 * @author nafi
 */
public class SwapCommand extends ActionCommand {

    int source, destinition;

    /**
     * Creates an instance of the swap command
     *
     * @param type - the type of action which is swap
     * @param photo- picture respect to which the swap is done. It is
     * unnecessary but is done due to requirement
     * @param src - the source position
     * @param dst - The destination position
     */
    public SwapCommand(ActionType type, String photo, int src, int dst) {

        super(type, photo);
        this.source = src;
        this.destinition = dst;

    }

    /**
     * Performs the swap and applies to the slideshow
     *
     * @param slideShow - the slideshow
     */
    public void perform(ArrayList<String> slideShow) {

        if ((source * destinition) <= 0 || (source > slideShow.size() || source < 0) || (destinition < 0 || destinition > slideShow.size())) {

            throw new IndexOutOfBoundsException("Invalid position");
        } else {
            String sourcePhoto = slideShow.get(source);
            String destPhoto = slideShow.get(destinition);
            slideShow.set(source, destPhoto);
            slideShow.set(destinition, sourcePhoto);
            System.out.println("Position " + source + " & Position " + destinition + " are swapepd");
        }
    }

    /**
     * Generates the inverse of the current swap
     *
     * @return
     */
    @Override
    public ActionCommand getInverse() {

        return new SwapCommand(this.type, this.getPhoto(), source, destinition);
    }

    /**
     * Describes the action
     *
     * @return - String representation of action type, the source position, and
     * the destination position
     */
    public String toString() {

        return this.type + " position " + this.source + " and position " + this.destinition;
    }

}
