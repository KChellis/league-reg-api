package models;

import java.sql.Time;
import java.util.Date;

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
}
