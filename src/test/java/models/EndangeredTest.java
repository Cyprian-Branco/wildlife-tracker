package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Test
    public void endangeredAnimal_InstantiatesCorrectly_true() {
        Endangered testEndangered = new Endangered("Rhino", "healthy", "young");
        assertTrue(testEndangered instanceof Endangered);
    }
    @Test
    public void getName_EndangeredAnimalInstantiatesWithName_Rhino() {
        Endangered testEndangered = new Endangered("Rhino", "healthy", "young");
        assertEquals("Rhino", testEndangered.getName());
    }
    @Test
    public void equalsReturnsTrueIfNameIsSame_true() {
        Endangered testEndangered = new Endangered("Rhino", "healthy", "young");
        Endangered otherEndangered = new Endangered("Rhino", "healthy", "young");
        assertTrue(testEndangered.equals(otherEndangered));

    }
    @Test
    public void save_assignsIdToEndangered() {
        Endangered testEndangered = new Endangered("Rhino", "healthy", "young");
        testEndangered.save();
        Endangered savedEndangered = Endangered.all().get(0);
        assertEquals(testEndangered.getId(), savedEndangered.getId());
    }

}