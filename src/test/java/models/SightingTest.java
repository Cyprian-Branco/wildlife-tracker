package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Test
    public void sighting_instantiatesCorrectly_True() {
        Sighting sighting = new Sighting("Mike", 2, "Tsavo");
        assertTrue(sighting instanceof Sighting);
    }

    @Test
    public void rangerInstantiatesCorrectly_String() {
        Sighting sighting = new Sighting("Mike", 2, "Tsavo");
        assertEquals("Mike", sighting.getRanger());
    }

    @Test

    public void animalIdInstantiatesCorrectly_String() {
        Sighting sighting = new Sighting("Mike", 2, "Tsavo");
        assertEquals(2, sighting.getAnimalId());
    }

    @Test
    public void locationInstantiatesCorrectly_String() {
        Sighting sighting = new Sighting("Mike", 2, "Tsavo");
        assertEquals("Tsavo", sighting.getLocation());
    }

    @Test
       public void save_assignsIdToObject(){
          Sighting sighting = new Sighting("Mike", 2, "Tsavo");
          sighting.save();
          Sighting savedSighting = Sighting.all().get(0);
          assertEquals(1, savedSighting.getId());
      }
}