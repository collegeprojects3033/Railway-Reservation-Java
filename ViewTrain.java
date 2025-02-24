import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ViewTrainsUI extends JFrame {
    private JTable trainsTable;
    private JScrollPane scrollPane;

    public ViewTrainsUI() {
        setTitle("Available Trains");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Train ID");
        model.addColumn("Train Name");
        model.addColumn("Source");
        model.addColumn("Destination");
        model.addColumn("Available Seats");
        model.addColumn("Price");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM trains";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("train_id"),
                    rs.getString("train_name"),
                    rs.getString("source"),
                    rs.getString("destination"),
                    rs.getInt("available_seats"),
                    rs.getDouble("price")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        trainsTable = new JTable(model);
        scrollPane = new JScrollPane(trainsTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
