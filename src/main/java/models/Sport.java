package models;

import java.util.Objects;

public class Sport {
    private String name;
    private int price;
    private int maxPlayers;
    private int minPlayers;
    private int duration;
    private String rules;
    private int id;

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
        Sport sport = (Sport) o;
        return price == sport.price &&
                maxPlayers == sport.maxPlayers &&
                minPlayers == sport.minPlayers &&
                duration == sport.duration &&
                Objects.equals(name, sport.name) &&
                Objects.equals(rules, sport.rules);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price, maxPlayers, minPlayers, duration, rules);
    }
}
