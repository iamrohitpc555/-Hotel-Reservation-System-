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