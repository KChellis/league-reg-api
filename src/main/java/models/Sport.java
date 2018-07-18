package models;

public class Sport {
    private int price;
    private int maxPlayers;
    private int minPlayers;
    private int duration;
    private String rules;

    public Sport(int price, int maxPlayers, int minPlayers, int duration, String rules) {
        this.price = price;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.duration = duration;
        this.rules = rules;
    }
}
