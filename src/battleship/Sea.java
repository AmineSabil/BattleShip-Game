package battleship ;
import battleship.Cell ;
import battleship.util.*;
import java.lang.*;

/**
 * a class that defines the  Sea for the game battleship;
 *
 * @author Sabil Mohamed Amine
 * @version 1.0
 * @since february 2020
 */
public class Sea{

   // Sea's class Attributes
   private Cell[][] board ;
   private int lifePointsBoard ;


   /**
   * define the width and height of the board of this's Sea
   *@param width the value of the width of this's board
   *@param height the value of the height of this's board
   */
   public Sea(int width , int height){
     this.lifePointsBoard=0;
     this.board = new Cell[height][width];
     for (int i =0; i<height ;i++){
       for (int j =0 ; j< width ; j++){
         this.board[i][j] = new Cell();
       }
     }
   }

   /**
   * return the lifePoints of all Ships on the board
   *@return the lifePoints of all ships on the board
   */
   public int getBoardLifePoints(){
     return this.lifePointsBoard;
   }

   /**
   * return the cell in the defined position p on the board
   *@param p the position of the cell whe want to return
   *@throws ArrayIndexOutOfBoundsException  the exception if the given position isn't in the this's board
   *@return  the cell in the defined position p on the board
   */
   public Cell getCell(Position p) throws ArrayIndexOutOfBoundsException {     // ajoutéééé
     try{
       int x =p.getX();
       int y =p.getY();
       return this.board[y][x];
     }catch(ArrayIndexOutOfBoundsException e){
       throw new ArrayIndexOutOfBoundsException("the param given is not valid, please retry with another one");
     }
   }

   /**
   * attack the cell given in the param and return the answer of the attack
   *@param p the position of the cell whe want to attack
   *@throws ArrayIndexOutOfBoundsException  the exception if the given position isn't in the this's board
   *@return the answer of the attack
   */
   public Answer shoot(Position p) throws ArrayIndexOutOfBoundsException {
     try{
       int x =p.getX();
       int y =p.getY();
       Cell cell1 =this.board[y][x];
       Answer answer = cell1.shot();
       if ((answer == Answer.HIT) || (answer == Answer.SUNK))
        this.lifePointsBoard -= 1;
       return answer;
     }catch(ArrayIndexOutOfBoundsException e){
       throw new ArrayIndexOutOfBoundsException("the param given is not valid, please retry with another one");
     }
   }

  /** add the ship b vertically down from position p. The number of cells is determined by the ship length.
  * @param shipToPlace the ship to add
  * @param position the position of the first (top) cell occupied by the ship
  * @throws IllegalStateException if the ship can not be placed on the sea because of an cell not empty or he is out of the board.
  *(outside of the board or some cell is not empty)
  */
   public void addShipVertically(Ship shipToPlace,Position position ) throws IllegalStateException {
      int x = position.getX();
      int y =position.getY();
      int lengthShip = shipToPlace.getLifePoints();
      if (( (lengthShip +y) >= this.board.length) || (x >= this.board[0].length) )
          throw new IllegalStateException("the ship cannot be placed in the position given,please retry with another position ");
      for (int i= y ; i< y+lengthShip ; i++){
        if (!(this.board[i][x].isEmpty()))
          throw new IllegalStateException("the ship cannot be placed in the position given,please retry with another position ");
      }
      for (int i =y ; i< y+lengthShip ; i++){
         this.board[i][x].setShip(shipToPlace);
      }
      this.lifePointsBoard += shipToPlace.getLifePoints();
   }


   /** add the ship b Horizontally  from position p. The number of cells is determined by the ship length.
   * @param shipToPlace the ship to add
   * @param position the position of the first  cell occupied by the ship
   * @throws IllegalStateException if the ship can not be placed on the sea because of an cell not empty or because of his length .
   *(outside of the board or some cell is not empty)
   */
    public void addShipHorizontally(Ship shipToPlace,Position position ) throws IllegalStateException  {
       int x = position.getX();
       int y =position.getY();
       int lengthShip = shipToPlace.getLifePoints();
       if (( (lengthShip+x) >= this.board[0].length ) || (y >= this.board.length) )
           throw new IllegalStateException("the ship cannot be placed in the position given,please retry with another position ");
       for (int i= x ; i< x+lengthShip ;i ++){
         if (!(this.board[y][i].isEmpty()))
           throw new IllegalStateException("the ship cannot be placed in the position given,please retry with another position ");
       }
       for (int i =x ; i< x+lengthShip ; i++){
          this.board[y][i].setShip(shipToPlace);
       }
       this.lifePointsBoard += shipToPlace.getLifePoints();
    }


    /** displays the board line by line and cell by cell,
    *the display changes for the defender or the opponent, defined
    *by the <code>defender</code> argument
    * @param defender true if display is for defender, false if for opponent
    */
    public void display(boolean defender) {
      String res="  ";
      for (int j=0; j<this.board[0].length;j++){
          res += j + " ";
      }res += "\n";
      for (int i=0;i<this.board.length; i++){
        res += i  + " ";
        for (int j=0; j<this.board[0].length;j++){
          res += this.board[i][j].getCharacter(defender);
          res += " ";
        }
        res +="\n";
      }
      System.out.println(res);
    }





}
