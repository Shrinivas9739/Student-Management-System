import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class DeleteStudent extends JFrame implements ActionListener {

    JTextField textFieldPhone,textFieldEmail;
    JButton buttonDelete,buttonClear, buttonBack;

    DeleteStudent(){
        super("Delete Student");

        JLabel DeleteTitle = new JLabel("Enter Phone Number and Email to Delete Student");
        DeleteTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        DeleteTitle.setBounds(400, 30, 1000, 35);
        DeleteTitle.setForeground(new Color(52, 73, 94));
        add(DeleteTitle);


        JLabel PhoneNumber = new JLabel("Phone No :");
        PhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 20));
        PhoneNumber.setBounds(550,200,150,30);
        PhoneNumber.setForeground(Color.BLACK);
        add(PhoneNumber);
        textFieldPhone = new JTextField();
        textFieldPhone.setFont(new Font("Segoe UI", Font.BOLD, 18));
        textFieldPhone.setBounds(720,205,300,30);
        add(textFieldPhone);


        JLabel Email = new JLabel("Email :");
        Email.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Email.setBounds(550,250,150,30);
        Email.setForeground(Color.BLACK);
        add(Email);
        textFieldEmail = new JTextField();
        textFieldEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
        textFieldEmail.setBounds(720,255,300,30);
        add(textFieldEmail);


        buttonDelete = new JButton("Delete");
        buttonDelete.setBackground(Color.RED);
        buttonDelete.setBounds(640,400,100,30);
        buttonDelete.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonDelete.setForeground(Color.WHITE);
        buttonDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonDelete.addActionListener(this);
        add(buttonDelete);


        buttonClear = new JButton("Clear");
        buttonClear.setBackground(Color.RED);
        buttonClear.setBounds(780,400,100,30);
        buttonClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonClear.addActionListener(this);
        add(buttonClear);


        buttonBack = new JButton("Back");
        buttonBack.setBackground(Color.RED);
        buttonBack.setBounds(920,400,100,30);
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

        String mail = textFieldEmail.getText().trim();
        String mobile = textFieldPhone.getText().trim();
        if (e.getSource() == buttonClear) {
            textFieldEmail.setText("");
            textFieldPhone.setText("");
        } else if (e.getSource() == buttonBack) {
            dispose();
            new Dashboard();

        } else if (mail.isEmpty() || mobile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter all fields.");
        } else if (!isValidEmail(mail)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Email address (e.g. abc@gmail.com).");
        } else if (!isValidPhone(mobile)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit phone number.");
        }
        else if (e.getSource() == buttonDelete) {
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this record?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Con con = new Con();
                    String q = "DELETE FROM student WHERE Email = '" + mail + "' AND Phone = '" + mobile + "'";

                    int result = con.statement.executeUpdate(q);

                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                        dispose();
                        new Dashboard();
                    } else {
                        JOptionPane.showMessageDialog(null, "No matching record found.");
                        textFieldEmail.setText("");
                        textFieldPhone.setText("");
                    }
                } catch (Exception g) {
                    g.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Deletion cancelled.");
            }
        }
    }
    public static void main(String[] args) {
        new DeleteStudent();
    }
}
