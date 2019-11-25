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
    public void save_assignsIdToEndangeredAnimals() {
        Endangered testAnimalEndangered = new Endangered("Rhino", "healthy", "young");
        testAnimalEndangered.save();
        Endangered savedEndangeredAnimal = Endangered.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testAnimalEndangered.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimals_() {
        Endangered testAnimalEndangered = new Endangered("Rhino", "healthy", "young");
        Endangered otherAnimalEndangered = new Endangered("Elephant", "healthy", "young");
        testAnimalEndangered.save();
        otherAnimalEndangered.save();
        assertTrue(Endangered.all().get(0).equals(testAnimalEndangered));
        assertTrue(Endangered.all().get(1).equals(otherAnimalEndangered));
    }


}