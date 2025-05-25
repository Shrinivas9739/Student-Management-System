import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {

    Connection connection;
    Statement statement;

    public Con(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudent", "root", "2444666668888888@");
            this.statement = this.connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}