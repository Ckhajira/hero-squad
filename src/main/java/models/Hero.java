package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private int id;
    private String name;
    private int age;
    private String origin_story;
    private String powers;
    private String weaknesses;
    private int squad_id;
    private static ArrayList<Hero> instances = new ArrayList<>();


    public Hero(String name, int age, String origin_story, String powers, String weaknesses, int squad_id) {
//    this.id = instances.size();
        this.name = name;
        this.age = age;
        this.origin_story = origin_story;
        this.powers = powers;
        this.weaknesses = weaknesses;
        this.squad_id = squad_id;
        instances.add(this);
    }
}