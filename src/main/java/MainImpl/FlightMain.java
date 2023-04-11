package MainImpl;

import org.example.model.Flight;
import org.example.services.FlightService;
import org.example.services.Impl.FlightServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FlightMain {
    public static void find(){
        FlightService flight = new FlightServiceImpl();
        List<Flight> flightList = flight.findAll();
        System.out.println("All the flights...\n");
        for (Flight f : flightList) {
            System.out.println(f);
        }
    }
    public static Flight add() {
        Scanner read = new Scanner(System.in);
        FlightService flight = new FlightServiceImpl();
//        Integer id = 0;
        System.out.println("\nAdding flight\n");
        System.out.println("Enter the origin");
        String origin = read.nextLine();
        System.out.println("Enter the destination");
        String destination = read.nextLine();
        System.out.println("Enter the airline");
        String airline = read.nextLine();
        System.out.println("Enter the flight number");
        Integer flightNumber = read.nextInt();
        System.out.println("Enter the departure date (yyyy-MM-dd)");
        read.nextLine();
        Date departureDate = null;
        try {
            departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(read.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
        System.out.println("Enter the arrival date (yyyy-MM-dd)");
        Date arrivalDate = null;
        try {
            arrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse(read.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
        System.out.println("Enter the status");
        String status = read.nextLine();


        Flight f1 = new Flight();
        f1 = setter(f1, origin, destination, airline, flightNumber, departureDate, arrivalDate, status);
        flight.save(f1);
        return f1;
    }
    public static void findId(){
        Scanner read = new Scanner(System.in);
        FlightService flight = new FlightServiceImpl();
        Integer find = 0;
        System.out.println("\nFinding flight by id\n");
        try {
            System.out.println("Enter the flight id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Flight> flight1 = flight.findById(find);
        if (flight1.isPresent()){
            Flight byId = flight1.get();
            System.out.println(byId);
        }
        else
            System.out.println("This flight doesnt exist");
    }
    public static void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
        FlightService flight = new FlightServiceImpl();
        System.out.println("\nDeleting flight\n");
        try {
            System.out.println("Enter the flight id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Flight> flight2 = flight.findById(find);
        if (flight2.isPresent()){
            Flight fdelete = flight2.get();
            flight.delete(fdelete);
        }
        else
            System.out.println("This flight doesnt exist");
    }
    public static Flight setter(Flight f1, String origin, String dest, String air, Integer fn, Date date, Date date1, String status){
        f1.setOrigin(origin);
        f1.setDestination(dest);
        f1.setAirline(air);
        f1.setFlightNumber(fn);
        f1.setDepartureDate(date);
        f1.setArrivalDate(date1);
        f1.setStatus(status);
        return f1;
    }
}