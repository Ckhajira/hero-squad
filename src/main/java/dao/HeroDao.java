package dao;

import models.Hero;

import java.util.List;

public interface HeroDao {
    //LIST
    List<Hero> getAll();

    //CREATE
    void add(Hero hero);

    //READ
    Hero findById(int id);

    //UPDATE
    void update(int id,String name, int age, String origin_story, String powers, String weaknesses, int squad_id);

    //DELETE
    void deleteById(int id);
    void clearAllHeroes();
}
