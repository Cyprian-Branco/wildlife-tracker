package models;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Sighting {
    private String ranger;
    private int animalId;
    private String location;
    private int Id;
    private Timestamp seenDate;

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

    public Timestamp getSeenDate() {
        return seenDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals (Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return getAnimalId() == sighting.getAnimalId() &&
                Objects.equals(getRanger(), sighting.getRanger()) &&
                Objects.equals(getLocation(), sighting.getLocation()) &&
                Objects.equals(getSeenDate(), sighting.getSeenDate());
    }

}
