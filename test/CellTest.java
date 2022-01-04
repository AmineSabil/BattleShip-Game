import org.junit.*;
import static org.junit.Assert.*;

import battleship.Cell ;
import battleship.util.Answer ;
import battleship.Ship ;

public class CellTest {

  @Test
  public void testCellCreation() {
    Cell someCell = new Cell();
    assertNotNull(someCell);
    assertFalse(someCell.hasBeenShot());
    assertTrue(someCell.isEmpty());
  }

  @Test
  public void testCellSetShipOk() {
    Cell someCell = new Cell();
    assertNotNull(someCell);
    Ship someShip = new Ship(10);
    someCell.setShip(someShip);
    assertFalse(someCell.isEmpty());
  }

  @Test
  public void testIsEmptyOk() {
    Cell someCell = new Cell();
    assertTrue(someCell.isEmpty()); // ici on regarde qu'elle est vide
    Ship someShip = new Ship(13);
    someCell.setShip(someShip);  // ici on regarde qu'elle n'est plus vide
    assertFalse(someCell.isEmpty());
  }

  @Test
  public void testHasBeenShotOk() {
    Cell someCell = new Cell();
    assertFalse(someCell.hasBeenShot());
    someCell.shot();
    assertTrue(someCell.hasBeenShot());
  }

  @Test
  public void testFirstShot(){
    Cell c =new Cell();
    Ship s= new Ship(4);
    c.setShip(s);
    assertEquals(s.getLifePoints(),4);
    c.shot();
    assertEquals(s.getLifePoints(),3);
  }

  @Test
  public void testSecondShot(){
    Cell c =new Cell();
    Ship s= new Ship(4);
    c.setShip(s);
    assertEquals(s.getLifePoints(),4);
    c.shot();
    assertEquals(s.getLifePoints(),3);
    c.shot();
    assertEquals(s.getLifePoints(),3);
  }

  @Test
  public void testGetCharacterOk(){
    Cell c =new Cell();
    assertSame(c.getCharacter(true));
  }




  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(CellTest.class);
  }

}
