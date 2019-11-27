//package models;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class AnimalTest {
//    @Test
//    public void animal_instantiatesCorrectly_true(){
//        Animal animal = new Animal("Lion", "young");
//        assertTrue( animal instanceof Animal);
//    }
//    @Test
//    public void animal_nameInstantiatesCorrectly_String(){
//        Animal animal = new Animal ("Lion", "young");
//        assertEquals("Lion", animal.getName());
//    }
//    @Test
//    public void animal_ageInstantiatesCorrectly_String(){
//        Animal animal = new Animal("Lion", "young");
//        assertEquals("young", animal.getAge());
//    }
//    @Test
//    public void equals_returnSameIfNameAndAgeAreSame_True(){
//        Animal animal = new Animal("Lion", "young");
//        Animal otherAnimal = new Animal("Lion", "young");
//        assertTrue(animal.equals(otherAnimal));
//    }
//    @Test
//    public void save_assignsIdToObject(){
//        Animal animal = new Animal("Lion", "young");
//        animal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(animal.getId(), savedAnimal.getId());
//    }
//
//}