
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */
/**
 * The job of the Class to Create Student Type Object
 *
 * @author nafi
 */
public class Student {

    private static int StudentCounter = 0;
    private int studentId, timeArrived, timeRequired;
    private Course course;

    /**
     * The Constructor for Student Object with arrival time, the course he/she
     * is in, autoincrements the student counter
     *
     * @param timeArrived - the time of arrival
     * @param course - course he/ she is taking
     * @throws IllegalArgumentException - if the time arrival is negative or
     * zero or not exist or the course is null
     */
    public Student(int timeArrived, Course course) throws IllegalArgumentException {

        if (timeArrived <= 0 || course == null) {

            throw new IllegalArgumentException("");
        } else {
            this.timeArrived = timeArrived;
            this.course = course;
            this.studentId = ++StudentCounter;
        }
    }

    /**
     * Getter for student counter
     *
     * @return the count for students
     */
    public static int getStudentCounter() {
        return StudentCounter;
    }

    /**
     * Setter for Student Counter
     *
     * @param StudentCounter - new value for Student Counter
     */
    public static void setStudentCounter(int StudentCounter) {
        Student.StudentCounter = StudentCounter;
    }

    /**
     * Getter for Student ID
     *
     * @return - the id number of the student
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Setter for the id number of the student
     *
     * @param studentId - new id number
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Getter for the arrival time of the student
     *
     * @return - the arrival time of the student as int
     */
    public int getTimeArrived() {
        return timeArrived;
    }

    /**
     * The setter for the arrival time
     *
     * @param timeArrived - new arrival time
     */
    public void setTimeArrived(int timeArrived) {
        this.timeArrived = timeArrived;
    }

    /**
     * Getter for The requested time
     *
     * @return the requested time
     */
    public int getTimeRequired() {
        return timeRequired;
    }

    /**
     * Setter for the requested time
     *
     * @param timeRequired - the newly requested time
     */
    public void setTimeRequired(int timeRequired) {
        this.timeRequired = timeRequired;
    }

    /**
     * getter for the course of the student
     *
     * @return the course the student is taking
     */
    public Course getCoure() {
        return course;
    }

    /**
     * Setter for the Student is taking
     *
     * @param coure - the new course
     */
    public void setCoure(Course coure) {
        this.course = coure;
    }

}
