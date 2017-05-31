package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import homeworks.androids.hzuapps.edu.application.R;

public class FirstActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_net1414080903219);

        dbHelper=new MyDatabaseHelper(this,"WordList.db",null,1);
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
                Toast.makeText(FirstActivity.this,"开始插入数据", Toast.LENGTH_SHORT).show();
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                //组装数据
                values.put("english","audience");
                values.put("mean","n,观众");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","background");
                values.put("mean","n,背景");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","challenge");
                values.put("mean","n,挑战;v,向...挑战");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","descend");
                values.put("mean","v,下降");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","elite");
                values.put("mean","n,精英,掌权人物");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","faculty");
                values.put("mean","n,能力,才能");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","grope");
                values.put("mean","v,摸索");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","hysterical");
                values.put("mean","adj,歇斯底里的,情绪激动的");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","infant");
                values.put("mean","n,婴儿;adj,婴儿的");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","loyalty");
                values.put("mean","n,忠诚");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","mobilize");
                values.put("mean","v,动员,组织");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","tedious");
                values.put("mean","adj,冗长乏味的");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","qualitative");
                values.put("mean","adj,质量的，定性的");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","dizzy");
                values.put("mean","adj,头昏眼花的;v,使眩晕");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","amend");
                values.put("mean","v,修改");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","blunt");
                values.put("mean","adj,迟钝的，直率的;v,使迟钝");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","culminate");
                values.put("mean","v,达到终点");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();

                values.put("english","cater");
                values.put("mean","v,迎合");
                values.put("status","未学");
                db.insert("Word",null,values);
                values.clear();
                //Toast.makeText(FirstActivity.this,"charuchenggong!!!!", Toast.LENGTH_SHORT).show();
            }
        });

        Button queryButton=(Button)findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                //查询Word表中所有的数据
                Cursor cursor=db.query("Word",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        //Toast.makeText(FirstActivity.this,"有返回结果", Toast.LENGTH_SHORT).show();
                        //遍历Cursor对象，取出数据并打印
                        String english=cursor.getString(cursor.getColumnIndex("english"));
                        String mean=cursor.getString(cursor.getColumnIndex("mean"));
                        String status=cursor.getString(cursor.getColumnIndex("status"));
                        Log.d("FirstActivity","english is "+english);
                        Log.d("FirstActivity","mean is "+mean);
                        Log.d("FirstActivity","status is "+status);
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });

        Button bu1=(Button)findViewById(R.id.access);

        bu1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(FirstActivity.this,ZhujiemianActivity.class);
                startActivity(intent);
            }
        });

    }
}
