package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Test
    public void sighting_instantiatesCorrectly_True(){
        Sighting sighting = new Sighting("Mike", 2, "Tsavo");
        assertTrue(sighting instanceof Sighting);
    }
    @Test
    public void rangerInstantiatesCorrectly_String(){
        Sighting sighting = new Sighting("Mike", 2, "Tsavo");
        assertEquals("Mike", sighting.getRanger());
    }

    

}