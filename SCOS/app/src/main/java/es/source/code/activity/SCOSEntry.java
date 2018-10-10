package es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.scos.MainActivity;
import com.example.scos.R;

public class SCOSEntry extends AppCompatActivity {

    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

   // private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        //imageView = (ImageView)findViewById(R.id.image_view);
       // imageView.setImageResource(R.drawable.scos);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            y2 = event.getY();

            if (x1 - x2 > 50) {
                String data = "FromEntry";
                Intent intent = new Intent(this, MainScreen.class);
                intent.putExtra("activity", "SCOSEntry");
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        }
        return super.onTouchEvent(event);
    }
}
