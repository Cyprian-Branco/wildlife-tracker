package models;

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
}
