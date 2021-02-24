package org.example;

import java.time.DayOfWeek;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

	public static List<Hotel> hotelList = new ArrayList<Hotel>();

	public static void addRateAndHotelName(String hotelName, int rating, int weeklyRate, int weekEndRate,
			int weeklyRateReward, int weekEndRateReward) {
		Hotel hotel = new Hotel(hotelName, rating, weeklyRate, weekEndRate, weeklyRateReward, weekEndRateReward);
		hotelList.add(hotel);
	}

	public static void findCheapestHotel(String startDate, String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);

		LocalDate tempStart = start;
		LocalDate tempEnd = end;

		List<Hotel> cheapestHotelList = new ArrayList<>();
		int minRate = 1000000000;

		for (Hotel hotel : hotelList) {
			start = tempStart;
			end = tempEnd.plusDays(1);
			int hotelRent = 0;
			while (!(start.equals(end))) {

				int day = start.getDayOfWeek().getValue();

				if (day == 6 || day == 7)
					hotelRent = hotelRent + hotel.getWeekEndRate();

				else
					hotelRent = hotelRent + hotel.getWeeklyRate();

				start = start.plusDays(1);

			}
			if (hotelRent <= minRate) {
				minRate = hotelRent;
				if (hotelRent < minRate) {
					if (cheapestHotelList.size() == 0)
						cheapestHotelList.add(hotel);

					else {
						cheapestHotelList.clear();
						cheapestHotelList.add(hotel);
					}

				} else
					cheapestHotelList.add(hotel);
			}

		}
		System.out.println("The Cheapest option is");
		for (Hotel hotel : cheapestHotelList) {
			System.out.println(hotel.getHotelName() + ", total rent :- " + minRate);

		}

	}

	public static void findCheapestBestRatedHotel(String startDate, String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);

		LocalDate tempStart = start;
		LocalDate tempEnd = end;

		Hotel cheapestHotel = null;
		int minRate = 1000000000;
		int bestRating = 0;

		for (Hotel hotel : hotelList) {
			start = tempStart;
			end = tempEnd.plusDays(1);
			int hotelRent = 0;
			while (!(start.equals(end))) {

				int day = start.getDayOfWeek().getValue();

				if (day == 6 || day == 7)
					hotelRent = hotelRent + hotel.getWeekEndRate();

				else
					hotelRent = hotelRent + hotel.getWeeklyRate();

				start = start.plusDays(1);

			}
			if (hotelRent < minRate) {
				minRate = hotelRent;
				cheapestHotel = hotel;
				bestRating = hotel.getRating();
			}

			if (hotelRent == minRate && hotel.getRating() > bestRating) {
				bestRating = hotel.getRating();
				cheapestHotel = hotel;
			}

		}
		System.out.println("The Cheapest option is");
		System.out.println(cheapestHotel.getHotelName() + ", rating :- " + cheapestHotel.getRating()
				+ ", total rent :- " + minRate);

	}

	public static void findBestRatedHotel(String startDate, String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);

		LocalDate tempStart = start;
		LocalDate tempEnd = end;

		Hotel cheapestHotel = null;
		int minRate = 1000000000;
		int bestRating = 0;

		for (Hotel hotel : hotelList) {
			start = tempStart;
			end = tempEnd.plusDays(1);
			int hotelRent = 0;
			while (!(start.equals(end))) {

				int day = start.getDayOfWeek().getValue();

				if (day == 6 || day == 7)
					hotelRent = hotelRent + hotel.getWeekEndRate();

				else
					hotelRent = hotelRent + hotel.getWeeklyRate();

				start = start.plusDays(1);

			}
			if (hotel.getRating() > bestRating) {
				bestRating = hotel.getRating();
				minRate = hotelRent;
				cheapestHotel = hotel;
			}

		}
		System.out.println("The Best Rated option is");
		System.out.println(cheapestHotel.getHotelName() + ", rating :- " + cheapestHotel.getRating()
				+ ", total rent :- " + minRate);

	}
}
public static void main(String[] args) {

		System.out.println("Welcome to Hotel Reservation Program");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter the hotel name for adding rates: ");
			String hotelName = sc.next();
			System.out.println("Enter rating: ");
			int rating = sc.nextInt();
			System.out.println("Enter the Weekly rate: ");
			int weeklyRate = sc.nextInt();
			System.out.println("Enter the WeekEnd rate: ");
			int weekEndRate = sc.nextInt();
			System.out.println("Enter the Weekly Reward rate: ");
			int weeklyRateReward = sc.nextInt();
			System.out.println("Enter the WeekEnd Reward rate: ");
			int weekEndRateReward = sc.nextInt();
			HotelReservation.addRateAndHotelName(hotelName, rating, weeklyRate, weekEndRate, weeklyRateReward,
					weekEndRateReward);
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

		System.out.println("Find Cheapest Best Rated Hotel in Date Range:- ");
		System.out.println("Enter Start Date(YYYY-MM-DD):- ");
		String start = sc.next();
		System.out.println("Enter End Date(YYYY-MM-DD):- ");
		String end = sc.next();
		HotelReservation.findCheapestBestRatedHotel(start, end);

		System.out.println("Find Best Rated Hotel in Date Range:- ");
		System.out.println("Enter Start Date(YYYY-MM-DD):- ");
		String startD = sc.next();
		System.out.println("Enter End Date(YYYY-MM-DD):- ");
		String endD = sc.next();
		HotelReservation.findBestRatedHotel(startD, endD);

		sc.close();
	}

}
