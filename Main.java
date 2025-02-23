class RailwaySystem {
    String train_list[];
    String reservations[];
}

class Train {
    String TrainName;
    int TrainNo;
    String Source;
    String Details;
    String Destination;
    int Sets;
}

class Reservation {
    int ReservationID;
    int Passengers;
    String TrainName;
    int SeatNumber;
    int JourneyDate;
}

class Passenger {
    String PassengerName;
    int PassengerAge;
    int MobileNo;
    Passenger(String n, int a, int m) {
        PassengerName = n;
        PassengerAge = a;
        MobileNo = m;
    }

    void ShowPassengerInfo() {
        System.out.println("Name:" + PassengerName);
        System.out.println("Age:" + PassengerAge);
        System.out.println("Mobile number:" + MobileNo);
    }
}

public class Main {

    public static void main(String[] args) {
        Passenger p = new Passenger("ganesh", 18, 1234567890);
        p.ShowPassengerInfo();
    }

}