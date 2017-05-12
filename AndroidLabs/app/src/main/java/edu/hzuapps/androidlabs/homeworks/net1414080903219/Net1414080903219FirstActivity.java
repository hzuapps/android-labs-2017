package homeworks.androids.hzuapps.edu.application;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import homeworks.androids.hzuapps.edu.application.net1414080903219.Net1414080903219MyDatabaseHelper;

public class Net1414080903219FirstActivity extends AppCompatActivity {

    private Net1414080903219MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_net1414080903219);

        dbHelper=new Net1414080903219MyDatabaseHelper(this,"WordList.db",null,1);
        Button createDatabase=(Button)findViewById(R.id.create_database);

        createDatabase.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                dbHelper.getWritableDatabase();
            }
        });

       Button addData=(Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Net1414080903219FirstActivity.this,"开始插入数据", Toast.LENGTH_SHORT).show();
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                //组装数据
                values.put("word","audience");
                values.put("mean","n,观众");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","background");
                values.put("mean","n,背景");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","challenge");
                values.put("mean","n,挑战;v,向...挑战");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","descend");
                values.put("mean","v,下降");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","elite");
                values.put("mean","n,精英,掌权人物");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","faculty");
                values.put("mean","n,能力,才能");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","grope");
                values.put("mean","v,摸索");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","hysterical");
                values.put("mean","adj,歇斯底里的,情绪激动的");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","infant");
                values.put("mean","n,婴儿;adj,婴儿的");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","loyalty");
                values.put("mean","n,忠诚");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","mobilize");
                values.put("mean","v,动员,组织");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","tedious");
                values.put("mean","adj,冗长乏味的");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","qualitative");
                values.put("mean","adj,质量的，定性的");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","dizzy");
                values.put("mean","adj,头昏眼花的;v,使眩晕");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","amend");
                values.put("mean","v,修改");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","blunt");
                values.put("mean","adj,迟钝的，直率的;v,使迟钝");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","culminate");
                values.put("mean","v,达到终点");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();

                values.put("word","cater");
                values.put("mean","v,迎合");
                values.put("status","未学");
                db.insert("Net1414080903219Word",null,values);
                values.clear();
                Toast.makeText(Net1414080903219FirstActivity.this,"charuchenggong!!!!", Toast.LENGTH_SHORT).show();
            }
        });

        Button queryButton=(Button)findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                //查询Word表中所有的数据
                Cursor cursor=db.query("Net1414080903219Word",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        Toast.makeText(Net1414080903219FirstActivity.this,"有返回结果", Toast.LENGTH_SHORT).show();
                        //遍历Cursor对象，取出数据并打印
                        String word=cursor.getString(cursor.getColumnIndex("word"));
                        String mean=cursor.getString(cursor.getColumnIndex("mean"));
                        String status=cursor.getString(cursor.getColumnIndex("status"));
                        Log.d("Net1414080903219FirstActivity","word is "+word);
                        Log.d("Net1414080903219FirstActivity","mean is "+mean);
                        Log.d("Net1414080903219FirstActivity","status is "+status);
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });



    }
}
