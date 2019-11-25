package models;

import org.sql2o.Connection;

import java.util.List;

public class Endangered  extends Animal{
    public String health;
    public static final String DATABASE_TYPE = "endangered";

    public Endangered(String name, String age, String health){
        super();
        this.name = name;
        this.age = age;
        this.health = health;
        type = DATABASE_TYPE;
    }
    public String getHealth(){
        return health;
    }
    public static List<Endangered> all(){
        String sql = "SELECT * FROM WHERE type='endangered';";
        try (Connection con = DB.sql2o.open()){
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Endangered.class);
        }
    }
    public static Endangered find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id = :id;";

            Endangered animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(Endangered.class);
            return animal;

        }
    }
}
