package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

	public static List<Hotel> hotelList = new ArrayList<Hotel>();

	public static void addRateAndHotelName(String hotelName, int weeklyRate, int weekEndRate) {
		Hotel hotel = new Hotel(hotelName, weeklyRate, weekEndRate);
		hotelList.add(hotel);
	}

	public static void findCheapestHotel(String startDate, String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);

		Hotel cheapestHotel = null;
		int minRate = 1000000;

		for (Hotel hotel : hotelList) {
			LocalDate tempStart = start;
			LocalDate tempEnd = end.plusDays(1);
			int hotelRent = 0;
			while (!(tempStart.equals(tempEnd))) {
				hotelRent = hotelRent + hotel.getWeeklyRate();
				tempStart = tempStart.plusDays(1);
			}
			if (hotelRent < minRate) {
				minRate = hotelRent;
				cheapestHotel = hotel;
			}

		}
		System.out.println("The Cheapest option is: ");
		System.out.println(cheapestHotel.getHotelName() + ", total rent :- " + minRate);

	}

}

public static void main(String[] args) {

		System.out.println("Welcome to Hotel Reservation Program");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter the hotel name for adding rates: ");
			String hotelName = sc.next();
			System.out.println("Enter the Weekly rate: ");
			int weeklyRate = sc.nextInt();
			System.out.println("Enter the WeekEnd rate: ");
			int weekEndRate = sc.nextInt();
			HotelReservation.addRateAndHotelName(hotelName, weeklyRate, weekEndRate);
			System.out.println("Add more hotel- (Yes/No)");
			String choice = sc.next();
			if (choice.equalsIgnoreCase("Yes"))
				continue;
			else
				break;
		}

		System.out.println("Find Cheapest Hotel in Date Range:- ");
		System.out.println("Enter Start Date(YYYY-MM-DD):- ");
		String startDate = sc.next();
		System.out.println("Enter End Date(YYYY-MM-DD):- ");
		String endDate = sc.next();
		HotelReservation.findCheapestHotel(startDate, endDate);

		sc.close();
	}

}

