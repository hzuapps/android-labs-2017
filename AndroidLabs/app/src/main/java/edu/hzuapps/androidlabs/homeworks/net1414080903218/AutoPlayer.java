package edu.hzuapps.androidlabs.homeworks.net1414080903218;

/**
 * Created by zzh on 2017/5/1.
 */
public class AutoPlayer extends Player {
    private int putR;
    private int putC;
    public AutoPlayer(boolean first,Board b) {
        super(first,b);
        putR = 0;
        putC = 0;
    }
    public boolean putPiece(){
        findPutRC();
        if(!board.putPiece(first,putR,putC))return false;
        return true;
    }
    public void findPutRC(){
        for(int i=0;i<board.getRow();i++) {
            for (int j = 0; j < board.getCol(); j++) {
                if(board.isEmpty(i,j)){
                    putR = i;
                    putC = j;
                    return;
                }
            }
        }
    }
}
