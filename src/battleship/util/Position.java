package battleship.util;

/**
 * a class that defines a Position
 *
 * @author Sabil Mohamed Amine
 * @version 1.0
 * @since february 2020
 */
public class Position{

  // attributs of Position's class
  private int x;
  private int y;

  /**
  * define the absciss and ordinate coordinate of this's  position
  *@param x the value of the absciss coordinate
  *@param y the value of the ordinate coordinate
  */
  public Position (int x, int y){
    this.x = x;
    this.y = y;
  }

  /**
  * return the absciss coordinate of the position this
  *@return the absciss coordinate of the position this
  */
  public int getX(){
    return this.x;
  }

  /**
  * return the ordinate coordinate of the position this
  *@return the ordinate coordinate of the position this
  */
  public int getY(){
    return this.y;
  }

  /**
  * return true if the object in param is equal to the position this and False otherwise
  *@param  o the object whe want to compare to the position this
  *@return true if the object in param is equal to the position this and False otherwise
  */
  public boolean equals (Object o){
    if (!(o instanceof Position ))
        return false;
    Position somePosition = (Position) o;
    return  ( this.x == somePosition.x ) && (this.y == somePosition.y);
  }

  /**
  * return the String representation of the position this
  *@return the String representation of the position this
  */
  public String toString(){
    return "( " + this.x + " , " + this.y + " )";
  }
}
