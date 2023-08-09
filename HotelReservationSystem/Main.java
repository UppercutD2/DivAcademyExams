package DivAcademyExams.HotelReservationSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientList list = new ClientList();
        Client admin = new Client(1,"admin","admin123",true);

        list.addClient(admin);

        Scanner console = new Scanner(System.in);
        while (true) {
            ServiceSystem.RunHotelReservationSystem(console, list);
        }

    }

    //considered
    //1.age restrictions
    //2.same room usage forbidden
    //3.unique Username creation in case of similar Data
    //4.reserve Time restrictions
}
