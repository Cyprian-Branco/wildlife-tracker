package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public abstract class Animal{
    public String name;
    public int id;
    public String age;
    public static final String[] ageArray = {"newborn", "young", "adult"};

    public String type;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
            String sql = "SELECT * FROM animals WHERE id = :id;";
            Animal animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
}
