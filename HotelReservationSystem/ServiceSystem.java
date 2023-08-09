package DivAcademyExams.HotelReservationSystem;

import java.util.Scanner;

public class ServiceSystem {



    static void RunHotelReservationSystem(Scanner console,ClientList list)
    {   Client client =null;
        boolean isActive=true;
        while(isActive){
            HRS_Util.printLoginPage();

             client = HRS_Util.usernameInput(console,list);
             boolean passwordCheck = HRS_Util.passwordInput(console,client);
             if(passwordCheck) {
                 isActive=false;
             }

        }

            if(client.isAdmin())
            {
                HRS_Util.printAdminOptions(console,list);

            } else
            {
                HRS_Util.printUserOptions(console,client);
            }
    }


}
