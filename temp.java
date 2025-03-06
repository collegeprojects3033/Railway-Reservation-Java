import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RailwayReservationUI extends JFrame {

    private JPanel panel;
    private JButton viewTrainsBtn, bookTicketBtn, viewReservationsBtn;
    private JLabel titleLabel;

    public RailwayReservationUI() {
        setTitle("Railway Reservation System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        titleLabel = new JLabel("Welcome to the Railway Reservation System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        viewTrainsBtn = new JButton("View Trains");
        bookTicketBtn = new JButton("Book Ticket");
        viewReservationsBtn = new JButton("View Reservations");

        panel.add(titleLabel);
        panel.add(viewTrainsBtn);
        panel.add(bookTicketBtn);
        panel.add(viewReservationsBtn);
        
        // Add Action Listeners using anonymous inner classes
        viewTrainsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewTrainsUI();  // Open train view UI
            }
        });

        bookTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookTicketUI();  // Open ticket booking UI
            }
        });

        viewReservationsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewReservationsUI();  // Open reservation view UI
            }
        });
        
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RailwayReservationUI().setVisible(true);  // Make sure the UI is visible after initialization
            }
        });
    }
}

// Placeholder class for ViewTrainsUI
class ViewTrainsUI {
    public ViewTrainsUI() {
        JFrame frame = new JFrame("View Trains");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel label = new JLabel("Available Trains", JLabel.CENTER);
        frame.add(label, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}

// Placeholder class for BookTicketUI
class BookTicketUI {
    public BookTicketUI() {
        JFrame frame = new JFrame("Book Ticket");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel label = new JLabel("Ticket Booking", JLabel.CENTER);
        frame.add(label, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}

// Placeholder class for ViewReservationsUI
class ViewReservationsUI {
    public ViewReservationsUI() {
        JFrame frame = new JFrame("View Reservations");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel label = new JLabel("Your Reservations", JLabel.CENTER);
        frame.add(label, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}
