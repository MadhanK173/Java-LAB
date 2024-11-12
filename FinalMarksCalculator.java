import cie.*;
import see.*;
import java.util.Scanner;

public class FinalMarksCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        
        Internals[] internalStudents = new Internals[n];
        External[] externalStudents = new External[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.print("USN: ");
            String usn = scanner.next();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Semester: ");
            int sem = scanner.nextInt();

            int[] internalMarks = new int[5];
            System.out.println("Enter 5 internal marks: ");
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = scanner.nextInt();
            }
            internalStudents[i] = new Internals(usn, name, sem, internalMarks);

            int[] seeMarks = new int[5];
            System.out.println("Enter 5 SEE marks: ");
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = scanner.nextInt();
            }
            externalStudents[i] = new External(usn, name, sem, seeMarks);
        }

        
        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nDetails of Student " + (i + 1) + ":");
            internalStudents[i].display();

            int[] finalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                finalMarks[j] = internalStudents[i].internalMarks[j] + (externalStudents[i].seeMarks[j] / 2);
            }

            System.out.println("Final Marks in 5 Courses:");
            for (int mark : finalMarks) {
                System.out.print(mark + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}