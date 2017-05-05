package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.graphics.Color;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by zzh on 2017/4/14.
 */
public class Board {
    private boolean display[][];
    private boolean first[][];
    private int firstColor;
    private int laterColor;
    private int countPieces;
    private int col;
    private int row;
    private boolean gameover;
    private boolean win;
    public Board(int r,int c){
        row = r;
        col = c;
        firstColor = Color.BLACK;
        laterColor = Color.WHITE;
        countPieces = 0;
        gameover = false;
        display = new boolean[row][col];
        first = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                display[i][j] = false;
            }
        }
    }
    public Board(){
        row = 10;
        col = 12;
        firstColor = Color.BLACK;
        laterColor = Color.WHITE;
        countPieces = 0;
        gameover = false;
        display = new boolean[row][col];
        first = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                display[i][j] = false;
            }
        }
    }
    public boolean putPiece(boolean first,int r,int c){
        if(gameover)return false;
        if(!isEmpty(r,c))return false;
        this.first[r][c] = first;
        display[r][c] = true;
        checkWin(first,r,c);
        return true;
    }
    public void clearPieces(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                display[i][j] = false;
            }
        }
    }
    public boolean isEmpty(int r,int c){
        if(display[r][c])return false;
        return true;
    }
    public boolean checkWin(boolean first,int x,int y){
        int i;
        int link[] = new int[8];
        boolean stop[] = new boolean[8];
        for(i=0;i<8;i++){
            link[i]=0;
            stop[i]=false;
        }
        for(i=1;i<5;i++){
            if(y-i>=0) {
                if (display[x][y - i] == true && this.first[x][y - i] == first) {
                    if (!stop[0]) link[0]++;
                } else stop[0] = true;
            }
            if(x+i<row && y-i>=0) {
                if (display[x + i][y - i] == true && this.first[x + i][y - i] == first) {
                    if (!stop[1]) link[1]++;
                } else stop[1] = true;
            }
            if(x+i<row) {
                if (display[x + i][y] == true && this.first[x + i][y] == first) {
                    if (!stop[2]) link[2]++;
                } else stop[2] = true;
            }
            if(x+i<row && y+i<col) {
                if (display[x + i][y + i] == true && this.first[x + i][y + i] == first) {
                    if (!stop[3]) link[3]++;
                } else stop[3] = true;
            }
            if(y+i<col) {
                if (display[x][y + i] == true && this.first[x][y + i] == first) {
                    if (!stop[4]) link[4]++;
                } else stop[4] = true;
            }
            if(x-i>=0 && y+i<col) {
                if (display[x - i][y + i] == true && this.first[x - i][y + i] == first) {
                    if (!stop[5]) link[5]++;
                } else stop[5] = true;
            }
            if(x-i>=0) {
                if (display[x - i][y] == true && this.first[x - i][y] == first) {
                    if (!stop[6]) link[6]++;
                } else stop[6] = true;
            }
            if(x-i>=0 && y-i>=0) {
                if (display[x - i][y - i] == true && this.first[x - i][y - i] == first) {
                    if (!stop[7]) link[7]++;
                } else stop[7] = true;
            }
        }
        for(i=0;i<4;i++){
            if(link[i]+link[i+4]+1>=5){
                gameover = true;
                win = first;
                return true;
            }
        }
        return false;
    }
    public boolean[][] getDisplay(){
        return display;
    }
    public boolean[][] getFirst(){
        return first;
    }
    public int getFirstColor(){
        return firstColor;
    }
    public int getLaterColor(){
        return laterColor;
    }
    public int getCountPieces(){
        return countPieces;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public boolean isGameover(){return gameover;}
    public boolean isFirstWin(){return win;}
}
