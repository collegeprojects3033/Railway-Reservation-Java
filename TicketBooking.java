import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookTicketUI extends JFrame {
    private JTextField trainIdField, seatsField;
    private JButton bookBtn;
    
    public BookTicketUI() {
        setTitle("Book Ticket");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel trainIdLabel = new JLabel("Train ID:");
        JLabel seatsLabel = new JLabel("No of Seats:");
        
        trainIdField = new JTextField(10);
        seatsField = new JTextField(10);
        
        bookBtn = new JButton("Book Ticket");
        
        setLayout(new FlowLayout());
        add(trainIdLabel);
        add(trainIdField);
        add(seatsLabel);
        add(seatsField);
        add(bookBtn);

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Booking logic
                int trainId = Integer.parseInt(trainIdField.getText());
                int seats = Integer.parseInt(seatsField.getText());
                bookTicket(trainId, seats);
            }
        });

        setVisible(true);
    }

    private void bookTicket(int trainId, int seats) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT available_seats FROM trains WHERE train_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, trainId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int availableSeats = rs.getInt("available_seats");
                if (seats <= availableSeats) {
                    // Insert reservation into the database
                    String insertQuery = "INSERT INTO reservations (train_id, seats, reservation_date) VALUES (?, ?, CURDATE())";
                    PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                    insertStmt.setInt(1, trainId);
                    insertStmt.setInt(2, seats);
                    insertStmt.executeUpdate();

                    // Update available seats
                    String updateQuery = "UPDATE trains SET available_seats = available_seats - ? WHERE train_id = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                    updateStmt.setInt(1, seats);
                    updateStmt.setInt(2, trainId);
                    updateStmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Ticket booked successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Not enough seats available.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
