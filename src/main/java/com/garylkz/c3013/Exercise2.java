package com.garylkz.c3013;

import java.util.*;

public class Exercise2 {
	public static void main(String[] args) {
		ArrayList<String> seats = new ArrayList<>(
                        Arrays.asList(new String[] {"A", "B", "C"}));
		Scanner s = new Scanner(System.in);
		String seat, date, time, start, goal;
		boolean b = true;
		do {
			System.out.println("Seats: " + 
                                String.join(", ", seats));
			System.out.print("Order: ");
			seat = s.nextLine();
			if (b = !seats.contains(seat))
				System.out.println("Seats does not exist");
		} while (b);
		System.out.print("Date: ");
		date = s.nextLine();
		System.out.print("Time: ");
		time = s.nextLine();
		System.out.print("From: ");
		start = s.nextLine();
		System.out.print("Destination: ");
		goal = s.nextLine();
		System.out.printf("Seat: %s\nDate: %s\nTime: %s\n" + 
				"From: %s\nDestination: %s\n", 
				seat, date, time, start, goal);
		s.close();
	}
}
