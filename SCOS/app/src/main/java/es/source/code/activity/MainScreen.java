package es.source.code.activity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scos.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.model.User;

public class MainScreen extends AppCompatActivity {

    private GridView buttonGridView;
    private User user = null;
    private List<Map<String, Object>> listItems;

    private int[] buttonIcon = {
            R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
    };
    private String[] buttonNames = {
            "点菜","查看订单","登录/注册","系统帮助"
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        buttonGridView = (GridView)findViewById(R.id.gridview);

        listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < buttonIcon.length; ++i){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("icon", buttonIcon[i]);
            listItem.put("name", buttonNames[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems, R.layout.grid_item,
                new String[]{"icon", "name"},
                new int[]{R.id.grid_image, R.id.grid_text});
        buttonGridView.setAdapter(simpleAdapter);

       buttonGridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                int pos = 0; //登录/注册的位置可能有改变
                if(listItems.size() == 4){ pos = 2; }
                else{ pos = 0; }
               if(position == pos){
                    Intent intent = new Intent(MainScreen.this, LoginOrRegister.class);
                    startActivity(intent);
                }
                //点菜
                if(listItems.size() == 4 &&position == 0){
                    Intent intent = new Intent(MainScreen.this, FoodView.class);
                    intent.putExtra("User", user);
                    startActivity(intent);
                }
                //查看订单
                if(listItems.size() == 4 &&position == 1){
                    Intent intent = new Intent(MainScreen.this, FoodOrderView.class);
                    intent.putExtra("User", user);
                    startActivity(intent);
                }
            }

        });

        Intent intent = getIntent();
        String act = intent.getStringExtra("activity");
        if(act != null) {
            if (act.equals("SCOSEntry")) {
                String data = intent.getStringExtra("extra_data");
                if(!data.equals("FromEntry")){
                    //如果不相等就隐藏前两个导航项
                    listItems.remove(0);
                    listItems.remove(0);
                }
            } else if (act.equals("LoginRegister")) {
                String data = intent.getStringExtra("extra_data");
                //登录
                if (data.equals("LoginSuccess")) {
                    User inUser = (User) intent.getSerializableExtra("User");
                    user = inUser;
                    if(listItems.size() < 4){
                        Map<String, Object> listItem = new HashMap<String, Object>();
                        listItem.put("icon", buttonIcon[0]);
                        listItem.put("name", buttonNames[0]);
                        listItems.add(0,listItem);
                         listItem = new HashMap<String, Object>();
                        listItem.put("icon", buttonIcon[1]);
                        listItem.put("name", buttonNames[1]);
                        listItems.add(0,listItem);
                    }
                //注册
                }else if (data.equals("RegisterSuccess")){
                    User inUser = intent.getParcelableExtra("User");
                    user = inUser;
                    Toast.makeText(MainScreen.this,"欢迎您成为 SCOS 新用户",Toast.LENGTH_SHORT).show();
                    if(listItems.size() < 4){
                        Map<String, Object> listItem = new HashMap<String, Object>();
                        listItem.put("icon", buttonIcon[0]);
                        listItem.put("name", buttonNames[0]);
                        listItems.add(0,listItem);
                        listItem = new HashMap<String, Object>();
                        listItem.put("icon", buttonIcon[1]);
                        listItem.put("name", buttonNames[1]);
                        listItems.add(0,listItem);
                    }
                }else if (data.equals("Return")) {

                }
            }
        }




}



   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button menu = (Button)findViewById(R.id.menu);
        Button order = (Button)findViewById(R.id.order);
        Button logIn = (Button)findViewById(R.id.log_in);
       // Button help = (Button) findViewById(R.id.help);
        Intent intent = getIntent();
        String act = intent.getStringExtra("activity");
        if(act != null) {
            if (act.equals("SCOSEntry")) {
                String data = intent.getStringExtra("extra_data");
                if (!data.equals("fromEntry")) {
                    menu.setVisibility(View.GONE);
                    order.setVisibility(View.GONE);

                }
            } else if (act.equals("LoginRegister")) {
                String data = intent.getStringExtra("extra_data");
                if (data.equals("LoginSuccess")) {
                    if (menu.getVisibility() == View.GONE) {
                        menu.setVisibility(View.VISIBLE);
                        order.setVisibility(View.VISIBLE);
                    }
                } else if (data.equals("Return")) {

                }
            }
        }
*/

       /* logIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainScreen.this, LoginOrRegister.class);
                startActivity(intent);
            }
        });
    }*/
}
