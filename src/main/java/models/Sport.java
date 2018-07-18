package models;

public class Sport {
    private String name;
    private int price;
    private int maxPlayers;
    private int minPlayers;
    private int duration;
    private String rules;

    public Sport(String name, int price, int maxPlayers, int minPlayers, int duration, String rules) {
        this.name = name;
        this.price = price;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.duration = duration;
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getDuration() {
        return duration;
    }

    public String getRules() {
        return rules;
    }
}
