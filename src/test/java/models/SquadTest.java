package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

  public Squad setupNewSquad(){
   return new Squad("Hasashi", 8, "defeat the black dragon");
  }

  @Test
  public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
    Squad squad = setupNewSquad();
   assertEquals(true, squad instanceof Squad);
 }

  @Test
 public void HeroInstantiatesWithName_true() throws Exception {
   Squad squad = setupNewSquad();
   assertEquals("Hasashi", squad.getName());
 }

  @Test
  public void HeroInstantiatesWithAge_true() throws Exception {
    Squad squad = setupNewSquad();
    assertEquals(8, squad.getSize());
  }

  @Test
 public void HeroInstantiatesWithOrigin_story_true() throws Exception {
   Squad squad = setupNewSquad();
    assertEquals("defeat the black dragon", squad.getCause());
  }

}
