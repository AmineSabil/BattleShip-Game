import org.junit.*;
import static org.junit.Assert.*;

import battleship.*;
import battleship.util.*;

public class SeaTest {

  @Test
  public void testSeaCreation() {
    Sea someSea = new Sea(10,5);
    assertNotNull(someSea);
  }

  @Test
  public void testGetCellOk(){
    Sea someSea = new Sea(10,5);
    Position p = new Position(5,3);
    assertTrue(someSea.getCell(p).isEmpty());
  }

  @Test (expected = ArrayIndexOutOfBoundsException.class)
  public void testGetCellKo(){
    Sea someSea = new Sea(10,5);
    Position p = new Position(50,3);
    someSea.getCell(p);
  }

  @Test
  public void testGetBoardLifePointsOk(){
    Sea someSea = new Sea(10,10);
    Ship  someShip = new Ship(3);
    Position p = new Position(5,3);
    assertEquals(0,someSea.getBoardLifePoints());
    someSea.addShipVertically(someShip,p);
    assertEquals(3,someSea.getBoardLifePoints());
  }




  @Test
  public void testShootOk() {
    Sea someSea = new Sea(3,5);
    Position p = new Position(2,3);
    Answer  theAnswer=someSea.shoot(p);
    assertEquals(Answer.MISSED, theAnswer);
  }

  @Test (expected = ArrayIndexOutOfBoundsException.class)
  public void testShootKo() {
    Sea someSea = new Sea(10,5);
    Position p = new Position(11,30);
    someSea.shoot(p);
  }

  @Test
  public void testAddShipVerticallyOk(){
    Sea someSea = new Sea(10,10);
    Ship  someShip = new Ship(3);
    Position p = new Position(5,3);
    someSea.addShipVertically(someShip,p);
    assertFalse(someSea.getCell(p).isEmpty());
  }


  @Test (expected = IllegalStateException.class)
  public void testAddShipVerticallyKoIllegalExcept2(){
    Sea someSea = new Sea(4,10);
    Position p = new Position(5,3);
    Ship  someShip = new Ship(15);
    someSea.addShipVertically(someShip,p);
  }


  @Test (expected = IllegalStateException.class)
  public void testAddShipVerticallyIllegalExcept(){
    Sea someSea = new Sea(10,10);
    Position p = new Position(3,3);
    Ship  someShip = new Ship(4);
    someSea.addShipVertically(someShip,p);
    Ship  someShip2 = new Ship(3);
    someSea.addShipVertically(someShip2,p);
  }

  @Test
  public void testAddShipHorizontallyOk(){
    Sea someSea = new Sea(10,10);
    Ship  someShip = new Ship(3);
    Position p = new Position(5,3);
    someSea.addShipVertically(someShip,p);
    assertFalse(someSea.getCell(p).isEmpty());
  }


  @Test (expected = IllegalStateException.class)
  public void testAddShipHorizontallyKoIllegalExcept2(){
    Sea someSea = new Sea(2,10);
    Position p = new Position(5,3);
    Ship  someShip = new Ship(15);
    someSea.addShipVertically(someShip,p);
  }

  @Test (expected = IllegalStateException.class)
  public void testAddShipHorizontallyKoIllegalExcept(){
    Sea someSea = new Sea(10,10);
    Position p = new Position(3,3);
    Ship  someShip = new Ship(4);
    someSea.addShipVertically(someShip,p);
    Ship  someShip2 = new Ship(3);
    someSea.addShipVertically(someShip2,p);
  }


  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(SeaTest.class);
  }

}
