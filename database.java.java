//kashika,aminuddin,izzamer,puvandraan,jeevananthan
//22006368,22007578,22005742,22002099,22005408

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

private void addReservationToDatabase(FlightReservation reservation) {
    String url = "jdbc:mysql://localhost:3306/abs"; // Updated database name
    String username = "root"; // Default MySQL username for XAMPP
    String password = ""; // Default MySQL password for XAMPP, usually empty

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        String sql = "INSERT INTO absdb (Flight_Num, Flight_Name, Flight_Date, Departure, Destination, Departure_Time, Arrival_Time, Seat_Num, Class_Type, Is_Avail, Price_Amount, Price_Currency, Client_Name, Client_Phone_Num, Client_Passport_Num, Client_Contact_Details) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, reservation.getFlight().getFlightNumber());
        stmt.setString(2, reservation.getFlight().getFlightName());
        stmt.setString(3, reservation.getFlight().getFlightDate());
        stmt.setString(4, reservation.getFlight().getDeparture());
        stmt.setString(5, reservation.getFlight().getDestination());
        stmt.setString(6, reservation.getFlight().getDepartureTime());
        stmt.setString(7, reservation.getFlight().getArrivalTime());
        stmt.setString(8, reservation.getSeat().getSeatNumber());
        stmt.setString(9, reservation.getSeat().getClassType());
        stmt.setBoolean(10, reservation.getSeat().isAvailable());
        stmt.setDouble(11, reservation.getPrice().getAmount());
        stmt.setString(12, reservation.getPrice().getCurrency());
        stmt.setString(13, reservation.getClient().getName());
        stmt.setString(14, reservation.getClient().getPhoneNumber());
        stmt.setString(15, reservation.getClient().getPassportNumber());
        stmt.setString(16, reservation.getClient().getContactDetails());

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(frame, "Reservation added successfully!");
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error adding reservation to database: " + ex.getMessage());
    }
}
