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
}