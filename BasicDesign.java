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

        // Add Action Listeners to the buttons
        viewTrainsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open train view UI
                new ViewTrainsUI();
            }
        });

        bookTicketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open ticket booking UI
                new BookTicketUI();
            }
        });

        viewReservationsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open reservation view UI
                new ViewReservationsUI();
            }
        });
        
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RailwayReservationUI();
    }
}
