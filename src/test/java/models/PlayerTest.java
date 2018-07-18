package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void newPlayerInstantiatesCorrectly() {
        Player testPlayer = setupPlayer();
        assertTrue(testPlayer instanceof Player);
    }

    @Test
    public void getFirstName() {
    }

    @Test
    public void getLastName() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void getShirtSize() {
    }

    @Test
    public void getGender() {
    }

    public Player setupPlayer(){
        Player samplePlayer = new Player("Kristen", "Chellis", "peanutster@gmail.com", "small", "female");
        return samplePlayer;
    }
}