package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Hero setupNewHero() {
    return new Hero("Turi", 22, "He was struck with radi and became the leader  of his mbogi", "spinning with yennx", "broke boi", 6);
  }

   @Test
    public void HeroInstantiatesWithName_true() throws Exception {
   Hero hero = setupNewHero();
    assertEquals("Turi", hero.getName());
 }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(true, hero instanceof Hero);
     }

     @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
    Hero hero = setupNewHero();
       assertEquals(22, hero.getAge());
     }

      @Test
      public void HeroInstantiatesWithOrigin_story_true() throws Exception {
        Hero hero = setupNewHero();
      assertEquals("He was struck with radi and became the leader  of his mbogi", hero.getOrigin_story());
     }

      @Test
    public void HeroInstantiatesWithDescription_true() throws Exception {
      Hero hero = setupNewHero();
      assertEquals("spinning with yennx", hero.getPowers());
    }

      @Test
    public void HeroInstantiatesWithWeaknesses_true() throws Exception {
      Hero hero = setupNewHero();
      assertEquals("broke boi", hero.getWeaknesses());
     }

      @Test
    public void HeroInstantiatesWithSquad_id_true() throws Exception {
      Hero hero = setupNewHero();
      assertEquals(6, hero.getSquad_id());
      }


}