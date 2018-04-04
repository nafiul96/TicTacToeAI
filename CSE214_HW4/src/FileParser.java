
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 * HOMEWORK-4
 */
import com.sun.media.sound.InvalidFormatException;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.Scanner;

/**
 * The job of the class is to parse and display the file that will be used for
 * this simulation
 *
 * @author Nafiul
 */
public class FileParser {

    File absolute;
    Scanner scan;
    PrintWriter print;
    int numCourses;
    int courseNames[];
    double probability[];
    int min, max, cups, simTime, numTA;

    /**
     * constructor for the FileParser
     *
     * @param file - the file to be created
     * @throws FileNotFoundException - assures that the file is exist
     * @throws InvalidFormatException - assures that the file is well formatted
     */
    public FileParser(File file) throws FileNotFoundException, InvalidFormatException {
        if (!file.exists()) {

            throw new FileNotFoundException("File does not exist");
        } else {
            absolute = file;
            scan = new Scanner(absolute);
            this.dataExtract();
            if (!isFormatted()) {

                throw new InvalidFormatException("File is not formatted properly!");
            }

        }

    }

    /**
     * Private method to check the format of the file
     *
     * @return - it returns true if the file is well formatted, otherwise false
     */
    private boolean isFormatted() {

        if (((courseNames.length + probability.length) / 2) != numCourses
                || min > max || cups < 0 || simTime <= 0 || numTA < 0
                || min <= 0 || max <= 0) {

            return false;
        }

        return true;
    }

    /**
     * It pulls out data from the file
     */
    public void dataExtract() {

        String temp[] = (scan.nextLine()).split(":");

        numCourses = Integer.parseInt(temp[1].trim());

        temp = (scan.nextLine()).split(":");
        courseNames = this.fillIn(numCourses, temp);

        temp = (scan.nextLine()).split(":");
        probability = this.fill(numCourses, temp);

        temp = (scan.nextLine()).split(":");
        min = Integer.parseInt(temp[1].trim());

        temp = (scan.nextLine()).split(":");
        max = Integer.parseInt(temp[1].trim());

        temp = (scan.nextLine()).split(":");
        cups = Integer.parseInt(temp[1].trim());

        temp = (scan.nextLine()).split(":");
        simTime = Integer.parseInt(temp[1].trim());

        temp = (scan.nextLine()).split(":");
        numTA = Integer.parseInt(temp[1].trim());

        scan.close();
    }

    /**
     * Private method to fill in int array from String array
     *
     * @param count - the length of the array
     * @param arr - the String array to be parsed
     * @return the parsed array as int array
     */
    private int[] fillIn(int count, String arr[]) {

        arr = arr[1].split(" ");
        int temp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            temp[i] = Integer.parseInt(arr[i].trim());
        }

        return temp;
    }

    /**
     * Private method to fill in double array from String array
     *
     * @param count - the length of the array
     * @param arr - the String array to be parsed
     * @return the parsed array as double array
     */
    private double[] fill(int count, String arr[]) {

        arr = arr[1].split(" ");
        double temp[] = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = Double.parseDouble(arr[i].trim());
        }

        return temp;
    }

    /**
     * Displays the data in the file in well formatted manner
     */
    public void displayData() {

        System.out.println("\n Number of Courses: " + this.numCourses + "\n");
        System.out.printf("%-20s%-20s\n", "Course Name", "Probability");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < this.numCourses; i++) {

            System.out.printf("%-20d%-20.2f\n", this.courseNames[i], this.probability[i]);
        }

        System.out.println("Interval:" + this.min + "-" + this.max);
        System.out.println("Cups of Coffee:" + this.cups);
        System.out.println("Simulation Time: " + this.simTime);
        System.out.println("Number of TA:" + this.numTA);
    }

}
