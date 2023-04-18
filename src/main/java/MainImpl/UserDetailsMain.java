package MainImpl;

import org.example.model.User;
import org.example.model.UserDetails;
import org.example.services.UserDetailsService;
import org.example.services.Impl.UserDetailsServiceImpl;

import java.util.*;

public class UserDetailsMain {
    public static void find(){
        UserDetailsService userDetail = new UserDetailsServiceImpl();
        List<UserDetails> userDetailsList = userDetail.findAll();
        System.out.println("All the user details...\n");
        for (UserDetails ud : userDetailsList) {
            System.out.println(ud);
        }
    }
    public static UserDetails add(User usser){
        Scanner read = new Scanner(System.in);
        UserDetailsService userDetail = new UserDetailsServiceImpl();
        Integer id = 0;
        System.out.println("\nAdding user details\n");
        System.out.println("Enter the first name");
        String fn = read.nextLine();
        System.out.println("Enter the last name");
        String ln = read.nextLine();
        System.out.println("Enter the email");
        String email = read.nextLine();
        System.out.println("Enter the phone number");
        String phone = read.nextLine();
        UserDetails ud2 = new UserDetails();
        ud2.setFirstName(fn);
        ud2.setLastName(ln);
        ud2.setEmail(email);
        ud2.setPhoneNumber(phone);
        ud2.setUser(usser);
        userDetail.save(ud2);
        return ud2;
    }
    public static void findId(){
        Scanner read = new Scanner(System.in);
        UserDetailsService userDetail = new UserDetailsServiceImpl();
        Integer find = 0;
        System.out.println("\nFinding user details by id\n");
        try {
            System.out.println("Enter the user details id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<UserDetails> userDetails1 = userDetail.findById(find);
        if (userDetails1.isPresent()){
            UserDetails byId = userDetails1.get();
            System.out.println(byId);
        }
        else
            System.out.println("These user details dont exist");
    }
    public static void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
        UserDetailsService userDetail = new UserDetailsServiceImpl();
        System.out.println("\nDeleting user details\n");
        try {
            System.out.println("Enter the user details id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<UserDetails> userDetails2 = userDetail.findById(find);
        if (userDetails2.isPresent()){
            UserDetails udelete = userDetails2.get();
            userDetail.delete(udelete);
        }
        else
            System.out.println("These user details don't exist");
    }
}