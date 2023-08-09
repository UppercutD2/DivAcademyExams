package DivAcademyExams.HotelReservationSystem;

public class Client {

    private int id;
    private String name;
    private String surname;
    private String password;
    private int birthYear;
    private String roomNumber;
    private boolean isAdmin;
    private int reserveTime;

    private String username;
    private double roomPaymentPerDays;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getRoomPaymentPerDays() {
        return roomPaymentPerDays;
    }

    public void setRoomPaymentPerDays(double roomPaymentPerDays) {
        this.roomPaymentPerDays = roomPaymentPerDays;
    }



    public Client()
    {

    }
    public Client(int id,String username,String password,boolean isAdmin)
    {
        this.id=id;
       this.username=username;
        this.password=password;
        this.isAdmin=isAdmin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {

        this.birthYear = birthYear;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(int reserveTime) {
        this.reserveTime = reserveTime;
    }


    @Override
    public String toString() {
        return
                "id= " + id +
                ", name= " + name +
                ", surname= " + surname  +
                ", password= " + password  +
                ", birthYear= " + birthYear +
                ", roomNumber= " + roomNumber  +
                ", isAdmin= " + isAdmin +
                ", reserveTime= " + reserveTime +
                ", username= " + username +
                ", roomPaymentPerDays= " + roomPaymentPerDays ;
    }
}
