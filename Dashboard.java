import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton buttonAdd, buttonEdit, buttonDelete, buttonView, buttonLogOut;

    Dashboard() {
        super("Dashboard");

        JLabel heading = new JLabel("Student Management System", SwingConstants.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setBounds(50, 30, 420, 40);
        heading.setForeground(new Color(44, 62, 80));
        add(heading);

        buttonAdd = new JButton("Add Student");
        buttonView = new JButton("View Students");
        buttonEdit = new JButton("Edit Student");
        buttonDelete = new JButton("Delete Student");
        buttonLogOut = new JButton("Logout");

        JButton[] buttons = {buttonAdd, buttonView, buttonEdit, buttonDelete, buttonLogOut};

        for (JButton btn : buttons) {
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            btn.setBackground(new Color(41, 128, 185));
            btn.setForeground(Color.WHITE);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            add(btn);
        }

        buttonAdd.setBounds(50, 100, 140, 40);
        buttonAdd.addActionListener(this);
        buttonView.setBounds(200, 100, 140, 40);
        buttonView.addActionListener(this);
        buttonEdit.setBounds(350, 100, 140, 40);
        buttonEdit.addActionListener(this);

        buttonDelete.setBounds(125, 160, 140, 40);
        buttonDelete.addActionListener(this);
        buttonLogOut.setBounds(275, 160, 140, 40);
        buttonLogOut.addActionListener(this);

        getContentPane().setBackground(new Color(236, 240, 241));
        setLayout(null);
        setSize(560, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogOut){
            dispose();
            new Login();
        } else if (e.getSource() == buttonAdd) {
            dispose();
            new AddStudent();
        }else if (e.getSource() == buttonDelete) {
            dispose();
            new DeleteStudent();
        }
        else if (e.getSource() == buttonView) {
            dispose();
            new ViewStudents();
        } else if (e.getSource() == buttonEdit) {
            dispose();
            new EditStudent();
        }
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}