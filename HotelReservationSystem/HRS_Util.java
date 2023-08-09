package DivAcademyExams.HotelReservationSystem;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class HRS_Util {

    static void printLoginPage()
    {
        System.out.println("==========HOTEL RESERVATION SYSTEM==========\n" +
                "============LOGIN============");
    }//Simple print of Greeting Banner
    static void printAdminOptions(Scanner console,ClientList list)
    {
        boolean isActive = true;
        while(isActive) {
            Client[] array = list.getClientArray();
            System.out.println("==========HOTEL RESERVATION SYSTEM==========\n\n" +
                    "[1] ----> See All clients\n" +
                    "[2] ----> Register New Client\n" +
                    "[3] ----> Search Client\n" +
                    "[4] ----> Back to LOGIN\n\n" +
                    "[0] ----> Exit\n" +
                    "==============================");
            String option = requiredString("Choose Option: ", console);

            switch (option) {

                case"0":
                    System.exit(0);
                case "1":
                    seeAllClients(array);
                    break;
                case "2":
                    registerNewClient(list, console);
                    break;
                case "3":
                    searchClient(list, console);
                    break;
                case "4":
                    isActive=false;
                    break;
                default:
                    System.out.println("Invalid operation inserted.Please try again");



            }


        }
    }//gets option from admin page in String type

    static void printUserOptions(Scanner console,Client client)
    {
        boolean isActive = true;
        while(isActive) {
            System.out.println("\n==========HOTEL RESERVATION SYSTEM==========\n\n" +
                    "[1] ----> Your Info\n" +
                    "[2] ----> Back to LOGIN\n\n" +
                    "[0] ----> Exit\n" +
                    "==============================");
            String option = requiredString("Choose Option: ", console);
            switch(option)
            {
                case "0":
                    System.exit(0);
                case "1":
                    System.out.println(UserDetails(client));
                    break;
                case "2":
                    isActive=false;
                    break;
                default:
                    System.out.println("Wrong operation inserted. Please try again.");

            }
        }

    }
    static String UserDetails(Client client)
    {
       return "================================================" +
                ",\n name= " + client.getName() +
                ",\n surname= " + client.getSurname()  +
                ",\n birthYear= " + client.getBirthYear() +
                ",\n roomNumber= " + client.getRoomNumber()  +
                ",\n reserveTime= " + client.getReserveTime() +
               ",\n Room Payment Per Days=" + client.getRoomPaymentPerDays()+
                ",\n TOTAL AMOUNT= " + (client.getReserveTime()* client.getRoomPaymentPerDays())+
               "\n=================================================\n";
    }
    static void seeAllClients(Client[] array)
    {
        for( Client c :array)
        {
            System.out.println(c);

        }
    }//Prints all info about clients
    static void registerNewClient(ClientList list,Scanner console)
    {
        Client client = new Client();
        client.setId(list.generateId());
        client.setName(requiredString("Please insert name: ",console));
        client.setSurname(requiredString("Please insert surname: ",console));
        client.setBirthYear(checkBirthYear(console));
        client.setRoomNumber(checkRoomAvailability(list,console));
        client.setReserveTime(checkReserveTime(console));
        client.setPassword(requiredString("Please insert Password: ",console));
        client.setRoomPaymentPerDays(requiredDouble("Please Insert Room Payment Per Day: ",console));
        client.setUsername(generateUsername(client,client.getName(),client.getSurname(),client.getBirthYear(),list));
        list.addClient(client);

        System.out.println("New client has been Added \n" +
                "Username: " + client.getUsername() +"\n" +
                "Password: "+ client.getPassword());


    }//option for Registering new Client and creating unique Username
    static String checkRoomAvailability(ClientList list,Scanner console)
    {
        Client[]array = list.getClientArray();
        String roomNumber="";
        boolean check =true;
        boolean isActive=true;
        String[] roomNumbers =new String[array.length];
        int index=0;
        for(Client s:array)
        {
            if(s.getRoomNumber()==null) {
                roomNumbers[index] = "none";
                index++;
            }
            else {
                roomNumbers[index]=s.getRoomNumber();
                index++;
            }
        }
        String numbers = Arrays.toString(roomNumbers);
        while(isActive) {
            roomNumber = requiredString("Please insert Room Number: ", console);
            if(numbers.toLowerCase().contains(roomNumber.toLowerCase()))
            {
                System.out.println("This Room is occupied.Please try another.");
            }
            else
            {
                isActive=false;
            }

        }
        return roomNumber;

    }//that was hard but it worked in the end)))) checks if room has been used or not

    static void searchClient(ClientList list, Scanner console)
    {
        Client [] array = list.getClientArray();

        String search = requiredString("Please insert Name for Search in Clients DataBase: ",console);
        boolean notFound = true;
        for(Client c: array)
        {
            String name=c.getName();
            if(name!=null && name.toLowerCase().contains(search.toLowerCase()))
            {
                System.out.println(c);
                notFound=false;
            }

        }
        if(notFound)
            System.out.println("No Users with Such Name");
    }


    static String generateUsername(Client client,String name,String surname,int birthYear,ClientList list)
    {

        int number =0;
        String username=name.substring(0,3) + surname.substring(surname.length()-4,surname.length())+birthYear; ;
        boolean isActive=true;
        while(isActive)
        {
            if(checkUsername(list,username))
            {
                isActive=false;
            }
            else
            {
                number++;
                username=name.substring(0,3) +client.getId()+ surname.substring(surname.length()-4,surname.length())+birthYear;

            }
        }

        return username;
    }
    static boolean checkUsername(ClientList list,String username)
    {
        Client[] array = list.getClientArray();
        for(Client c :array)
        {
            if(username.toLowerCase().equals(c.getUsername().toLowerCase()))
            {
                return false;
            }
        }
        return true;
    }
    static int checkBirthYear(Scanner console)
    {   boolean isActive = true;
        int birthYear=0;
        while(isActive)
        {
             birthYear = requiredInt("Please insert Birth Year: ",console);
             int age = getAge(birthYear);
            if(age<=0)
            {
                System.out.println("Wrong Birth Year Inputted");
            }
            else if(age<18)
            {
                System.out.println("Registration only for Clients of 18 years old");
            }
            else
            {
                isActive=false;
            }
        }

        return birthYear;
    }//checks birthYear of new registration

    static  int getAge(int birthYear)
    {
        return 2023-birthYear;
    }//gets age of new registered Client

    static int checkReserveTime(Scanner console)
    {
        int reserveTime =0;
        boolean isActive = true;
        while (isActive)
        {
            reserveTime=requiredInt("Please insert Reserve Time: ",console);
            if(reserveTime<1 || reserveTime>30)
            {
                System.out.println("Wrong Reserve Time, Please try again in range(1-30)");
            }
            else
            {
             isActive=false;
            }
        }
        return reserveTime;
    }

    static Client usernameInput(Scanner console,ClientList list)
    {
        Client[] array = list.getClientArray();
        String username = requiredString("Username: ",console);

        for(Client c:array)
        {
            if(c.getUsername().toLowerCase().equals(username.toLowerCase()))
            return c;



        }
        System.out.println("Username not Found");
        return null;
    }//Checks username in database

    static boolean passwordInput(Scanner console,Client client)
    {
        if(null==client)
        return false;


        String password = "";
        boolean isActive = true;
        int attempts =3;
        while(attempts>0)
        {
            password = requiredString("Password: ",console);
            if(client.getPassword().equals(password))
            {
                return true;


            }
            else
            {   attempts--;
                System.out.println("Password incorrect. Left attempts "+attempts);
            }

        }

        System.out.println("Logging out!!!");
        return false;
    }//gets password input

    static Client Authentication(Scanner console,ClientList list)
    {
       Client client = usernameInput(console,list);
       boolean passwordCheck = passwordInput(console,client);

       return client;
    }

//    static double getPaymentPerDay(Scanner console)
//    {
//
//    }
//

    public static int requiredInt(String s, Scanner console)
    {   boolean active=true;
        int number = 0;
        while(active) {
            System.out.print(s);
            String input = console.nextLine();


            if (intChecker(input)) {
                number = Integer.parseInt(input);
                active=false;

            } else {
                System.out.println("\nWrong format of Number inputted");

            }
        }return number;
    }
    public static double requiredDouble(String s,Scanner console)
    {
        boolean active=true;
        double number = 0;
        while(active) {
            System.out.print(s);
            String input = console.nextLine();


            if (doubleChecker(input)) {
                number = Double.parseDouble(input);
                active=false;

            } else {
                System.out.println("\nWrong format of Number inputted");

            }
        }return number;
    }

    public static String requiredString(String s,Scanner console){
        System.out.print(s);
        return console.nextLine();
    }

    public static boolean intChecker(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean doubleChecker(String s){
        try
        {
            Double.parseDouble(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
