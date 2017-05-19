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
    public Player laterPlayer;
    private ChessView view;
    public int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903218_board);
        start();
    }
    public void start(){
        int size = Integer.valueOf(getIntent().getStringExtra("size"));
        board = new Board(size,size);
        firstPlayer = new Player(true,board);
        mode = Integer.valueOf(getIntent().getStringExtra("mode"));
        if(mode == 1) {
            laterPlayer = new AutoPlayer(false, board);
        }
        else if(mode == 2) {
            laterPlayer = new NetPlayer(false, board);
        }
        else if(mode == 3) {
            laterPlayer = new Player(false, board);
        }
        else laterPlayer = new AutoPlayer(false, board);
        view = (ChessView)findViewById(R.id.ChessView);
        view.mode = mode;
        view.start(board.getRow(),board.getCol());
    }
}
