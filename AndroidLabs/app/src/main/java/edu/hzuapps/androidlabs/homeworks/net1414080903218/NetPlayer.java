package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 2017/5/1.
 */
public class NetPlayer extends Player {
    private int putR;
    private int putC;
    public NetPlayer(boolean first, Board b) {
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
    public boolean findPutRC(){
        return true;
    }
}
