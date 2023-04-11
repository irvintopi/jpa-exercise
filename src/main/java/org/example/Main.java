package org.example;

import MainImpl.BookingMain;
import MainImpl.FlightMain;
import MainImpl.UserMain;

import java.util.Scanner;

public class Main {

    private static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = "";
        while (!menu.equalsIgnoreCase("E")) {
            System.out.println("Choose the menu\n1.Menu User\n2.Menu Flights\n3.Menu Bookings\nPress E to exit");
            menu = read.nextLine();
            switch (menu.toLowerCase()) {
                case "1":
                    handleUserMenu();
                    break;
                case "2":
                    handleFlightMenu();
                    break;
                case "3":
                    handleBookingMenu();
                    break;
                case "e":
                    break;
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        }
    }

    private static void handleUserMenu() {
        String result = "";
        while (!result.equalsIgnoreCase("5")) {
            System.out.println("Menu User\n1.Save User\n2.Find user by id\n3.Find all users\n4.Delete a user\n5.Exit User Menu\nChoose an option (1-5)");
            result = read.nextLine();
            switch (result) {
                case "1":
                    UserMain.add();
                    break;
                case "2":
                    UserMain.findId();
                    break;
                case "3":
                    UserMain.find();
                    break;
                case "4":
                    UserMain.remove();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        }
    }

    private static void handleFlightMenu() {
        String result = "";
        while (!result.equalsIgnoreCase("5")) {
            System.out.println("Menu Flights\n1.Save Flight\n2.Find flight by id\n3.Find all flights\n4.Delete a flight\n5.Exit Flight Menu\nChoose an option (1-5)");
            result = read.nextLine();
            switch (result) {
                case "1":
                    FlightMain.add();
                    break;
                case "2":
                    FlightMain.findId();
                    break;
                case "3":
                    FlightMain.find();
                    break;
                case "4":
                    FlightMain.remove();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        }
    }

    private static void handleBookingMenu() {
        String result = "";
        while (!result.equalsIgnoreCase("5")) {
            System.out.println("Menu Booking\n1.Save Booking\n2.Find booking by id\n3.Find all bookings\n4.Delete a booking\n5.Exit Bookings Menu\nChoose an option (1-5)");
            result = read.nextLine();
            switch (result) {
                case "1":
                    BookingMain.add();
                    break;
                case "2":
                    BookingMain.findId();
                    break;
                case "3":
                    BookingMain.find();
                    break;
                case "4":
                    BookingMain.remove();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        }
    }
}