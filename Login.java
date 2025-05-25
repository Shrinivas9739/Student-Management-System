import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {

    JButton buttonSubmit, buttonClear;
    JTextField textFieldUser;
    JPasswordField textFieldPass;

    Login() {
        super("Login Page");

        getContentPane().setBackground(new Color(240, 248, 255)); // Soft light blue
        setLayout(null);

        JLabel loginTitle = new JLabel("Welcome - Login");
        loginTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
        loginTitle.setBounds(180, 30, 300, 35);
        loginTitle.setForeground(new Color(52, 73, 94));
        add(loginTitle);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        usernameLabel.setBounds(100, 100, 150, 30);
        add(usernameLabel);

        textFieldUser = new JTextField();
        textFieldUser.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textFieldUser.setBounds(220, 100, 200, 30);
        add(textFieldUser);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        passwordLabel.setBounds(100, 160, 150, 30);
        add(passwordLabel);

        textFieldPass = new JPasswordField();
        textFieldPass.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textFieldPass.setBounds(220, 160, 200, 30);
        add(textFieldPass);

        buttonSubmit = new JButton("Login");
        buttonSubmit.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonSubmit.setBounds(140, 240, 100, 35);
        buttonSubmit.setBackground(new Color(46, 204, 113));
        buttonSubmit.setForeground(Color.WHITE);
        buttonSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonSubmit.addActionListener(this);
        add(buttonSubmit);

        buttonClear = new JButton("Clear");
        buttonClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonClear.setBounds(260, 240, 100, 35);
        buttonClear.setBackground(new Color(231, 76, 60));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonClear.addActionListener(this);
        add(buttonClear);

        setSize(550, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String validUser = "admin";
        String validPass = "1234";

        if (e.getSource() == buttonSubmit) {
            if (Objects.equals(textFieldUser.getText(), validUser) &&
                    Objects.equals(String.valueOf(textFieldPass.getPassword()), validPass)) {
                setVisible(false);
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Incorrect Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                textFieldUser.setText("");
                textFieldPass.setText("");
            }
        }

        if (e.getSource() == buttonClear) {
            textFieldUser.setText("");
            textFieldPass.setText("");
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}