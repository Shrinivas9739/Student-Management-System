import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditStudent2 extends JFrame implements ActionListener {

    JButton buttonEdit, buttonClear;
    String gmail;
    JTextField name;
    JTextField phone;
    JTextField father;
    JTextField mother;
    JTextField cast;
    JTextField address;
    JTextField email;

    JDateChooser dateChooser;

    JComboBox comboBoxCourse,comboBoxRel;

    JRadioButton male,female,other;

    EditStudent2(String gmail){

        super("Add Student");
        setLayout(null);
        this.gmail = gmail;


        JLabel loginTitle = new JLabel("Edit Student Details");
        loginTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        loginTitle.setBounds(620, 30, 350, 35);
        loginTitle.setForeground(new Color(52, 73, 94));
        add(loginTitle);

        JLabel StudentID = new JLabel("Student ID :");
        StudentID.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentID.setBounds(150,150,150,30);
        StudentID.setForeground(Color.BLACK);
        add(StudentID);

        JLabel StudentIDNo = new JLabel();
        StudentIDNo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentIDNo.setBounds(280,150,150,30);
        StudentIDNo.setForeground(Color.BLACK);
        add(StudentIDNo);

        JLabel StudentName = new JLabel("Name :");
        StudentName.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentName.setBounds(150,200,150,30);
        StudentName.setForeground(Color.BLACK);
        add(StudentName);
        name = new JTextField();
        name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        name.setBounds(280,205,300,30);
        add(name);

        JLabel StudentDOB = new JLabel("DOB :");
        StudentDOB.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentDOB.setBounds(150,250,150,30);
        StudentDOB.setForeground(Color.BLACK);
        add(StudentDOB);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(280,255,300,30);
        add(dateChooser);

        JLabel StudentGender = new JLabel("Gender :");
        StudentGender.setFont(new Font("Segoe UI", Font.BOLD, 20));
        StudentGender.setBounds(150,300,150,30);
        StudentGender.setForeground(Color.BLACK);
        add(StudentGender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Segoe UI", Font.BOLD, 16));
        male.setBounds(280,305,100,30);
        male.setBackground(new Color(236, 240, 241));
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Segoe UI", Font.BOLD, 16));
        female.setBounds(380,307,100,30);
        female.setBackground(new Color(236, 240, 241));
        add(female);

        other = new JRadioButton("Other");
        other.setFont(new Font("Segoe UI", Font.BOLD, 16));
        other.setBounds(480,307,100,30);
        other.setBackground(new Color(236, 240, 241));
        add(other);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        JLabel Course = new JLabel("Course :");
        Course.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Course.setBounds(150,350,150,30);
        Course.setForeground(Color.BLACK);
        add(Course);
        String cou[] = {"BE","B.tech","MCA","MBA","Other"};
        comboBoxCourse = new JComboBox<>(cou);
        comboBoxCourse.setBackground(new Color(236, 240, 241));
        comboBoxCourse.setFont(new Font("Segoe UI", Font.BOLD, 16));
        comboBoxCourse.setBounds(280,355,300,30);
        add(comboBoxCourse);

        JLabel Email = new JLabel("Email :");
        Email.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Email.setBounds(150,400,150,30);
        Email.setForeground(Color.BLACK);
        add(Email);
        email = new JTextField();
        email.setFont(new Font("Segoe UI", Font.BOLD, 18));
        email.setBounds(280,405,300,30);
        add(email);

        JLabel Phone = new JLabel("Phone :");
        Phone.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Phone.setBounds(900,150,150,30);
        Phone.setForeground(Color.BLACK);
        add(Phone);
        phone = new JTextField();
        phone.setFont(new Font("Segoe UI", Font.BOLD, 18));
        phone.setBounds(1090,155,300,30);
        add(phone);

        JLabel Father = new JLabel("Father's Name :");
        Father.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Father.setBounds(900,200,150,30);
        Father.setForeground(Color.BLACK);
        add(Father);
        father = new JTextField();
        father.setFont(new Font("Segoe UI", Font.BOLD, 18));
        father.setBounds(1090,205,300,30);
        add(father);


        JLabel Mother = new JLabel("Mother's Name :");
        Mother.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Mother.setBounds(900,250,170,30);
        Mother.setForeground(Color.BLACK);
        add(Mother);
        mother = new JTextField();
        mother.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mother.setBounds(1090,255,300,30);
        add(mother);

        JLabel Cast = new JLabel("Cast :");
        Cast.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Cast.setBounds(900,300,170,30);
        Cast.setForeground(Color.BLACK);
        add(Cast);
        cast = new JTextField();
        cast.setFont(new Font("Segoe UI", Font.BOLD, 18));
        cast.setBounds(1090,305,300,30);
        add(cast);

        JLabel Religion = new JLabel("Religion :");
        Religion.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Religion.setBounds(900,350,170,30);
        Religion.setForeground(Color.BLACK);
        add(Religion);
        String rel[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        comboBoxRel = new JComboBox<>(rel);
        comboBoxRel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        comboBoxRel.setBounds(1090,355,320,30);
        add(comboBoxRel);

        JLabel Address = new JLabel("Address :");
        Address.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Address.setBounds(900,400,170,30);
        Address.setForeground(Color.BLACK);
        add(Address);
        address = new JTextField();
        address.setFont(new Font("Segoe UI", Font.BOLD, 18));
        address.setBounds(1090,405,300,30);
        add(address);

        buttonEdit = new JButton("Edit");
        buttonEdit.setBackground(Color.GREEN);
        buttonEdit.setBounds(640,550,100,30);
        buttonEdit.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonEdit.setForeground(Color.WHITE);
        buttonEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonEdit.addActionListener(this);
        add(buttonEdit);

        buttonClear = new JButton("Clear");
        buttonClear.setBackground(Color.RED);
        buttonClear.setBounds(800,550,100,30);
        buttonClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonClear.addActionListener(this);
        add(buttonClear);

        try{
            Con con = new Con();
            PreparedStatement ps = con.connection.prepareStatement("SELECT * FROM student WHERE Email = ?");
            ps.setString(1,gmail);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                StudentIDNo.setText(rs.getString("StudentID"));
                name.setText(rs.getString("Name"));
                String dob = rs.getString("DOB");
                if (dob != null && !dob.isEmpty()) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
                        Date date = sdf.parse(dob);
                        dateChooser.setDate(date);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error parsing DOB: " + ex.getMessage());
                    }
                }
                String gender = rs.getString("Gender");
                if (gender.equalsIgnoreCase("Male")) {
                    male.setSelected(true);
                } else if (gender.equalsIgnoreCase("Female")) {
                    female.setSelected(true);
                } else {
                    other.setSelected(true);
                }
                comboBoxCourse.setSelectedItem(rs.getString("Course").trim());;
                email.setText(rs.getString("Email"));
                phone.setText(rs.getString("Phone"));
                father.setText(rs.getString("FatherName"));
                mother.setText(rs.getString("MotherName"));
                cast.setText(rs.getString("Cast"));
                comboBoxRel.setSelectedItem(rs.getString("Religion").trim());
                address.setText(rs.getString("Address"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error loading data : " + e.getMessage());
        }
        getContentPane().setBackground(new Color(236, 240, 241));
        setSize(1550,869);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String stu_name = name.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gen = null;
        String cou = (String) comboBoxCourse.getSelectedItem();
        String mail = email.getText();
        String mobile = phone.getText();
        String dad = father.getText();
        String mom = mother.getText();
        String ca = cast.getText();
        String rel = (String) comboBoxRel.getSelectedItem();
        String add = address.getText();
        if (e.getSource() == buttonClear){
            name.setText("");
            email.setText("");
            phone.setText("");
            father.setText("");
            mother.setText("");
            cast.setText("");
            address.setText("");
        } else if (e.getSource() == buttonEdit) {
            if (male.isSelected()) {
                gen = "Male";
            } else if (female.isSelected()) {
                gen = "Female";
            } else if (other.isSelected()) {
                gen = "Other";
            }
            try {
                if (name.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty()
                        || father.getText().isEmpty() || mother.getText().isEmpty() || cast.getText().isEmpty()
                        || address.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"All fields are required.");
                }else {
                    try {
                        Con con = new Con();
                        PreparedStatement ps = con.connection.prepareStatement("SELECT * FROM student WHERE Email = ?");
                        ps.setString(1,gmail);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            String id = rs.getString("StudentID");
                            String q = "UPDATE student SET " +
                                    "StudentID = '" + id + "', " +
                                    "Name = '" + stu_name + "', " +
                                    "DOB = '" + dob + "', " +
                                    "Gender = '" + gen + "', " +
                                    "Course = '" + cou + "', " +
                                    "Email = '" + mail + "', " +
                                    "Phone = '" + mobile + "', " +
                                    "FatherName = '" + dad + "', " +
                                    "MotherName = '" + mom + "', " +
                                    "Cast = '" + ca + "', " +
                                    "Religion = '" + rel + "', " +
                                    "Address = '" + add + "' " +
                                    "WHERE Email = '" + gmail + "'";
                            con.statement.executeUpdate(q);
                            JOptionPane.showMessageDialog(null, "Student updated successfully.");
                            dispose();
                            new Dashboard();
                        }else {
                            JOptionPane.showMessageDialog(null, "Student not found with email: " + gmail);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } catch (Exception g) {
                g.printStackTrace();
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EditStudent2("");
        });
    }
}