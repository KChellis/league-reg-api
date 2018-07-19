package models;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class League {
    private String name;
    private String description;
    private String weekday;
    private int sportId;
    private String field;
    private Date startDate;
    private String earlyTime;
    private String lateTime;
    private Date tourneyDay;
    private int id;

    public League(String name, String description, String weekday, int sportId, String field, Date startDate, String earlyTime, String lateTime, Date tourneyDay) {
        this.name = name;
        this.description = description;
        this.weekday = weekday;
        this.sportId = sportId;
        this.field = field;
        this.startDate = startDate;
        this.earlyTime = earlyTime;
        this.lateTime = lateTime;
        this.tourneyDay = tourneyDay;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWeekday() {
        return weekday;
    }

    public int getSportId() {
        return sportId;
    }

    public String getField() {
        return field;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getEarlyTime() {
        return earlyTime;
    }

    public String getLateTime() {
        return lateTime;
    }

    public Date getTourneyDay() {
        return tourneyDay;
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
        League league = (League) o;
        return sportId == league.sportId &&
                Objects.equals(name, league.name) &&
                Objects.equals(description, league.description) &&
                Objects.equals(weekday, league.weekday) &&
                Objects.equals(field, league.field) &&
                Objects.equals(startDate, league.startDate) &&
                Objects.equals(earlyTime, league.earlyTime) &&
                Objects.equals(lateTime, league.lateTime) &&
                Objects.equals(tourneyDay, league.tourneyDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, weekday, sportId, field, startDate, earlyTime, lateTime, tourneyDay);
    }
}
