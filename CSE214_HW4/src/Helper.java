
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */
/**
 * The Helpers of the Students whether it is the Professor himself of someone else
 *
 * @author Nafiul
 */
public class Helper {

    private int timeLeftTillFree;
    private final boolean isProfessor;
    private Student helping;

    /**
     * The Consturctor for the Helper
     *
     * @param isProfessor - Determines whether this is the professor or not
     */
    public Helper(boolean isProfessor) {

        this.isProfessor = isProfessor;
        timeLeftTillFree = 0;
    }

    /**
     * Getter for the time left till the helper will be free
     *
     * @return
     */
    public int getTimeLeftTillFree() {
        return timeLeftTillFree;
    }

    /**
     * Setter for the time left till free for the helper
     *
     * @param timeLeftTillFree - new value for time left till free
     */
    public void setTimeLeftTillFree(int timeLeftTillFree) {
        this.timeLeftTillFree = timeLeftTillFree;
    }

    /**
     * Determines whether this helper is the professor or not
     *
     * @return - true if the professor, otherwise, false
     */
    public boolean isIsProfessor() {
        return isProfessor;
    }

    /**
     * Setter for the student the helper is aiding right now
     *
     * @param temp - the student is being helped
     */
    public void setHelpingStudent(Student temp) {

        helping = temp;
        if (this.isProfessor) {
            this.timeLeftTillFree = temp.getTimeRequired();
        } else {

            this.timeLeftTillFree = temp.getTimeRequired() * 2;
        }
    }

    /**
     * Count down for the time left till the helper will be free
     */
    public void countDown() {

        System.out.println(" Helping Student " + this.helping.getStudentId() + ", Time Remaining: " + this.timeLeftTillFree--);
    }

    /**
     * checks whether the helper is free or not
     *
     * @return - if the helper is free then true, otherwise, false
     */
    public boolean isFree() {

        return this.timeLeftTillFree == 0;
    }

    /**
     * Static method to check whether all the helpers in an array are all free
     * or not
     *
     * @param help - the array of helpers
     * @return - true if all helpers are free, false, otherwise
     */
    public static boolean isCleared(Helper help[]) {

        boolean done = false;
        for (int i = 0; i < help.length; i++) {

            if (!help[i].isFree()) {

                done = false;
                break;
            }
            done = true;
        }
        return done;
    }
}
