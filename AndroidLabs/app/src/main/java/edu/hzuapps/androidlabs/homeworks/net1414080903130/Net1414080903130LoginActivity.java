package edu.hzuapps.androidlabs.homeworks.net1414080903130;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903130LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903130_login);


        Button b = (Button)findViewById(R.id.login_register);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903130LoginActivity.this,Net1414080903130EnrollActivity.class);
                startActivity(intent);
            }
        });

        Button a = (Button) findViewById(R.id.login_login);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText name = (EditText) findViewById(R.id.login_username);//提取数据
                final EditText password = (EditText) findViewById(R.id.login_userpassword);
                String str_name = name.getText().toString();
                String str_password = password.getText().toString();
                //判断语句
                int n=check(str_name,str_password);
                if (n==1){
                    Intent intent = new Intent(Net1414080903130LoginActivity.this, Net1414080903130CustomerActivity.class);
                    startActivity(intent);
                }else if(n==0){
                    Intent intent = new Intent(Net1414080903130LoginActivity.this, Net1414080903130EmployeesActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Net1414080903130LoginActivity.this,"用户名/密码错误！！",Toast.LENGTH_LONG).show();
                }

            }
        });
        Button c = (Button)findViewById(R.id.json_login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903130LoginActivity.this,Net1414080903130JsonActivity.class);
                startActivity(intent);
            }
        });
    }

    public int check(String username,String password){
        Net1414080903130MySQLiteOpenHelper helper=new Net1414080903130MySQLiteOpenHelper(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor= db.query("user",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            String u=cursor.getString(cursor.getColumnIndex("username"));
            String p=cursor.getString(cursor.getColumnIndex("password"));
            if(u.equals(username)&&p.equals(password)){
                if (cursor.getString(cursor.getColumnIndex("customer")).equals("true")){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
        cursor.close();
        return -1;
    };

}



