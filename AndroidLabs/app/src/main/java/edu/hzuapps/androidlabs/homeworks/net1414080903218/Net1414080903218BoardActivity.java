package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.Toast;

public class Net1414080903218BoardActivity extends AppCompatActivity {
    public Board board;
    public Player firstPlayer;
    public AutoPlayer laterPlayer;
    private ChessView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903218_board);
        start();
        //Canvas myCanvas = new Canvas();
        /*DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240
    */    //Toast.makeText(this,Integer.valueOf(width)+","+Integer.valueOf(height),Toast.LENGTH_SHORT).show();
    }
    public void start(){
        board = new Board();
        firstPlayer = new Player(true,board);
        laterPlayer = new AutoPlayer(false,board);
        view = (ChessView)findViewById(R.id.ChessView);
        view.start(board.getRow(),board.getCol());
    }
/*    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x=event.getX();
        float y=event.getY();
        ChessBoard chessBoard=(ChessBoard) findViewById(R.id.ChessBosrd);
        if(x+chessBoard.grapX/2>chessBoard.boardSX && x-chessBoard.grapX/2<chessBoard.boardEX
                && y+chessBoard.grapY/2>chessBoard.boardSY && y-chessBoard.grapY/2<chessBoard.boardEY){
            int row=(int)((x-chessBoard.boardSX+chessBoard.grapY/2)/chessBoard.grapX);
            int col=(int)((y-chessBoard.boardSY+chessBoard.grapX/2)/chessBoard.grapY);
            Toast.makeText(chessBoard.getContext(),String.valueOf(row)+"  "+String.valueOf(col),Toast.LENGTH_SHORT).show();
            chessBoard.drawChess(row,col,Color.BLACK);
        }
        return true;
    }*/
}
