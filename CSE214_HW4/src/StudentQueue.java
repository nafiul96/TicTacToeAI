
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * It creates the PriorityQueue Type Object of Students extedning the
 * PriorityQueue class in Java API
 *
 * @author Nafiul
 */
public class StudentQueue extends PriorityQueue {

    /**
     * Creates the PriorityQueue
     *
     * @param c - the comparator to compare the priority of students
     */
    public StudentQueue(Comparator<Student> c) {

        super(c);

    }

    /**
     * Adds student to the queue
     *
     * @param s - the Student added
     */
    public void enqueueStudent(Student s) {

        super.add(s);
    }

    /**
     * Removes Student from the Queue
     *
     * @return - the student who has been removed
     */
    public Student deQueueStudent() {

        System.out.println();
        return (Student) this.poll();
    }

    /**
     * Calculates the Size of the Queue
     *
     * @return - the size of the Queue
     */
    @Override
    public int size() {

        return super.size();
    }

    /**
     * Checks whether the Queue is empty or not
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {

        return super.isEmpty();
    }

}
