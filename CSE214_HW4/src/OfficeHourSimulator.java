
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The driver class which contains the main method to perform the Simulation
 *
 * @author Nafiul
 */
public class OfficeHourSimulator {

    private static Scanner input = new Scanner(System.in);
    private static Comparator<Student> comp = new QueueComparator();
    private static StudentQueue line = new StudentQueue(comp);
    private static FileParser upload;

    public static void main(String[] args) {

        try {
            System.out.println("Please enter the file name: ");
            upload = new FileParser(new File(input.nextLine()));
            Course[] cr = new Course[upload.numCourses];
            for (int i = 0; i < cr.length; i++) {

                cr[i] = new Course(upload.courseNames[i], upload.probability[i]);

            }
            Arrays.sort(upload.courseNames);

            for (int i = 0; i < upload.numCourses; i++) {

                cr[i].setCourseDifficulty(Arrays.binarySearch(upload.courseNames, cr[i].getCourseNum()));

            }

            simulate(upload.simTime, upload.probability, cr, upload.min, upload.max, upload.cups, upload.numTA);
        } catch (FileNotFoundException ex) {

            System.out.println(ex);
        } catch (Exception ex) {

            System.out.println(ex);
            System.out.println("Broken File!");
        }

    }

    /**
     * It drives the Simulation
     *
     * @param officeHrTime - total time of simulation
     * @param arrivalProbability - array containing arrival probability
     * @param courses - courses the students taking
     * @param minTime - minimum requested time
     * @param maxTime - maximum requested tiem
     * @param numCups - the number of cups of coffee the professor has had
     * @param numTAs - the number of TA helping in the office hour
     */
    private static void simulate(int officeHrTime, double arrivalProbability[], Course[] courses, int minTime, int maxTime, int numCups, int numTAs) {
        try {
            //BooleanSourceCreators
            BooleanSource occurance[] = new BooleanSource[courses.length];
            for (int i = 0; i < occurance.length; i++) {
                occurance[i] = new BooleanSource(courses[i].getArrivalProbabilty());

            }

            Helper helper[] = createHelper(numTAs);

            upload.displayData();
            System.out.println("Simulation begins now!");

            //Simulation Loop
            int timeStep = 1;
            while (timeStep <= officeHrTime) {

                System.out.println("Time Step: " + timeStep);
                System.out.println("............................................................");
                //Occurance Check and Enqueue Student
                for (int i = 0; i < courses.length; i++) {

                    if (occurance[i].occur()) {

                        Student temp = new Student(timeStep, courses[i]);
                        temp.setTimeRequired(minTime + (int) (Math.random() * 4 - 1));
                        line.enqueueStudent(temp);

                        System.out.println("Student " + temp.getStudentId() + " for " + temp.getCoure().getCourseNum() + " wants " + temp.getTimeRequired() + " mins");
                    }
                }

                System.out.println("\n");

                for (int i = 0; i < helper.length; i++) {

                    if (!line.isEmpty()) {
                        if (helper[i].isFree()) {
                            if (helper[i].isIsProfessor()) {

                                Student temp = line.deQueueStudent();
                                int index = Arrays.binarySearch(upload.courseNames, temp.getCoure().getCourseNum());
                                courses[index].studentCount();
                                courses[index].incrementLatency(timeStep - temp.getTimeArrived());
                                helper[i].setHelpingStudent(temp);
                                if (numCups >= temp.getTimeRequired()) {

                                    helper[i].setTimeLeftTillFree(1);
                                } else {
                                    helper[i].setTimeLeftTillFree(temp.getTimeRequired() - numCups);
                                }
                                System.out.print("The Professor is ");
                                helper[i].countDown();

                            } else {
                                Student temp = line.deQueueStudent();
                                helper[i].setHelpingStudent(temp);
                                int index = Arrays.binarySearch(upload.courseNames, temp.getCoure().getCourseNum());
                                courses[index].studentCount();
                                courses[index].incrementLatency(timeStep - temp.getTimeArrived());
                                System.out.print("TA " + i + " is ");
                                helper[i].countDown();
                            }
                        } else if (helper[i].isIsProfessor()) {

                            System.out.print("The Professor is ");
                            helper[i].countDown();
                        } else {
                            System.out.print("TA " + i + " is ");
                            helper[i].countDown();
                        }

                    }
                }

                timeStep++;
                System.out.println();

            }

            System.out.println("Announcement: Time is up!!! People who came on time will be taken care of!!!");
            System.out.println();
            boolean done = Helper.isCleared(helper);

            while (!done) {

                if (!line.isEmpty()) {

                    for (int i = 0; i < helper.length; i++) {

                        if (!line.isEmpty()) {
                            if (helper[i].isFree()) {
                                if (helper[i].isIsProfessor()) {

                                    Student temp = line.deQueueStudent();
                                    int index = Arrays.binarySearch(upload.courseNames, temp.getCoure().getCourseNum());
                                    courses[index].studentCount();
                                    courses[index].incrementLatency(timeStep - temp.getTimeArrived());
                                    helper[i].setHelpingStudent(temp);
                                    if (numCups >= temp.getTimeRequired()) {

                                        helper[i].setTimeLeftTillFree(1);
                                    } else {
                                        helper[i].setTimeLeftTillFree(temp.getTimeRequired() - numCups);
                                    }
                                    System.out.print("The Professor is ");
                                    helper[i].countDown();

                                } else {
                                    Student temp = line.deQueueStudent();
                                    helper[i].setHelpingStudent(temp);
                                    int index = Arrays.binarySearch(upload.courseNames, temp.getCoure().getCourseNum());
                                    courses[index].studentCount();
                                    courses[index].incrementLatency(timeStep - temp.getTimeArrived());
                                    System.out.print("TA " + i + " is ");
                                    helper[i].countDown();
                                }
                            } else if (helper[i].isIsProfessor()) {

                                System.out.print("The Professor is ");
                                helper[i].countDown();
                            } else {
                                System.out.print("TA " + i + " is ");
                                helper[i].countDown();
                            }

                        }
                    }
                } else {

                    for (int i = 0; i < helper.length; i++) {

                        if (!helper[i].isFree()) {

                            if (helper[i].isIsProfessor()) {

                                System.out.print("The Professor is ");
                                helper[i].countDown();
                            } else {

                                System.out.print("TA " + i + " is ");
                                helper[i].countDown();
                            }
                        }
                    }
                }
                timeStep++;
                done = Helper.isCleared(helper);

            }
            System.out.println();
            statPrint(courses);

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    /**
     * Creates the array for helper
     *
     * @param numTAs - the number of TA available
     * @return - the helper array
     */
    private static Helper[] createHelper(int numTAs) {

        Helper help[] = new Helper[numTAs + 1];
        help[0] = new Helper(true);
        for (int i = 1; i <= numTAs; i++) {

            help[i] = new Helper(false);
        }
        return help;
    }

    /**
     * Prints out the Stats for the Simulation
     *
     * @param courses - the course array
     */
    private static void statPrint(Course courses[]) {

        int totalStudent = 0;
        int timeDelay = 0;
        for (int i = 0; i < courses.length; i++) {

            totalStudent += courses[i].getStudentCount();
            timeDelay += courses[i].getLatency();
        }

        System.out.printf("%-20s%-20s%-20s \n", "Courses", "Student Helped", "Avg. Time");
        System.out.println("______________________________________________________________");
        System.out.printf("%-20s%-20d%-20d\n", "Total", totalStudent, timeDelay / totalStudent);

        for (int i = 0; i < courses.length; i++) {

            System.out.printf("%-20d%-20d%-20d\n", courses[i].getCourseNum(), courses[i].getStudentCount(), courses[i].getLatency() / courses[i].getStudentCount());
        }
    }
}
