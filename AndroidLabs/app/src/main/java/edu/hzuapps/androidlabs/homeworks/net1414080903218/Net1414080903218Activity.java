package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903218Activity extends AppCompatActivity {
    protected Intent IntentStartBoard;
    protected String size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903218);
        Button ButtonPtoC=(Button) findViewById(R.id.PtoCButton);
        Button ButtonPtoP=(Button) findViewById(R.id.PtoPButton);
        Button ButtonPtoN=(Button) findViewById(R.id.PtoNButton);
        if (ButtonPtoC != null) {
            ButtonPtoC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentStartBoard=new Intent(v.getContext(),Net1414080903218BoardActivity.class);
                    IntentStartBoard.putExtra("mode","1");
                    showChooseDialog();
                }
            });
        }
        if (ButtonPtoN != null) {
            ButtonPtoN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentStartBoard=new Intent(v.getContext(),Net1414080903218BoardActivity.class);
                    IntentStartBoard.putExtra("mode","2");
                    IntentStartBoard.putExtra("size","10");
                    startActivity(IntentStartBoard);
                    //showChooseDialog();
                }
            });
        }
        if (ButtonPtoP != null) {
            ButtonPtoP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentStartBoard=new Intent(v.getContext(),Net1414080903218BoardActivity.class);
                    IntentStartBoard.putExtra("mode","3");
                    showChooseDialog();
                }
            });
        }
    }
    String[] sizeArry = new String[] { "10 * 10","12 * 12", "15 * 15" };

    /* 选择框 */
    private void showChooseDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);// 自定义对话框
        builder.setTitle("选择棋盘大小");
        builder.setSingleChoiceItems(sizeArry, 0, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {// which是被选中的位置
                if(which == 0)size = "10";
                else if(which == 1)size = "12";
                else if(which == 2)size = "15";
                IntentStartBoard.putExtra("size",size);
                startActivity(IntentStartBoard);
                //sexView.setText(sexArry[which]);
                dialog.dismiss();//随便点击一个item消失对话框，不用点击确认取消
            }
        });
        builder.show();// 让弹出框显示
    }
}
