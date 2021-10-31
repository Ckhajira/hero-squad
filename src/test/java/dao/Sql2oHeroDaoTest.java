package dao;

import models.Hero;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

    public class Sql2oHeroDaoTest {
        private static Sql2oHeroDao heroDao; //ignore me for now. We'll create this soon.
        private static Connection conn; //must be sql2o class conn

        @BeforeClass
        public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost5432/herosamurai_test";
        Sql2o sql2o = new Sql2o(connectionString, "null", "null");
        heroDao = new Sql2oHeroDao(sql2o); //ignore me for now
         conn = sql2o.open(); //keep connection open through entire test so it does not get erased
     }

        @After
        public void tearDown() throws Exception {
         System.out.println("clearing database");
        heroDao.clearAllHeroes();
         }

         @AfterClass
        public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
          }

          public Hero setupNewHero() {
        return new Hero("Turi", 22, "He was struck with radi and became the leader  of his mbogi", "spinning with yennx", "broke boi",6);
         }

         @Test
    public void addingHeroesSetsId() throws Exception {
      Hero hero = setupNewHero();
      int originalHeroId = hero.getId();
      heroDao.add(hero);
      assertNotEquals(originalHeroId, hero.getId()); //how does this work?
    }

      @Test
    public void existingHeroesCanBeFoundById() throws Exception {
          Hero hero = setupNewHero();
        heroDao.add(hero); //add to dao (takes care of saving)
        Hero foundHero = heroDao.findById(hero.getId()); //retrieve
        assertEquals(hero, foundHero); //should be the same
      }

 @Test
  public void addedHeroesAreReturnedFromgetAll() throws Exception {
    Hero hero = setupNewHero();
    heroDao.add(hero);
    assertEquals(1, heroDao.getAll().size(
));
  }

  @Test
 public void noHeroesReturnsEmptyList() throws Exception {
    assertEquals(0, heroDao.getAll().size());
  }

 @Test
  public void updateChangesHeroContent() throws Exception {
    String initialName = "Turi";
    int initialAge = 22;
   String initialOrigin_Story = "He was struck with radi and became the leader  of his mbogi";
    String initialPower = "spinning with yennx";
    String initialWeakness = "broke boi";
    int initialSquad_Id = 6;
   Hero hero = setupNewHero();
   heroDao.add(hero);

    heroDao.update(hero.getId(), "Sanchez", 21, "From Krypton","Telepath","High Frequency", 7);
    Hero updatedHero = heroDao.findById(hero.getId()); //why do I need to refind this?
    assertNotEquals(initialName, updatedHero.getName());
    assertNotEquals(initialAge, updatedHero.getAge());
   assertNotEquals(initialOrigin_Story, updatedHero.getOrigin_story());
   assertNotEquals(initialPower, updatedHero.getPowers());
   assertNotEquals(initialWeakness, updatedHero.getWeaknesses());
    assertNotEquals(initialSquad_Id, updatedHero.getSquad_id());
 }

  @Test
  public void deleteByIdDeletesCorrectHero() throws Exception {
   Hero hero = setupNewHero();
    heroDao.add(hero);
    heroDao.deleteById(hero.getId());
   assertEquals(0, heroDao.getAll().size());
  }

 @Test
 public void clearAllClearsAll() throws Exception {
   Hero hero = setupNewHero();
   Hero otherHero = new Hero("Sanchez", 2,"From Krypton","Telepath","High Frequency", 7);
  heroDao.add(hero);
   heroDao.add(otherHero);
   int daoSize = heroDao.getAll().size();
   heroDao.clearAllHeroes();
  assertTrue(daoSize > 0 && daoSize > heroDao.getAll().size()); //this is a little overcomplicated, but illustrates well how we might use `assertTrue` in a different way.
 }

  @Test
  public void squad_idIsReturnedCorrectly() throws Exception {
    Hero hero = setupNewHero();
   int originalCatId = hero.getSquad_id();
    heroDao.add(hero);
   assertEquals(originalCatId, heroDao.findById(hero.getId()).getSquad_id());
 }
}

