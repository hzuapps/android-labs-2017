package edu.hzuapps.androidlabs.homeworks.net1412070501227;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.hzuapps.androidlabs.R;


public class Net1412070501227index extends AppCompatActivity implements View.OnClickListener{
    private Button shopping_cart;//购物车按钮

    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1412070501227_index);
        iv1= (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);
        iv3= (ImageView) findViewById(R.id.iv3);
        iv4= (ImageView) findViewById(R.id.iv4);

        shopping_cart = (Button) findViewById(R.id.btn_cart);
        shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1412070501227index.this, Net1412070501227Commit.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id=1;
        switch (v.getId()){
            case R.id.iv1:
                id=1;
                break;
            case R.id.iv2:
                id=2;
                break;
            case R.id.iv3:
                id=3;
                break;
            case R.id.iv4:
                id=4;
                break;
        }
        Intent intent = new Intent(Net1412070501227index.this, Net1412070501227Commit.class);
        intent.putExtra("id",id);
        startActivity(intent);

    }
}
