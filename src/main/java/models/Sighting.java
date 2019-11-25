package models;

import java.util.Date;
import java.sql.Timestamp;

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

    public int getId() {
        return Id;
    }

    public Timestamp getSeenDate() {
        return seenDate;
    }
}
