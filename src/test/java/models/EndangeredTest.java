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
    

}