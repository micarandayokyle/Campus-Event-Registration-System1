import javax.swing.*;
import java.awt.FlowLayout;

public class CERS {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Campus Event Registration System");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        
        JLabel lblname = new JLabel("Participant Name: ");
        JTextField txtname = new JTextField(30);

        
        JLabel lblage = new JLabel("Age: ");
        JTextField txtage = new JTextField(15);

        
        JLabel lbldept = new JLabel("College/Department: ");
        JTextField txtdept = new JTextField(25);

        
        JLabel lblevent = new JLabel("Event Category: ");
        String[] EventOptions = {
            "Select Event", 
            "Programming Competition", 
            "Web Design Challenge", 
            "Cybersecurity Seminar", 
            "AI and Emerging Technologies", 
            "IT Quiz Bowl"
        };
        JComboBox<String> cmbEvent = new JComboBox<>(EventOptions);

        
        JLabel lblattendance = new JLabel("Attendance Type: ");
        JRadioButton rdo1 = new JRadioButton("Student Participant");
        JRadioButton rdo2 = new JRadioButton("Student Audience");
        JRadioButton rdo3 = new JRadioButton("Faculty/Staff");

        ButtonGroup attendancegroup = new ButtonGroup();
        attendancegroup.add(rdo1);
        attendancegroup.add(rdo2);
        attendancegroup.add(rdo3);

       
        JLabel lblworkshops = new JLabel("Workshops to Attend: ");
        JCheckBox chk1 = new JCheckBox("Java Programming");
        JCheckBox chk2 = new JCheckBox("Web Development");
        JCheckBox chk3 = new JCheckBox("Cybersecurity");
        JCheckBox chk4 = new JCheckBox("Artificial Intelligence");
        JCheckBox chk5 = new JCheckBox("Database Management");

        
        JLabel lblrequests = new JLabel("Special Request or Notes: ");
        JTextArea txtrequests = new JTextArea(4, 30);
        txtrequests.setLineWrap(true);
        txtrequests.setWrapStyleWord(true);

        
        JButton btnRegister = new JButton("REGISTER");
        JButton btnClear = new JButton("CLEAR");

        
        frame.add(lblname);
        frame.add(txtname);
        frame.add(lblage);
        frame.add(txtage);
        frame.add(lbldept);
        frame.add(txtdept);
        
        frame.add(lblevent);
        frame.add(cmbEvent);
        
        frame.add(lblattendance);
        frame.add(rdo1);
        frame.add(rdo2);
        frame.add(rdo3);
        
        frame.add(lblworkshops);
        frame.add(chk1);
        frame.add(chk2);
        frame.add(chk3);
        frame.add(chk4);
        frame.add(chk5);
        
        frame.add(lblrequests);
        frame.add(txtrequests);
        
        frame.add(btnRegister);
        frame.add(btnClear);

        
        btnRegister.addActionListener(e -> {
            String name = txtname.getText().trim();
            String ageText = txtage.getText().trim();
            String dept = txtdept.getText().trim();
            String getEvent = cmbEvent.getSelectedItem().toString();
            String notes = txtrequests.getText().trim();

            
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Participant Name is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (ageText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Age field cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age = 0;
            try {
                age = Integer.parseInt(ageText);
                if (age <= 0) {
                    JOptionPane.showMessageDialog(frame, "Age must be greater than zero.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Age must contain a valid whole number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (dept.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "College/Department is required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cmbEvent.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(frame, "Please select an Event Category.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            String Attendance = "";
            if (rdo1.isSelected()) {
                Attendance = "Student Participant";
            } else if (rdo2.isSelected()) {
                Attendance = "Student Audience";
            } else if (rdo3.isSelected()) {
                Attendance = "Faculty/Staff";
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an Attendance Type.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            String workshops = "";
            if (chk1.isSelected()) {
                 workshops += "  - Java Programming\n";
             }
            if (chk2.isSelected()) {
                 workshops += "  - Web Development\n"; 
            }
            if (chk3.isSelected()) {
                 workshops += "  - Cybersecurity\n"; 
                 }
            if (chk4.isSelected()) 
            { workshops += "  - Artificial Intelligence\n"; 
            }
            if (chk5.isSelected()) 
            { workshops += "  - Database Management\n"; 
            }
            if (workshops.isEmpty()) {
                 workshops = "  - None Selected\n"; 
                 }

            if (notes.isEmpty()) {
                notes = "None";
            }

            
            String message = "=== REGISTRATION SUCCESS ===\n\n" +
                             "Participant Name: " + name + "\n" +
                             "Age: " + age + "\n" +
                             "College/Department: " + dept + "\n" +
                             "Event Category: " + getEvent + "\n" +
                             "Attendance Type: " + Attendance + "\n" +
                             "Workshops to Attend:\n" + workshops +
                             "Special Requests:\n  " + notes;

            JOptionPane.showMessageDialog(frame, message, "Summary", JOptionPane.INFORMATION_MESSAGE);
        });

        
        btnClear.addActionListener(e -> {
            txtname.setText("");
            txtage.setText("");
            txtdept.setText("");
            cmbEvent.setSelectedIndex(0);
            attendancegroup.clearSelection();
            chk1.setSelected(false);
            chk2.setSelected(false);
            chk3.setSelected(false);
            chk4.setSelected(false);
            chk5.setSelected(false);
            txtrequests.setText("");
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}