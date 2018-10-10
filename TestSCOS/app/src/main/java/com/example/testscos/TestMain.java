package com.example.testscos;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        Button button = (Button)findViewById(R.id.jumpSCOS);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent = new Intent();
                //ComponentName componentName = new ComponentName("com.example.n1", "com.example.n1.FirstActivity");
               // ComponentName componentName = new ComponentName("com.example.testscos", "com.example.scos.MainActivity");
               // intent.setComponent(componentName);

             //   startActivity(intent);

                Intent intent = new Intent();
              //  intent.setClassName("com.example.uibestpractice", "com.example.uibestpractice.MainActivity");
                intent.setClassName("com.example.scos", "es.source.code.activity.MainScreen");
                //intent.putExtra("activity","testMain");
                startActivity(intent);


              /*  Intent intent2 = new Intent();
                //intent2.setClassName("com.example.testscos", "com.example.testscos.TestMain");
                intent2.setClassName("com.example.n1", "es.source.code.n1.FirstActivity");
                startActivity(intent2);
                finish();*/

               /* Intent intent = new Intent(TestMain.this, com.example.testscos.TestMain.class);
                startActivity(intent);*/
            }
        });
    }
}
