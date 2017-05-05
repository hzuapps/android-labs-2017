package edu.hzuapps.androidlabs.homeworks.net1414080903218;

/**
 * Created by zzh on 2017/4/14.
 */
public class Player {
    protected int countPieces;
    protected boolean win;
    protected boolean first;
    public Board board;
    public Player(boolean first,Board b){
        board = b;
        this.first = first;
        countPieces = 0;
        win = false;
    }
    public boolean isWin(){
        return win;
    }
    public boolean isFirst() {
        return first;
    }
    public int getCountPieces(){
        return countPieces;
    }
    public boolean putPiece(int r,int c){
        if(!board.putPiece(first,r,c)){
            if(board.isGameover()){
                win = board.isFirstWin();
                if(!first)win = !win;
            }
            return false;
        }
        countPieces++;
        return true;
    }
}
