package battleship ;


/**
 * a class that defines a Ship
 *
 * @author Sabil Mohamed Amine
 * @version 1.0
 * @since february 2020
 */
public class Ship{
  // attributs
  private int lifePoints;

  /**
  * define the lifePoints of the ship
  * @param longueur an int that define the lifePoints of the ship this
  */
  public Ship(int longueur){
    this.lifePoints = longueur ;
  }

  /**
  * return this's life Points
  * @return the lifePoints of the ship this
  */
  public int getLifePoints() {
   return this.lifePoints;
  }


  /**
  * return true if this's ship has been sunk and false otherwise
  * @return return true if this's ship has been sunk and false otherwise
  */
  public boolean hasBeenSunk(){
    return this.lifePoints == 0;
  }

  /**
  * reduce the life Points of the ship this if the lifePoints are bigger or equal to 1
  */
  public void hitted(){
    if (this.lifePoints >= 1 )
        this.lifePoints -= 1;
  }
}
