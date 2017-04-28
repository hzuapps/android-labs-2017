package edu.hzuapps.androidlabs.homeworks.net1414080903130;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import edu.hzuapps.androidlabs.R;

public class Net1414080903130CustomerActivity extends AppCompatActivity {
    EditText a,b,c,d,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903130_customer);

        Button gukereturn = (Button)findViewById(R.id.customer_return);
        gukereturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903130CustomerActivity.this,Net1414080903130LoginActivity.class);
                startActivity(intent);
            }
        });

        a = (EditText)findViewById(R.id.customer_name);
        b = (EditText)findViewById(R.id.customer_room) ;
        c = (EditText)findViewById(R.id.customer_enjoytime);
        d = (EditText)findViewById(R.id.customer_leavetime);
        e = (EditText)findViewById(R.id.customer_call) ;
        Button input = (Button)findViewById(R.id.customer_register);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()){

                    Toast.makeText(Net1414080903130CustomerActivity.this,
                            "录入不成功！",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Net1414080903130CustomerActivity.this,
                            "录入成功！",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Net1414080903130CustomerActivity.this,Net1414080903130LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private boolean check(){
        String customername = a.getText().toString();
        String customerroom = b.getText().toString();
        String customerenjoytime = c.getText().toString();
        String customerleavetime = d.getText().toString();
        String customercall = e.getText().toString();
        if("".equals(customername) && "".equals(customerroom)&& "".equals(customerenjoytime) && "".equals(customerleavetime)){
            return true;
        }
        return false;
    }

}

