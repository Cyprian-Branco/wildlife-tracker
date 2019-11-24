package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void animal_instantiatesCorrectly_true(){
        Animal animal = new Animal("Lion", "young");
        assertTrue( animal instanceof Animal);
    }
    @Test
    public void animal_nameInstantiatesCorrectly_String(){
        Animal animal = new Animal ("Lion", "young");
        assertEquals("Lion", animal.getName());
    }
    @Test
    public void animal_ageInstantiatesCorrectly_String(){
        Animal animal = new Animal("Lion", "young");
        assertEquals("young", animal.getAge());
    }

}