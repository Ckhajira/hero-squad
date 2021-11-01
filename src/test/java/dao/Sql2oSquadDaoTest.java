/*
package dao;

import models.Hero;
import models.Squad;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;

public class Sql2oSquadDaoTest {
 private static Sql2oSquadDao squadDao;
 private static Sql2oHeroDao heroDao;
 private static Connection conn;

 public Squad setupNewSquad(){
   return new Squad("Hasashi", 8, "defeat the black dragon");
  }

  @BeforeClass
public static void setUp() throws Exception {
   String connectionString = "jdbc:postgresql://localhost5432/herosamurai_test";
    Sql2o sql2o = new Sql2o(connectionString, "null", "null");
   squadDao = new Sql2oSquadDao(sql2o);
    heroDao = new Sql2oHeroDao(sql2o);
   conn = sql2o.open();
 }
  @Test
 public void addingSquadSetsId() throws Exception {
  Squad squad = setupNewSquad();
   int originalSquad_id = squad.getId();
   squadDao.add(squad);
   assertNotEquals(originalSquad_id, squad.getId());
  }

 @Test
 public void existingSquadsCanBeFoundById() throws Exception {
   Squad squad = setupNewSquad();
   squadDao.add(squad);
   Squad foundSquad = squadDao.findById(squad.getId());
   assertEquals(squad, foundSquad);
  }
 @Test
 public void addedSquadsAreReturnedFromGetAll() throws Exception {
   Squad squad = setupNewSquad();
    squadDao.add(squad);
   assertEquals(1, squadDao.getAll().size());
  }

 @Test
 public void noSquadsReturnsEmptyList() throws Exception {
   assertEquals(0, squadDao.getAll().size());
 }

  @Test
 public void updateChangesSquadContent() throws Exception {
   String initialName = "Lin Kuei";
   int initialSize = 5;
   String initialCause = "Avenge the ronin";
   Squad squad = new Squad (initialName,initialSize,initialCause);
   squadDao.add(squad);
   squadDao.update(squad.getId(),"Shirai Ryu",9,"Protect Outworld from the beyonders");
    Squad updatedSquad = squadDao.findById(squad.getId());
   assertNotEquals(initialName, updatedSquad.getName());
   assertNotEquals(initialSize, updatedSquad.getSize());
  assertNotEquals(initialCause, updatedSquad.getCause());
 }

  @Test
 public void deleteByIdDeletesCorrectSquad() throws Exception {
    Squad squad = setupNewSquad();
    squadDao.add(squad);
   squadDao.deleteById(squad.getId());
   assertEquals(0, squadDao.getAll().size());
 }

  @Test
  public void clearAllClearsAllSquads() throws Exception {
   Squad squad = setupNewSquad();
    Squad otherSquad = new Squad("Lin Kuei",6,"Avenge the ronin");
   squadDao.add(squad);
    squadDao.add(otherSquad);
    int daoSize = squadDao.getAll().size();
   squadDao.clearAllSquads();
   assertTrue(daoSize > 0 && daoSize > squadDao.getAll().size());
  }

  @Test
  public void getAllHeroesBySquadReturnsHeroesCorrectly() throws Exception {
   Squad squad = setupNewSquad();
   squadDao.add(squad);
    int squad_id = squad.getId();
   Hero newHero = new Hero("Hanzo Hasashi",22,"Avenge the ronin", "hell-fire","family-ties", squad_id);
    Hero otherHero = new Hero("Bi Han" ,87,"snvskbvk","cckdckbb", "jsnjsdnjns",squad_id);
   Hero thirdHero = new Hero("djcns jn",44,"ndscsdcksdnk","cksnckjsnk", "jndjnsjcsj", squad_id);
   heroDao.add(newHero);
   heroDao.add(otherHero); //we are not adding hero 3 so we can test things precisely.
   assertEquals(2, squadDao.getAllHeroesBySquad(squad_id).size());
    assertTrue(squadDao.getAllHeroesBySquad(squad_id).contains(newHero));
   assertTrue(squadDao.getAllHeroesBySquad(squad_id).contains(otherHero));
    assertFalse(squadDao.getAllHeroesBySquad(squad_id).contains(thirdHero)); //things are accurate!
  }


  @After
 public void tearDown() throws Exception {
   System.out.println("clearing database");
    squadDao.clearAllSquads();
    heroDao.clearAllHeroes();
  }

  @AfterClass
  public static void shutDown() throws Exception{
    conn.close();
   System.out.println("connection closed");
  }

}
*/