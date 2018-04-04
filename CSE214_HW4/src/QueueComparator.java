
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */
import java.util.Comparator;

/**
 * The comparator for the Priority Queue of Students
 *
 * @author Nafiul
 */
public class QueueComparator implements Comparator<Student> {

    /**
     * It compares Students based on their course difficulty
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCoure().getCourseDifficulty() < o2.getCoure().getCourseDifficulty()) {

            return 1;
        } else if (o1.getCoure().getCourseDifficulty() > o2.getCoure().getCourseDifficulty()) {

            return -1;

        } else {

            return 0;
        }
    }

}
