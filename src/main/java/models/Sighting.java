package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.util.Objects;

public class Sighting {
    private String ranger;
    private int animalId;
    private String location;
    private Timestamp seenDate;
    private int id;

    public Sighting (String ranger, int animalId, String location){
        this.ranger = ranger;
        this.animalId = animalId;
        this.location = location;
        this.seenDate = new Timestamp(new Date().getTime());

        if (ranger.equals("")){
            throw new IllegalArgumentException("Please enter Ranger name.");
        }
    }

    public String getRanger() {
        return ranger;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public Timestamp getSeenDate() {
        return seenDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return getAnimalId() == sighting.getAnimalId() &&
                Objects.equals(getRanger(), sighting.getRanger()) &&
                Objects.equals(getLocation(), sighting.getLocation()) &&
                Objects.equals(getSeenDate(), sighting.getSeenDate());
    }


}
