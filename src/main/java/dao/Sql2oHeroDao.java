package dao;

import models.Hero;
import org.sql2o.*;
import java.util.List;

public class Sql2oHeroDao implements HeroDao{
    private final Sql2o sql2o;
    public Sql2oHeroDao(Sql2o sql2o) {this.sql2o = sql2o;}

    @Override
    public List<Hero> getAll(){
        try (Connection con=sql2o.open()){
            return con.createQuery("SELECT * FROM heroes")
                    .executeAndFetch(Hero.class);
        }
    }

    @Override
    public void add(Hero hero){
        String sql = "INSERT INTO heroes (name, age, origin_story, powers, weakness, squad_id) VALUES (:name, :age:origin_story, :powers, :weaknesses, :squad_id)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(hero)
                    .executeUpdate()
                    .getKey();
            hero.setId(id);

        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}