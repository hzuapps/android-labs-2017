package edu.hzuapps.androidlabs.homeworks.net1414080903130;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import edu.hzuapps.androidlabs.R;

public class Net1414080903130EmployeesActivity extends AppCompatActivity {
    EditText a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903130_employees);

        Button yuangongreturn = (Button)findViewById(R.id.enroll_return);
        yuangongreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903130EmployeesActivity.this,Net1414080903130LoginActivity.class);
                startActivity(intent);
            }
        });

        a = (EditText)findViewById(R.id.employees_name);
        b = (EditText)findViewById(R.id.employees_age) ;
        c = (EditText)findViewById(R.id.employees_department);
        d = (EditText)findViewById(R.id.employees_call);
        Button input = (Button)findViewById(R.id.employees_input);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()){

                    Toast.makeText(Net1414080903130EmployeesActivity.this,
                            "注册不成功！",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Net1414080903130EmployeesActivity.this,
                            "注册成功！",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Net1414080903130EmployeesActivity.this,Net1414080903130LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private boolean check(){
        String employeesname = a.getText().toString();
        String employeesage = b.getText().toString();
        String employeesdepartment = c.getText().toString();
        String employeescall = d.getText().toString();
        if("".equals(employeesname) && "".equals(employeesage) && "".equals(employeesdepartment)&& "".equals(employeescall)){
            return true;
        }
        return false;
    }

}
