
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */

/**
 * This class creates the instance of uniform probability of an event to take place, in this case the arrival
 * of the Students
 *
 * @author Nafiul
 */
public class BooleanSource {

    private double probability;

    /**
     * The constructor for the BooleanSoruce Object which creates this object
     * with initial probability
     *
     * @param initProbability - the Initial Probability
     * @throws IllegalArgumentException - This exception is thrown if the
     * probability is no within the range
     */
    public BooleanSource(double initProbability) throws IllegalArgumentException {

        if (initProbability < 0 || initProbability > 1) {

            throw new IllegalArgumentException(" Invalid Probability Input!");
        } else {

            this.probability = initProbability;
        }
    }

    /**
     * Determines whether the student has arrived or not
     *
     * @return - returns true if the probability is in the range, else false
     */
    public boolean occur() {

        return Math.random() <= probability;
    }

}
