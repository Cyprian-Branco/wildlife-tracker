package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.Objects;

public class Animal {
    public String name;
    public String age;
    public String type;
    public int id;
    public static final String[] ageArray = {"newborn", "young", "adult"};
    public Animal (String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
    @Override
    public boolean equals (Object o ){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getName(), animal.getName());
    }
    public int hashcode(){
        return Objects.hash(getName());
    }
    public void save(){
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, age, type) VALUES (:name, :age, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    public static Animal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id = :id;";
            Animal animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
}
