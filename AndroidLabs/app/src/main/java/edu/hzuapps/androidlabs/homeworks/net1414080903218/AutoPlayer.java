package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_APPEND;

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
    @Override
    public boolean putPiece(int r,int c){
        findPutRC();
        if(!board.putPiece(first,putR,putC))return false;
        countPieces++;
        return true;
    }
    public void findPutRC(){
        int i,j,x,y,x1,y1;
        boolean display[][] = board.getDisplay();
        boolean isFirst[][] = board.getFirst();
        int row = board.getRow();
        int col = board.getCol();
        int weight[][] = new int[board.getRow()][board.getCol()];
        int myLink[] = new int[8];
        int opponentLink[] = new int[8];
        boolean myLinkStop[] = new boolean[8];
        boolean opponentLinkStop[] = new boolean[8];
        boolean emptyStop[] = new boolean[8];
        boolean myEmpty[] = new boolean[8];
        boolean opponentEmpty[] = new boolean[8];
        for(x=0;x<board.getRow();x++) {
            for (y = 0; y < board.getCol(); y++) {
                weight[x][y] = 0;
                if(board.isEmpty(x,y)){
                    //初始化
                    for (j=0;j<8;j++){
                        myLink[j] = 0;
                        opponentLink[j] = 0;
                        myLinkStop[j] = false;
                        opponentLinkStop[j] = false;
                        emptyStop[j] = false;
                        myEmpty[j] = false;
                        opponentEmpty[j] = false;
                    }
                    //收集数据
                    for (i=1;i<5;i++){
                        for (j=0;j<8;j++) {
                            switch (j) {
                                case 0:
                                    x1 = x;
                                    y1 = y - i;
                                    break;
                                case 1:
                                    x1 = x + i;
                                    y1 = y - i;
                                    break;
                                case 2:
                                    x1 = x + i;
                                    y1 = y;
                                    break;
                                case 3:
                                    x1 = x + i;
                                    y1 = y + i;
                                    break;
                                case 4:
                                    x1 = x;
                                    y1 = y + i;
                                    break;
                                case 5:
                                    x1 = x - i;
                                    y1 = y + i;
                                    break;
                                case 6:
                                    x1 = x - i;
                                    y1 = y;
                                    break;
                                case 7:
                                    x1 = x - i;
                                    y1 = y - i;
                                    break;
                                default:
                                    x1 = x;
                                    y1 = y;
                            }
                            if (y1 >= 0 && x1 >= 0 && x1 < row && y1 < col) {
                                if(!emptyStop[j]) {
                                    if (display[x1][y1] == true) {
                                        if (isFirst[x1][y1] == first) {
                                            opponentLinkStop[j] = true;
                                            if (!myLinkStop[j]) myLink[j]++;
                                        } else {
                                            myLinkStop[j] = true;
                                            if (!opponentLinkStop[j]) opponentLink[j]++;
                                        }
                                    } else emptyStop[j] = true;
                                }
                            }
                        }
                    }
                    for (j=0;j<8;j++){
                        if(emptyStop[j]){
                            if(opponentLink[j]==0)myEmpty[j] = true;
                            if(myLink[j]==0)opponentEmpty[j] = true;
                        }
                    }
                    //分析数据
                    int myWeight = getWeight(myLink,myEmpty,true);
                    int opWeight = getWeight(opponentLink,opponentEmpty,false);
                    weight[x][y] = myWeight > opWeight ? myWeight : opWeight;
                }
            }
        }
        int max = 0;
        for (x=0;x<row;x++){
            for (y=0;y<col;y++){
                if(weight[x][y]>max) {
                    max = weight[x][y];
                    //writef(String.valueOf(max));
                    putR = x;
                    putC = y;
                }
            }
        }
    }

    private int getWeight(int link[],boolean empty[],boolean isMe){
        int j,weight = 0;
        for (j=0;j<4;j++){
            if(link[j]+link[j+4]>=4){
                if(!isMe)return Weight.BEST-1;
                return Weight.BEST;
            }
            if(link[j]+link[j+4]==3 && empty[j] && empty[j+4]){
                weight = Weight.BETTER > weight ? Weight.BETTER : weight;
            }
        }
        if(weight==0)for (j=0;j<7;j++)weight += link[j]*10;
        weight = Weight.BASE > weight ? Weight.BASE : weight;
        if(!isMe)weight--;
        String data = "";
        for (j=0;j<8;j++){
            data += link[j]+" ";
            if(empty[j])data += "1 ";
            else data += "0 ";
        }
        if(isMe)data += "1 ";
        else data += "0 ";
        data += weight;
        //board.writefNewLine(data);
        //writefNewLine(data);
        return weight;
    }
    public final class Weight{
        public final static int BEST = 1000;
        public final static int BETTER = 990;
        public final static int BASE = 10;
        public final static int L4 = BEST;
        public final static int L3T1 = BEST;
        public final static int L2T2 = BEST;
        public final static int E3E = BETTER;
        public final static int E21E = BETTER;
    }
}
