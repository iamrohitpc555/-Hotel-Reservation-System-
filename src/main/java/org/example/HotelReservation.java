package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

    public static List<Hotel> hotelList = new ArrayList<Hotel>();

    public static void addRegularRateAndHotelName(String hotelName, int regularRate) {
        Hotel hotel = new Hotel(hotelName, regularRate);
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
            System.out.println("Enter the Regular rate: ");
            int regularRate = sc.nextInt();
            HotelReservation.addRegularRateAndHotelName(hotelName, regularRate);
            System.out.println("Add more hotel- (Yes/No)");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("Yes"))
                continue;
            else
                break;
        }

        sc.close();
    }
}
