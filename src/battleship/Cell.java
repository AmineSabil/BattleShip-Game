package battleship ;

import battleship.util.Answer ;

/**
 * a class that defines a Cell
 *
 * @author Sabil Mohamed Amine
 * @version 1.0
 * @since february 2020
 */
public class Cell{

  //attributs
  private boolean hasBeenShot;
  private Ship ship;
  private static final char HIT='*';
  private static final char MISSED ='~';
  private static final char NOTVISED ='.';
  private static final char SHIPNOTHITED ='B';
  /**
  * define the ship in and if it the cell this has been already shot
  */
  public Cell(){
    this.ship =null;
    this.hasBeenShot = false ;
  }

  /**
  * set a ship in the Cell's this
  *@param someShip the ship whe want to add to the cell
  */
  public void setShip(Ship someShip){
    this.ship= someShip;
  }


  /**
  * return true if the cell has no Ship and False otherwise
  *@return true if the cell this has no ship and False otherwise
  */
  public boolean isEmpty(){
    return this.ship == null  ;
  }

  /**
  * return true if the cell has already been shot and False otherwise
  *@return true if the cell this has already been shot and False otherwise
  */
  public boolean hasBeenShot(){
    return this.hasBeenShot;
  }

  /**
  * return an Answer.MISSED if the cell was empty or has been already shot and Answer.HIT if the cell has been shot for the first time. and Answer.Sunk if the ship in the cell has been sunk
  *@return return  Answer.MISSED if the cell was empty or has been already shot and Answer.HIT if the cell has been shot for the first time. and Answer.Sunk if the ship in the cell has been sunk
  */
  public Answer shot(){
    if (!(this.hasBeenShot)){
      this.hasBeenShot =true ;
      if (!(this.isEmpty())){
          this.ship.hitted();
          if (this.ship.hasBeenSunk())
            return Answer.SUNK;
          else
            return Answer.HIT;
      }else {
        return Answer.MISSED;
      }
    }
    else
      return Answer.MISSED;
  }

  /** this method display a character for the cell which describes the state of the Cell
  * @param defender true if getCharacter is called for defender and false otherwise
  * @return the character that describe the state of the Cell
  */
  public char getCharacter(boolean defender) {
    if(defender){
      if (this.isEmpty())
         return Cell.MISSED; //'~';
      else if (this.hasBeenShot)
         return  Cell.HIT; // '*';
      else
         return Cell.SHIPNOTHITED; //'B';
    }
    else{
      if (!(this.hasBeenShot))
        return Cell.NOTVISED; // '.';
      else if (this.hasBeenShot && this.isEmpty())
        return Cell.MISSED; // '~';
      else
        return Cell.HIT; // '*';
    }
  }


}
