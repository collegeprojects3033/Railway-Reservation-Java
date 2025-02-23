import java.io.*;
 class RailwaySystem {
    
    String train_list[];
    String reservations[];
 
}
class trian {
    String tname;
    int tno;
    String source;
    String details;
    int sets;


    
}
class Reservation
{
    int reservationID;
    int passengers;
    String train_name;
    int seat_number;
    int date_of_journey;
}
class pasenger{
    String name;
    int age;
    int mobile_number;
    pasenger(String n,int a,int m)
    {
        name=n;
        age=a;
        mobile_number=m;
    }
    void pasenger_info_dip()
    {
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
        System.out.println("Mobile number:"+mobile_number);
    }
}
public class Main {
    
    public static void main(String[] args) {
         pasenger p=new pasenger("ganesh",18,1234567890);
        p.pasenger_info_dip();
    }
    
}