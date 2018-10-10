package es.source.code.activity;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scos.R;

import org.w3c.dom.Text;

public class FoodDetailed extends AppCompatActivity {
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;
    int i = 0;

    private ImageView imageView;
    private TextView foodName;
    private TextView foodPrice;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detailed);
        imageView = (ImageView)findViewById(R.id.image_view);
        foodName = (TextView)findViewById(R.id.d1);
        foodPrice = (TextView)findViewById(R.id.d2);
        button = (Button)findViewById(R.id.d4);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        final Food food = FoodView.itemAll.get(id);
        imageView.setImageResource(food.getImageId());
        foodName.setText(food.getName());
        foodPrice.setText("￥"+food.getPrice());

        for(int i = 0; i < FoodView.listNotInOrder.size(); ++i) {
            if (FoodView.listNotInOrder.get(i).getName().equals(food.getName())) {
                button.setText("退点");
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().equals("点菜")){
                    Toast.makeText(FoodDetailed.this, "OK", Toast.LENGTH_SHORT).show();
                    FoodView.listNotInOrder.add(food);
                    FoodView.zongjia += food.getPrice();
                    button.setText("退点");
                }
                else{
                    Toast.makeText(FoodDetailed.this, "退菜成功", Toast.LENGTH_SHORT).show();
                    FoodView.listNotInOrder.remove(food);
                    FoodView.zongjia -= food.getPrice();
                    button.setText("点菜");
                }
            }
        });


    }
   // @Override
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
               i -=1;
               if(i < 0) i = FoodView.itemAll.size() - 1;
               Food food = FoodView.itemAll.get(i);
               imageView.setImageResource(food.getImageId());
                foodName.setText(food.getName());
                foodPrice.setText("￥"+food.getPrice());
            }

            if (x1 - x2 < 50) {
                i +=1;
                if(i >= FoodView.itemAll.size()) i= 0;
                Food food = FoodView.itemAll.get(i);
                imageView.setImageResource(food.getImageId());
                foodName.setText(food.getName());
                foodPrice.setText("￥"+food.getPrice());
            }
        }
        return super.onTouchEvent(event);
    }
}
