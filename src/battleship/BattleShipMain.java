package battleship ;

import battleship.util.Position;

public class BattleShipMain{

  public static void main(String[] args){
    Sea sea = new Sea(10,10);
    sea.addShipHorizontally(new Ship(3),new Position(0,0));
    sea.addShipVertically(new Ship(4),new Position(6,2));
    sea.addShipHorizontally(new Ship(2),new Position(0,5));
    new Game(sea).play();
  }
}
