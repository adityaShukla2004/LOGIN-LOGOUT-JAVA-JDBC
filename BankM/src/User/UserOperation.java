package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserOperation {
    private Connection con;
    private Scanner sc;

    public UserOperation(Connection con, Scanner sc) {
        this.con = con;
        this.sc = sc;
    }

    public void Register(String name, String email, String pass) throws Exception {
        if (!isExist(email) && isEmail(email)) {
            try {
                PreparedStatement stmt = con.prepareStatement("insert into User (name,email,password) values (?,?,?)");
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, pass);

                int i = stmt.executeUpdate();
                if (i > 0) {
                    System.out.println("REGISTERATION COMPLETED THANKYOU FOR REGISTER");
                } else {
                    System.out.println("something went worng.......");
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            System.out.println(" Sorry Email exist ........");
        }

    }

    public String Login() {
        sc.nextLine();
        System.out.println("Enter the Email:");
        String email = sc.nextLine();
        System.out.println("Enter the Password:");
        String pass = sc.nextLine();
        String login_q = "select * from User where email=? and password=?";

        

        try {
            PreparedStatement stmt = con.prepareStatement(login_q);

            stmt.setString(1, email);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return email;
            } else {
                System.out.println("USER NOT EXIST PLEASE ENTER CORRECT EMAIL AND PASSWORD");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isExist(String email) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = con.prepareStatement("select * from User where email = ?");

        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return true;
        } else
            return false;
    }
    
    public boolean isEmail( String email){
         if(email.contains("@") && email.contains("gmail.com"))
         { 
            return true;
         }
         System.out.println("Not valid email:");
         return false;
    }

}
