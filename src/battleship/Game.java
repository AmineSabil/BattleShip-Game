package battleship ;
import io.Input ;
import battleship.util.* ;


/**
 * a class that defines the Game of battleship;
 *
 * @author Sabil Mohamed Amine
 * @version 1.0
 * @since March 2020
 */
public class Game {

    // Sea's class Attributes
    private Sea board;

    /** Game's constructor
    * define the board of the game
    *@param sea the board of the game whe want to play which is a Sea object.
    */
    public Game(Sea sea){
      this.board=sea;
    }

    /**
    * this method allow the user to hit an chosen cell that her coordinate are in the param
    *@param x the abscissa of the cell in the board that the user want to attack.
    *@param y the oridnate of the cell int the board that the user want to attack.
    *@throws ArrayIndexOutOfBoundsException if the coordinates are not valid .
    */
    private void hit(int x,int y) throws ArrayIndexOutOfBoundsException {
      Position p = new Position(x,y);
      try{
        Answer answer = this.board.shoot(p);
        this.board.display(false);
        System.out.println("the answer is "+ answer );
        System.out.println("the total life points remaining are "+this.board.getBoardLifePoints());
      }
      catch(ArrayIndexOutOfBoundsException e){
        System.out.println("the position given is not valid, please retry with another one");
      }
    }

    /**
    * this method play the game of battleship until all the ships are been sunk
    */
    public void play() {
      this.board.display(false);
      while (this.board.getBoardLifePoints()>0){
        try{
          System.out.print(" give an int for the absissa : ? ");
          int x = Input.readInt();
          System.out.print(" give an int for the ordinate : ? ");
          int y = Input.readInt();
          this.hit(x,y);
        }
        catch(ArrayIndexOutOfBoundsException e){
          System.out.println("the position given is out of  the board, please retry with another one");
        }
        catch(java.io.IOException e){
          System.out.println("please give an integer");
        }
      }System.out.println("Good Bye");
    }



}
