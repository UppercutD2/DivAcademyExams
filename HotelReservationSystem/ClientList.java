package DivAcademyExams.HotelReservationSystem;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ClientList {

    private Client [] clientArray;
     static int id=1;
    int size;

    public ClientList()
    {
        clientArray = new Client[0];

    }
    public Client[] getClientArray() {
        return clientArray;
    }

    public void addClient(Client client)
    {
        Client[] tempArray = new Client[size+1];

        for(int i=0;i<clientArray.length;i++)
        {
            tempArray[i]=clientArray[i];
        }

        tempArray[clientArray.length]=client;
        clientArray=tempArray;
        tempArray=null;
        size++;
//        System.out.println( " Current array - "+Arrays.toString(clientArray));
    }


    public int generateId()
    {
        this.id=++id;
        return this.id;
    }
}
