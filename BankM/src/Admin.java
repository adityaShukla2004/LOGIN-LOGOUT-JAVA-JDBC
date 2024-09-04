import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import User.UserOperation;

public class Admin {

    public static void main(String[] args) throws Exception{
        String DB_URL = "jdbc:mysql://localhost:3306/netbank";
        String USER = "root";
        String PASS = "Aditya@1";
        String D_Dri = "com.mysql.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        Connection connection;
        String login_email=null;
       
        Class.forName(D_Dri);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);

        UserOperation user = new UserOperation (connection,sc);

        

        
            
       

       


       

        // start the App manu

        System.out.println("BANK MANAGEMENT SYSTEM");

        while (true) {
            System.out.println( login_email+"\n"+"1 Register:");
            System.out.println("2 Login");
            System.out.println("3 Log Out");
            System.out.println("5 Exit");

            System.out.println("Enter your Choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                        sc.nextLine();
                        System.out.println("Enter the Name:");
                        String name = sc.nextLine();
                        System.out.println("Enter the Email:");
                        String email = sc.nextLine();
                        System.out.println("Enter the Password:");
                        String pass = sc.nextLine();

                        user.Register(name, email, pass);
                    break;

                case 2:
                      login_email = user.Login();
                    break;

                case 3:

                    break;

                case 4:

                    break;
                case 5:

                    break;

                default:
                    break;
            }
           
        }
      
       
    }
}