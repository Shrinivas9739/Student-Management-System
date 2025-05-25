import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewStudents extends JFrame implements ActionListener {

    JTable table;
    DefaultTableModel model;
    JTextField searchField;
    JComboBox<String> searchByCombo;
    JButton searchButton, resetButton, back;

    public ViewStudents() {
        setTitle("View Students");
        setLayout(new BorderLayout());
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        topPanel.add(new JLabel("Search by:"));
        searchByCombo = new JComboBox<>(new String[]{"Name", "Email"});
        topPanel.add(searchByCombo);

        searchField = new JTextField(20);
        topPanel.add(searchField);

        searchButton = new JButton("Search");
        resetButton = new JButton("Reset");
        back = new JButton("Back");
        searchButton.addActionListener(this);
        resetButton.addActionListener(this);
        back.addActionListener(this);

        topPanel.add(searchButton);
        topPanel.add(resetButton);
        topPanel.add(back);

        add(topPanel, BorderLayout.NORTH);
        String[] columns = {"Student ID", "Name", "DOB", "Gender", "Course", "Email", "Phone", "Father", "Mother", "Caste", "Religion", "Address"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        loadStudentData("");

        setVisible(true);
    }

    public void loadStudentData(String whereClause) {
        try {
            model.setRowCount(0);
            Con con = new Con();
            String query = "SELECT * FROM student " + whereClause;
            ResultSet rs = con.statement.executeQuery(query);

            while (rs.next()) {
                Object[] row = new Object[12];
                row[0] = rs.getString("StudentID");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("DOB");
                row[3] = rs.getString("Gender");
                row[4] = rs.getString("Course");
                row[5] = rs.getString("Email");
                row[6] = rs.getString("Phone");
                row[7] = rs.getString("FatherName");
                row[8] = rs.getString("MotherName");
                row[9] = rs.getString("Cast");
                row[10] = rs.getString("Religion");
                row[11] = rs.getString("Address");
                model.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String searchBy = searchByCombo.getSelectedItem().toString();
            String keyword = searchField.getText().trim();

            if (!keyword.isEmpty()) {
                String column = searchBy.equals("Name") ? "Name" : "Email";
                String whereClause = "WHERE " + column + " LIKE '%" + keyword + "%'";
                loadStudentData(whereClause);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter search keyword.");
            }

        } else if (e.getSource() == resetButton) {
            searchField.setText("");
            loadStudentData("");
        } else if (e.getSource() == back) {
            dispose();
            new Dashboard();
        }
    }
    public static void main(String[] args) {
        new ViewStudents();
    }
}