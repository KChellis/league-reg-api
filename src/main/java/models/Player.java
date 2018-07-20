package models;

import java.util.Objects;

public class Player {

    private String firstName;
    private String lastName;
    private String email;
    private String shirtSize;
    private String gender;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName) &&
                Objects.equals(email, player.email) &&
                Objects.equals(shirtSize, player.shirtSize) &&
                Objects.equals(gender, player.gender);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, email, shirtSize, gender);
    }
}
