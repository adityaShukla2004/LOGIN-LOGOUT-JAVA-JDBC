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
        StringBuffer header = new StringBuffer();
       
        Class.forName(D_Dri);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);

        UserOperation user = new UserOperation (connection,sc);
        boolean whileRunner=true;

        

        
            
       

       


       

        // start the App manu

        System.out.println("BANK MANAGEMENT SYSTEM");

        while (whileRunner) {
            System.out.println("USERNAME :    "+header);
            System.out.println("1 Register:");
            System.out.println("2 Login");
            System.out.println("3 Log Out");
            System.out.println("4 Show Data");
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
                      header.append(user.Login());
                    break;

                case 3:
                     header.delete( 0, header.capacity());
                     System.out.println("Successfully Logout ");
                    break;

                case 4:
                      user.ShowData();
                    break;
                case 5:
                    whileRunner=false;
                    break;

                default:
                    break;
            }
            
           
        }
      
       
    }
}