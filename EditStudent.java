import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class EditStudent extends JFrame implements ActionListener {

    JTextField textFieldNumber, textFieldEmail;
    JButton buttonEdit, buttonClear, buttonBack;

    EditStudent(){
        super("Edit Student");


        JLabel EditTitle = new JLabel("Enter Phone Number and Email to Edit Student");
        EditTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        EditTitle.setBounds(400, 30, 1000, 35);
        EditTitle.setForeground(new Color(52, 73, 94));
        add(EditTitle);


        JLabel PhoneNumber = new JLabel("Phone No :");
        PhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 20));
        PhoneNumber.setBounds(550,200,150,30);
        PhoneNumber.setForeground(Color.BLACK);
        add(PhoneNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setFont(new Font("Segoe UI", Font.BOLD, 18));
        textFieldNumber.setBounds(720,205,300,30);
        add(textFieldNumber);


        JLabel Email = new JLabel("Email :");
        Email.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Email.setBounds(550,250,150,30);
        Email.setForeground(Color.BLACK);
        add(Email);
        textFieldEmail = new JTextField();
        textFieldEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
        textFieldEmail.setBounds(720,255,300,30);
        add(textFieldEmail);


        buttonEdit = new JButton("Edit");
        buttonEdit.setBackground(Color.RED);
        buttonEdit.setBounds(640,350,100,30);
        buttonEdit.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonEdit.setForeground(Color.WHITE);
        buttonEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonEdit.addActionListener(this);
        add(buttonEdit);


        buttonClear = new JButton("Clear");
        buttonClear.setBackground(Color.RED);
        buttonClear.setBounds(780,350,100,30);
        buttonClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonClear.addActionListener(this);
        add(buttonClear);


        buttonBack = new JButton("Back");
        buttonBack.setBackground(Color.RED);
        buttonBack.setBounds(920,400-50,100,30);
        buttonBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonBack.addActionListener(this);
        add(buttonBack);


        getContentPane().setBackground(new Color(236, 240, 241));
        setLayout(null);
        setSize(1550,869);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public boolean isValidEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$", email);
    }

    public boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String mobile = textFieldNumber.getText();
        String email = textFieldEmail.getText();

        if (e.getSource() == buttonBack){
            dispose();
            new Dashboard();
        } else if (e.getSource() == buttonClear) {
            textFieldEmail.setText("");
            textFieldNumber.setText("");
        } else if (e.getSource() == buttonEdit) {
            if (textFieldNumber.getText().isEmpty() || textFieldEmail.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter all fields.");
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Email address (e.g. abc@gmail.com).");
            } else if (!isValidPhone(mobile)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit phone number.");
            }else{
                Con con = new Con();
                String q = "SELECT * FROM student WHERE Email = '" + email + "' AND Phone = '" + mobile + "'";
                try {
                    ResultSet result = con.statement.executeQuery(q);
                    if (result.next()){
                        JOptionPane.showMessageDialog(null,"Student found successfully.");
                        dispose();
                        new EditStudent2(email);
                    }else{
                        JOptionPane.showMessageDialog(null,"Student not found for above credentials.");
                        textFieldEmail.setText("");
                        textFieldNumber.setText("");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    public static void main(String[] args) {
        new EditStudent();
    }
}