package MainImpl;

import org.example.model.User;
import org.example.model.UserDetails;
import org.example.services.UserService;
import org.example.services.Impl.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserMain {
    public static void find(){
        UserService user = new UserServiceImpl();
        List<User> userList = user.findAll();
        System.out.println("All the users...\n");
        for (User us : userList) {
            System.out.println(us);
        }
    }
    public static User add(){
        Scanner read = new Scanner(System.in);
        UserService user = new UserServiceImpl();

        System.out.println("\nAdding user\n");

        System.out.println("Enter the username");
        String name = read.nextLine();
        System.out.println("Enter the user password");
        String pass = read.nextLine();
        System.out.println("Enter the user role");
        String role = read.nextLine();

        User u1 = new User();
        u1=setter(u1,role,pass,name);
        user.save(u1);
        UserDetails ud = UserDetailsMain.add(u1);
        u1.setUserDetails(ud);
        user.save(u1);
        return u1;
    }
    public static void findId(){
        Scanner read = new Scanner(System.in);
        UserService user = new UserServiceImpl();
        Integer find = 0;
        System.out.println("\nFinding user by id\n");
        try {
            System.out.println("Enter the user id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<User> user1 = user.findById(find);
        if (user1.isPresent()){
            User byId = user1.get();
            System.out.println(byId);
        }
        else
            System.out.println("This user doesn't exist");
    }
    public static void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
        UserService user = new UserServiceImpl();
        System.out.println("\nDeleting user\n");
        try {
            System.out.println("Enter the id of the user you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<User> user2 = user.findById(find);
        if (user2.isPresent()){
            User udelete = user2.get();
            user.delete(udelete);
        }
        else
            System.out.println("This user doesn't exist");
    }
    public static User setter(User u1,String role, String pass, String name){
        u1.setUserName(name);
        u1.setRole(role);
        u1.setPassword(pass);
        return u1;
    }
}