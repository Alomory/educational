package educational.c3034.lab;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import educational.lib.NumberGetter;

public class Module10 {
    public static void activity1() {
        File f = new File("./assets/txt/input.txt");
        File f1 = new File("./assets/txt/output.txt");
        System.out.println((f.exists()) ? "File exists" : "Should not happen");
        System.out.println("File chars: " + f.length());
        System.out.println("Can read: " + f.canRead());
        System.out.println("Can write: " + f.canWrite());
        System.out.println("Is dir: " + f.isDirectory());
        System.out.println("Is file: " + f.isFile());
        System.out.println("Is abs: " + f.isAbsolute());
        System.out.println("Is hidden: " + f.isHidden());
        System.out.println("Abs path: " + f.getAbsolutePath());
        System.out.println("Last modified: " + f.lastModified());
        System.out.println("Rename file: " + f.renameTo(f1));
        System.out.println("Undo rename: " + f1.renameTo(f));
    }

    public static void activity2() throws Throwable {
        Scanner s = new Scanner(new File("./assets/txt/input.txt"));
        while (s.hasNextLine()) System.out.println(s.nextLine());
        s.close();
    }

    public static void activity3() throws Throwable {
        String ctx = "";
        Scanner s = new Scanner(new File("./assets/txt/input.txt"));
        s.useDelimiter("\n");
        while (s.hasNext()) ctx += s.next() + " ";
        s.close();
        System.out.println(ctx);
    }

    public static double[] activity4() throws Throwable {
//        i. declare one dimensional arrays
        String[] names = new String[10];
        double[] scores = new double[10];
        String[] grades = new String[10];
//        ii. read the data one by one and assign to the specific arrays that have been declared
        int i = 0;
        Scanner s = new Scanner(new File("./assets/txt/student.txt"));
        while (s.hasNextLine()) {
            names[i] = s.next();
            scores[i] = s.nextDouble();
            grades[i++] = s.next();
        }
        s.close();
//        iii. sort the students according to their mark in descending order
        int l = names.length;
        String temp_s;
        double temp_d;
        for (i=0; i < l-1; i++) {
            for (int j=1; j < l; j++) {
                if (scores[i] > scores[j]) {
                    temp_s = names[i];
                    names[i] = names[j];
                    names[j] = temp_s;
                    temp_d = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp_d;
                    temp_s = grades[i];
                    grades[i] = grades[j];
                    grades[j] = temp_s;
                }
            }
        }
        System.out.println();
//        iv. calculate total marks and its average
        double sum, avg;
        sum = Arrays.stream(scores).sum();
        avg = sum / l;
//        v. display out the sorted list of students (name, marks & grade), total mark and average
        for (i=0; i < l-1; i++) {
            System.out.println("Name: " + names[i]);
            System.out.println("Score: " + scores[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }
        System.out.println("Total: " + sum);
        System.out.println("Average: " + avg);
//        Modify your program as in Activity 4 by printing out the sorted list, total and average in an output file
        return new double[]{sum, avg};
    }

    public static void activity5() throws Throwable {
        double[] lazy = activity4();
        File f = new File("./assets/txt/output.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter("./src/output.txt");
        fw.write("Headmaster didn't pay me enough :(\n" + lazy[0] + "\n" + lazy[1]);
        fw.close();
        NumberGetter.scanInt("Check the file at ./assets/txt/output.txt");
        f.delete();
    }
}
