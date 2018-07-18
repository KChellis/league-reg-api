package models;

public class Player {

    private String firstName;
    private String lastName;
    private String email;
    private String shirtSize;
    private String gender;

    public Player(String firstName, String lastName, String email, String shirtSize, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.shirtSize = shirtSize;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public String getGender() {
        return gender;
    }
}
