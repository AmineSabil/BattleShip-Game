import org.junit.*;
import static org.junit.Assert.*;

import battleship.util.Position ;

public class PositionTest {

  @Test
  public void testPositionCreation() {
    Position somePosition =new Position (3,4);
    assertNotNull( somePosition );
  }

  @Test
  public  void testGetX(){
    Position somePosition =new Position (3,4);
    assertEquals(somePosition.getX(),3);
  }

  @Test
  public  void testGetY(){
    Position somePosition =new Position (3,4);
    assertEquals(somePosition.getY(),4);
  }

  @Test
  public  void testEqualsOk(){
    Position somePosition =new Position (3,4);
    assertEquals(somePosition , new Position (3,4));
  }

  @Test
  public  void testToStringOk(){
    Position somePosition =new Position (3,4);
    assertEquals(somePosition.toString() , "( 3 , 4 )");
  }

  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(PositionTest.class);
  }

}
