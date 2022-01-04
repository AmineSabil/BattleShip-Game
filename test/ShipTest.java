import org.junit.*;
import static org.junit.Assert.*;

import battleship.Ship ;


public class ShipTest{
  @Test
  public void testShipCreation() {
    Ship someShip = new Ship (10);
    assertNotNull(someShip);
    assertEquals(10,someShip.getLifePoints());
  }

  @Test
  public void testhasBeenSunkFalse() {
    Ship someShip = new Ship (10);
    assertFalse(someShip.hasBeenSunk());
    someShip.hitted();
    assertFalse(someShip.hasBeenSunk());
  }

  @Test
  public void testhasBeenSunkTrue() {
    Ship someShip = new Ship (1);
    assertFalse(someShip.hasBeenSunk());
    someShip.hitted();
    assertTrue(someShip.hasBeenSunk());
  }

  @Test
  public void testHitted(){
    Ship s= new Ship(2);
    assertEquals(2,s.getLifePoints());
    s.hitted();
    assertEquals(1,s.getLifePoints());
    s.hitted();
    assertEquals(0,s.getLifePoints());
  }

  @Test
  public void testgetLifePoints(){
    Ship s= new Ship(3);
    assertEquals(3,s.getLifePoints());
  }




  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(ShipTest.class);
  }

}
