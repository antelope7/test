package linxiang.com.interfaces;

import linxiang.com.logger.Logger;

/**
 * Created by liulinxiang on 2017/5/26.
 */

interface Game{boolean move();}
interface GameFactory{ Game getGame();}

class Checks implements Game{
    private int moves = 0;
    private static final int MOVES = 3;
    public boolean move(){
        Logger.d("checkers move "+moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory{
    public Game getGame(){
        return new Checks();
    }
}

class Chess implements Game{
    private int moves = 0;
    private static final int MOVES = 4;
    public boolean move(){
        Logger.d("chess move "+moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory{
    public Chess getGame(){
        return new Chess();
    }
}



public class Games {
    public static void playGame(GameFactory factory){
        Game s = factory.getGame();
        while (s.move()){
            ;
        }
    }
    public static void main(String[] args){
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}
