package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero{
    private int id;
    private String name;
    private int age;
    private String origin_story;
    private String powers;
    private String weaknesses;
    private int squad_id;
    private static ArrayList<Hero> instances = new ArrayList<>();

}