package edu.hzuapps.androidlabs.homeworks.net1414080903130;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903130EnrollActivity extends AppCompatActivity {
    EditText a,b,c,d;

    RadioButton rbCustomer;
    RadioButton rbEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903130_enroll);

        a = (EditText)findViewById(R.id.enroll_name);
        b = (EditText)findViewById(R.id.enroll_password) ;
        c = (EditText)findViewById(R.id.enroll_againpassword);
        d = (EditText)findViewById(R.id.enroll_call);

        rbCustomer= (RadioButton) findViewById(R.id.enroll_customer);
        rbEmployee= (RadioButton) findViewById(R.id.enroll_employee);

        Button fanhui = (Button)findViewById(R.id.enroll_return);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903130EnrollActivity.this,Net1414080903130LoginActivity.class);
                startActivity(intent);
            }
        });

        Button input = (Button)findViewById(R.id.enroll_register);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()){

                    Toast.makeText(Net1414080903130EnrollActivity.this,
                            "注册不成功！",Toast.LENGTH_SHORT).show();

                }else{
                    save(a.getText().toString(),b.getText().toString(),rbCustomer.isChecked());
                    Toast.makeText(Net1414080903130EnrollActivity.this,
                            "注册成功！",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Net1414080903130EnrollActivity.this,Net1414080903130LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private boolean check(){
        String enrollname = a.getText().toString();
        String enrollpassword = b.getText().toString();
        String enrollagainpassword = c.getText().toString();
        String enrollcall = d.getText().toString();
        if("".equals(enrollname) && "".equals(enrollpassword) && "".equals(enrollagainpassword) && "".equals(enrollcall)){
            return true;
        }
        return false;
    }
    public void save(String username,String password,boolean isCustomer){
        Net1414080903130MySQLiteOpenHelper helper=new Net1414080903130MySQLiteOpenHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("customer",isCustomer?"true":"false");
        db.insert("user",null,values);
        db.close();
    }

}
