package dao;

import models.Hero;
import org.sql2o.*;
import java.util.List;

public class Sql2oHeroDao implements HeroDao{
    private final Sql2o sql2o;
    public Sql2oHeroDao(Sql2o sql2o) {this.sql2o = sql20;}

    @Override
    public List<Hero> getAll(){
        try (Connection con=sql2o.open()){
            return con.createQuery("SELECT * FROM heroes")
                    .executeAndFetch(Hero.class);
        }
    }
    
}