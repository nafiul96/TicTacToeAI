
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */
/**
 * Creates Course Object with courseName,difficulty,arrivalprobability
 *
 * @author Nafiul
 */
public class Course {

    private int courseNum;
    private int courseDifficulty;
    private double arrivalProbabilty;
    private int studentArrived;
    private int latency;

    /**
     * Constructor for the Course Object
     *
     * @param courseNum - name of the course
     * @param arrivalProbabilty - arrival probability of students
     * @throws IllegalArgumentException - this assures that the courseNumber is
     * actually existed in the file and is not negative or equal to zero
     */
    public Course(int courseNum, double arrivalProbabilty) throws IllegalArgumentException {

        if (courseNum <= 0) {

            throw new IllegalArgumentException();
        } else {

            this.courseNum = courseNum;
            this.arrivalProbabilty = arrivalProbabilty;
            //System.out.println("Course created successfully");
        }
    }

    /**
     * Getter for courseNumber
     *
     * @return - the courseNumber
     */
    public int getCourseNum() {
        return courseNum;
    }

    /**
     * Setter for CourseNumber
     *
     * @param courseNum - the new Course Number
     */
    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    /**
     * Getter for Course Difficulty
     *
     * @return - the Course Difficulty of the course
     */
    public int getCourseDifficulty() {
        return courseDifficulty;
    }

    /**
     * The setter for courseDifficulty
     *
     * @param courseDifficulty - the new Difficulty
     */
    public void setCourseDifficulty(int courseDifficulty) {
        this.courseDifficulty = courseDifficulty;
    }

    /**
     * Getter for Arrival Probability
     *
     * @return - the arrival probability of students
     */
    public double getArrivalProbabilty() {
        return arrivalProbabilty;
    }

    /**
     * Setter for the arrival probability
     *
     * @param arrivalProbabilty - The new Arrival Probability
     */
    public void setArrivalProbabilty(double arrivalProbabilty) {
        this.arrivalProbabilty = arrivalProbabilty;
    }

    /**
     * Getter for all the students arrived for the course to get help
     *
     * @return
     */
    public int getStudentCount() {
        return studentArrived;
    }

    /**
     * Increments the number of students arrived for the course by 1 each time
     * it is called
     */
    public void studentCount() {
        this.studentArrived++;
    }

    /**
     * Getter for the total waiting time for the course
     *
     * @return
     */
    public int getLatency() {

        return this.latency;
    }

    /**
     * Increments latency by specific amount of time based on when the student
     * has arrivel
     *
     * @param time - the waiting time
     */
    public void incrementLatency(int time) {

        this.latency += time;
    }

}
