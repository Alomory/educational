package educational.c3013.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean skillIssue = true;
        String next = "";
        while (skillIssue) {
            try {
                next = s.nextLine();
                Integer.parseInt(next, 2);
                skillIssue = false;
            } catch (NumberFormatException e) {
                System.out.println("lol");
            }
        }
        Task2 intStack = new Task2(next.length());
        Arrays.stream(next.split("")).forEach(i -> intStack.push(Integer.parseInt(i)));
        int sum = 0, power = 0;
        while (!intStack.isEmpty()) sum += (intStack.pop() * (Math.pow(2, power++)));
        System.out.println(sum);
        s.close();
    }
}
