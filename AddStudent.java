import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Pattern;
import java.sql.SQLException;

public class AddStudent extends JFrame implements ActionListener {

    JButton buttonSubmit, buttonClear;

    JTextField name, email, phone, father, mother, cast, address;

    JDateChooser dateChooser;

    JComboBox comboBoxCourse, comboBoxRel;

    JRadioButton male, female, other;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    AddStudent() {
        super("Add Student");
        JLabel loginTitle = new JLabel("Add Student Details");
        loginTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        loginTitle.setBounds(620, 30, 350, 35);
        loginTitle.setForeground(new Color(52, 73, 94));
        add(loginTitle);

        JLabel StudentID = new JLabel("Student ID :");
        StudentID.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentID.setBounds(150, 150, 150, 30);
        StudentID.setForeground(Color.BLACK);
        add(StudentID);

        JLabel StudentIDNo = new JLabel(first);
        StudentIDNo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentIDNo.setBounds(280, 150, 150, 30);
        StudentIDNo.setForeground(Color.BLACK);
        add(StudentIDNo);

        JLabel StudentName = new JLabel("Name :");
        StudentName.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentName.setBounds(150, 200, 150, 30);
        StudentName.setForeground(Color.BLACK);
        add(StudentName);
        name = new JTextField();
        name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        name.setBounds(280, 205, 300, 30);
        add(name);

        JLabel StudentDOB = new JLabel("DOB :");
        StudentDOB.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentDOB.setBounds(150, 250, 150, 30);
        StudentDOB.setForeground(Color.BLACK);
        add(StudentDOB);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(280, 255, 300, 30);
        add(dateChooser);

        JLabel StudentGender = new JLabel("Gender :");
        StudentGender.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentGender.setBounds(150, 300, 150, 30);
        StudentGender.setForeground(Color.BLACK);
        add(StudentGender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Segoe UI", Font.BOLD, 16));
        male.setBounds(280, 305, 100, 30);
        male.setBackground(new Color(236, 240, 241));
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Segoe UI", Font.BOLD, 16));
        female.setBounds(380, 307, 100, 30);
        female.setBackground(new Color(236, 240, 241));
        add(female);

        other = new JRadioButton("Other");
        other.setFont(new Font("Segoe UI", Font.BOLD, 16));
        other.setBounds(480, 307, 100, 30);
        other.setBackground(new Color(236, 240, 241));
        add(other);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        JLabel Course = new JLabel("Course :");
        Course.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Course.setBounds(150, 350, 150, 30);
        Course.setForeground(Color.BLACK);
        add(Course);
        String cou[] = {"BE", "B.tech", "MCA", "MBA", "Other"};
        comboBoxCourse = new JComboBox<>(cou);
        comboBoxCourse.setBackground(new Color(236, 240, 241));
        comboBoxCourse.setFont(new Font("Segoe UI", Font.BOLD, 16));
        comboBoxCourse.setBounds(280, 355, 300, 30);
        add(comboBoxCourse);

        JLabel Email = new JLabel("Email :");
        Email.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Email.setBounds(150, 400, 150, 30);
        Email.setForeground(Color.BLACK);
        add(Email);
        email = new JTextField();
        email.setFont(new Font("Segoe UI", Font.BOLD, 18));
        email.setBounds(280, 405, 300, 30);
        add(email);

        JLabel Phone = new JLabel("Phone :");
        Phone.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Phone.setBounds(900, 150, 150, 30);
        Phone.setForeground(Color.BLACK);
        add(Phone);
        phone = new JTextField();
        phone.setFont(new Font("Segoe UI", Font.BOLD, 18));
        phone.setBounds(1090, 155, 300, 30);
        add(phone);

        JLabel Father = new JLabel("Father's Name :");
        Father.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Father.setBounds(900, 200, 170, 30);
        Father.setForeground(Color.BLACK);
        add(Father);
        father = new JTextField();
        father.setFont(new Font("Segoe UI", Font.BOLD, 18));
        father.setBounds(1090, 205, 300, 30);
        add(father);

        JLabel Mother = new JLabel("Mother's Name :");
        Mother.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Mother.setBounds(900, 250, 170, 30);
        Mother.setForeground(Color.BLACK);
        add(Mother);
        mother = new JTextField();
        mother.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mother.setBounds(1090, 255, 300, 30);
        add(mother);

        JLabel Cast = new JLabel("Cast :");
        Cast.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Cast.setBounds(900, 300, 170, 30);
        Cast.setForeground(Color.BLACK);
        add(Cast);
        cast = new JTextField();
        cast.setFont(new Font("Segoe UI", Font.BOLD, 18));
        cast.setBounds(1090, 305, 300, 30);
        add(cast);

        JLabel Religion = new JLabel("Religion :");
        Religion.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Religion.setBounds(900, 350, 170, 30);
        Religion.setForeground(Color.BLACK);
        add(Religion);
        String rel[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboBoxRel = new JComboBox<>(rel);
        comboBoxRel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        comboBoxRel.setBounds(1090, 355, 320, 30);
        add(comboBoxRel);

        JLabel Address = new JLabel("Address :");
        Address.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Address.setBounds(900, 400, 170, 30);
        Address.setForeground(Color.BLACK);
        add(Address);
        address = new JTextField();
        address.setFont(new Font("Segoe UI", Font.BOLD, 18));
        address.setBounds(1090, 405, 300, 30);
        add(address);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBackground(Color.GREEN);
        buttonSubmit.setBounds(640, 550, 100, 30);
        buttonSubmit.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonSubmit.setForeground(Color.WHITE);
        buttonSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonSubmit.addActionListener(this);
        add(buttonSubmit);

        buttonClear = new JButton("Clear");
        buttonClear.setBackground(Color.RED);
        buttonClear.setBounds(800, 550, 100, 30);
        buttonClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonClear.addActionListener(this);
        add(buttonClear);

        getContentPane().setBackground(new Color(236, 240, 241));
        setLayout(null);
        setSize(1550, 869);
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
        String studentID = first;
        String stu_name = name.getText().trim();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gen = null;
        String cou = (String) comboBoxCourse.getSelectedItem();
        String mail = email.getText().trim();
        String mobile = phone.getText().trim();
        String dad = father.getText().trim();
        String mom = mother.getText().trim();
        String ca = cast.getText().trim();
        String rel = (String) comboBoxRel.getSelectedItem();
        String add = address.getText().trim();

        if (e.getSource() == buttonClear) {
            name.setText("");
            email.setText("");
            phone.setText("");
            father.setText("");
            mother.setText("");
            cast.setText("");
            address.setText("");
        } else if (e.getSource() == buttonSubmit) {
            if (male.isSelected()) gen = "Male";
            else if (female.isSelected()) gen = "Female";
            else if (other.isSelected()) gen = "Other";

            try {
                if (stu_name.isEmpty() || mail.isEmpty() || mobile.isEmpty() || dad.isEmpty() ||
                        mom.isEmpty() || ca.isEmpty() || add.isEmpty() || dob.isEmpty() || gen == null) {
                    JOptionPane.showMessageDialog(null, "All fields are required.");
                } else if (!isValidEmail(mail)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Email address (e.g. abc@gmail.com).");
                } else if (!isValidPhone(mobile)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit phone number.");
                } else {
                    Con con = new Con();
                    String q = "insert into student values('" + studentID + "','" + stu_name + "','" + dob + "','" + gen + "','" + cou + "'," +
                            "'" + mail + "','" + mobile + "','" + dad + "','" + mom + "','" + ca + "','" + rel + "','" + add + "')";
                    con.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Student added successfully.");
                    dispose();
                    new Dashboard();
                }
            } catch (SQLException f) {
                if (f.getMessage().toLowerCase().contains("duplicate") || f.getMessage().toLowerCase().contains("primary")) {
                    JOptionPane.showMessageDialog(null, "Email already exists. Please enter a different email.");
                } else {
                    f.printStackTrace();
                    JOptionPane.showMessageDialog(null, "A database error occurred.");
                }
            } catch (Exception g) {
                g.printStackTrace();
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
            }
        }
    }
    public static void main(String[] args) {
        new AddStudent();
    }
}