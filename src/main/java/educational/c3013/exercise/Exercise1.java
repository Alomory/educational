package educational.c3013.exercise;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Exercise1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Result[] results = new Result[150];
		for (int i = 0; i < 150; i++) {
			System.out.printf("Student %s\n", i + 1);
			System.out.print("Matric no.: ");
			String matric = s.nextLine();
			if ("".equals(matric)) break;
			System.out.print("Name: ");
			String name = s.nextLine();
			if ("".equals(name)) break;
			// Modify as needed for number of subjects
			System.out.print("Math Score: ");
			double math = s.nextDouble();
			if (math < 0) break;
			s.nextLine(); // Prevent empty line feed on next loop
			results[i] = new Result(matric, name, 
					new Subject("Math", math));
		}
		double math_avg = 0;
		results = Arrays.stream(results)
			.filter(Objects::nonNull)
			.toArray(Result[]::new);
		for (Result r : results) 
			math_avg += r.subjects[0].score;
		math_avg /= results.length;
		System.out.printf("\nMath Average: %s\n", math_avg);
		s.close();
	}
}

class Result {
	String matric, name;
	Subject[] subjects;

	public Result(String m, String n, Subject... s) {
		matric = m;
		name = n;
		subjects = s;
	}

        @Override
	public String toString() {
		return "Matric no.: " + matric + "\n" 
			+ "Name: " + name + "\n"
			+ "Subjects: \n" 
			+ String.join("\n", Stream.of(subjects)
					.map(Subject::toString)
					.toArray(String[]::new));
	}
}

class Subject {
	String name;
	double score;

	public Subject(String n, double s) {
		name = n;
		score = s;
	}

        @Override
	public String toString() {
		return name + ": " + Double.toString(score);
	}
}
