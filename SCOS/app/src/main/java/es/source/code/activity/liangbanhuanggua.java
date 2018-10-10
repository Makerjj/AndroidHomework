package es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.scos.R;

public class liangbanhuanggua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lencai);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("pos",0);
        ImageView huangguaImage = (ImageView)findViewById(R.id.huanggua);
        if(pos == 0)
            huangguaImage.setImageResource(R.drawable.huanggua);
        if(pos == 1)
            huangguaImage.setImageResource(R.drawable.shijin);
        if(pos == 2)
            huangguaImage.setImageResource(R.drawable.shijin);
    }
}
