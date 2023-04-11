package MainImpl;

import org.example.model.Booking;
import org.example.model.Flight;
import org.example.model.User;
import org.example.services.BookingService;
import org.example.services.Impl.*;
import java.sql.Date;
import java.util.*;

public class BookingMain {
    public static void find(){
        BookingService booking = new BookingServiceImpl();
        List<Booking> bookingList = booking.findAll();
        System.out.println("All the bookings...\n");
        for (Booking b : bookingList) {
            System.out.println(b);
        }
    }
    public static Booking add(){
        Scanner read = new Scanner(System.in);
        BookingService booking = new BookingServiceImpl();
        System.out.println("\nAdding booking\n");

        System.out.println("Enter the id of the user who booked the flight");
        int uId = read.nextInt();
        UserServiceImpl user = new UserServiceImpl();
        Optional<User> userById = user.findById(uId);
        System.out.println("The flights of this booking...");
        int result = 0;
        FlightServiceImpl flight = new FlightServiceImpl();
        List<Flight> flights = new ArrayList<>();
        while (result != -1){
            System.out.println("Add one flight id to this booking (-1 to stop)");
            try {
                result = read.nextInt();
                read.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Id should be a number");
                read.nextLine();
            }
            Optional<Flight> flightById = flight.findById(result);
            if (flightById.isPresent()){
                Flight fbyId = flightById.get();
                flights.add(fbyId);
            }
            else if (result != -1){
                System.out.println("This flight doesn't exist");
                return null;
            }
        }
        if (userById.isPresent()){
            User ubyId = userById.get();
            Date date = new Date(System.currentTimeMillis());
            System.out.println("Enter the status");
            String status = read.nextLine();

                Booking b = new Booking();
                b=setter(b,status,date,ubyId,flights);
                booking.save(b);
                return b;

        }
        else {
            System.out.println("Couldn't add booking. Invalid user");
            return null;
        }
    }
    public static void findId(){
        Scanner read = new Scanner(System.in);
        BookingService booking = new BookingServiceImpl();
        Integer find = 0;
        System.out.println("\nFinding booking by id\n");
        try {
            System.out.println("Enter the booking id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking1 = booking.findById(find);
        if (booking1.isPresent()){
            Booking byId = booking1.get();
            System.out.println(byId);
        }
        else
            System.out.println("This booking doesnt exist");
    }
    public static void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
        BookingService booking = new BookingServiceImpl();
        System.out.println("\nDeleting booking\n");
        try {
            System.out.println("Enter the booking id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking2 = booking.findById(find);
        if (booking2.isPresent()){
            Booking bdelete = booking2.get();
            booking.delete(bdelete);
        }
        else
            System.out.println("This booking doesnt exist");
    }
    public static Booking setter(Booking b1, String status, Date date, User ubyId, List<Flight> flights){
        b1.setStatus(status);
        b1.setBookingDate(date);
        b1.setUser(ubyId);
        b1.setFlights(flights);
        return b1;
    }
}
