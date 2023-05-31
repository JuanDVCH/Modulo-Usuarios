package app.models;

public class UsersModel {
     private  int idUsers;
    private String firstName;
    private String lastName;
    private String email;
    private String adress;
    private String city;
    private String department; 
    private String phone;
    private int state;
    //private String dateCreate;
    //private String dateUpdate;

    public UsersModel() {
    
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

//    public String getDateCreate() {
//        return dateCreate;
//    }
//
//    public void setDateCreate(String dateCreate) {
//        this.dateCreate = dateCreate;
//    }
//
//    public String getDateUpdate() {
//        return dateUpdate;
//    }
//
//    public void setDateUpdate(String dateUpdate) {
//        this.dateUpdate = dateUpdate;
//    }
}