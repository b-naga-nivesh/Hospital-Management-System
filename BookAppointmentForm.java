import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class BookAppointmentForm extends javax.swing.JFrame {

    private Connection connection;
    /**
     * Creates new form BookAppointmentForm
     */
    public BookAppointmentForm() {
        initComponents();
        connectToDatabase();
        populateDoctorComboBox();
}
    public void connectToDatabase() {
        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Nivesh@1416");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
             e.printStackTrace(); 
        }
    }
    
    private void populateDoctorComboBox() {
        
        try {
            // Clear the combo box to avoid duplicates
            doctorNameComboBox.removeAllItems();
            String query = "SELECT DISTINCT name FROM doctors";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String doctorName = rs.getString("name");
                doctorNameComboBox.addItem(doctorName);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading doctor names!");
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        doctorNameLabel = new javax.swing.JLabel();
        appointmentDateField = new javax.swing.JLabel();
        appointmentTimeField = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();
        bookButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        patientName = new javax.swing.JLabel();
        patientTextField = new javax.swing.JTextField();
        dateTextField = new javax.swing.JTextField();
        doctorNameComboBox = new javax.swing.JComboBox<>();
        dateLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        doctorNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doctorNameLabel.setText("Doctor Name");

        appointmentDateField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        appointmentDateField.setText("Appointment Date");

        appointmentTimeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        appointmentTimeField.setText("Appointment Time");

        bookButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookButton.setText("Book");
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelButton.setText("Cancel");

        patientName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        patientName.setText("Patient Name");

        dateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextFieldActionPerformed(evt);
            }
        });

        dateLabel.setForeground(new java.awt.Color(102, 102, 102));
        dateLabel.setText("yyyy-mm-dd");

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("hh:mm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bookButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(doctorNameLabel)
                        .addComponent(appointmentTimeField)
                        .addComponent(appointmentDateField)
                        .addComponent(patientName)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(dateLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(timeTextField)
                            .addComponent(patientTextField)
                            .addComponent(dateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(doctorNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorNameLabel)
                    .addComponent(doctorNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentDateField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appointmentTimeField)
                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientName)
                    .addComponent(patientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookButton)
                    .addComponent(cancelButton))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>                        

    private void dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String doctorName = (String) doctorNameComboBox.getSelectedItem();
        String appointmentDate = dateTextField.getText().trim();
        String appointmentTime = timeTextField.getText();
        String patientName = patientTextField.getText().trim();

        if (doctorName == null || appointmentDate.isEmpty() || appointmentTime.isEmpty() || patientName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate date and time
        try {
            LocalDate date = LocalDate.parse(appointmentDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (date.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(this, "Appointment date cannot be in the past.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format! Use yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        // SQL query to insert appointment data into database
        String query = "INSERT INTO appointments (doctor_name, appointment_date, appointment_time, patient_name) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, doctorName);
            pst.setString(2, appointmentDate);
            pst.setString(3, appointmentTime);
            pst.setString(4, patientName);

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Appointment booked successfully!");
                this.dispose();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error booking appointment: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }                                          
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Close the form when Cancel is pressed
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookAppointmentForm().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel appointmentDateField;
    private javax.swing.JLabel appointmentTimeField;
    private javax.swing.JButton bookButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JComboBox<String> doctorNameComboBox;
    private javax.swing.JLabel doctorNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel patientName;
    private javax.swing.JTextField patientTextField;
    private javax.swing.JTextField timeTextField;
    // End of variables declaration                   
}
