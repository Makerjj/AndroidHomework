package es.source.code.activity;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.scos.R;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.User;

public class FoodView extends FragmentActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private TabLayout.Tab tabOne;
    private TabLayout.Tab tabTwo;
    private TabLayout.Tab tabThree;
    private TabLayout.Tab tabFour;
    private Button button1;
    private Button button2;
    private  User user;

    //定义全局变量
    public static List<Food> listInOrder = new ArrayList<>();//点菜未下单
    public static List<Food> listNotInOrder = new ArrayList<>();//已下单
    public static double zongjia = 0.0;
    public static List<Food> itemAll = new ArrayList<>();//所有食物清单
    //public static User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_view);
        //隐藏actionBar
        ActionBar actionbar =getActionBar();
        if(actionbar != null){
            actionbar.hide();
        }

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("User");
        //User user2 = (User) intent2.getSerializableExtra("User");

        initView();
        initEvent();
        initFood();


        button1 = (Button)findViewById(R.id.x1);
        button2 = (Button)findViewById(R.id.x2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FoodOrderView.class);
                intent.putExtra("User",user);
                intent.putExtra("tab",0);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FoodOrderView.class);
                intent.putExtra("User",user);
                intent.putExtra("tab",1);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            String[] mTitles = {"冷菜", "热菜", "海鲜", "酒水"};
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new Fragment1();
                    case 1:
                        return new Fragment2();
                    case 2:
                        return new Fragment3();
                    default:
                        return new Fragment4();
                }
            }
            @Override
            public int getCount() {
                return mTitles.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);



    }

    private void initFood(){
        Food food1 = new Food("凉拌黄瓜",8.00, R.drawable.huanggua,0);
        itemAll.add(food1);
        Food food2 = new Food("杂蔬冷盘",10.00,R.drawable.shucai,1);
        itemAll.add(food2);
        Food food3 = new Food("什锦冷盘",10.00, R.drawable.shijin,2);
        itemAll.add(food3);
        Food recai1 = new Food("烧豆腐",15.00 , R.drawable.shaodoufu,3);
        itemAll.add(recai1);
        Food recai2 = new Food("香菇超萝卜", 15.00, R.drawable.xiangguchaoluobo,4 );
        itemAll.add(recai2);
        Food recai3 = new Food("香煎鱼", 15.00, R.drawable.xiangjianyu,5 );
        itemAll.add(recai2);
        Food haixian1 = new Food("螃蟹", 50.00 , R.drawable.pangxie,6);
        itemAll.add(haixian1);
        Food haixian2 = new Food("八爪鱼", 50.00, R.drawable.bazhuayu ,7);
        itemAll.add(haixian2);
        Food haixian3 = new Food("鱼翅", 100.00, R.drawable.yuchi ,8);
        itemAll.add(haixian3);
        Food jiushui1 = new Food("烧酒", 100.00 , R.drawable.shaojiu,9);
        itemAll.add(jiushui1);
        Food jiushui2 = new Food("啤酒", 15.00 , R.drawable.pijiu,10);
        itemAll.add(jiushui2);
        Food jiushui3 = new Food("红酒", 300.00, R.drawable.hongjiu ,11);
        itemAll.add(jiushui3);
    }

    private void initEvent() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab == tabLayout.getTabAt(0)){
                    tab.setIcon(android.R.drawable.btn_star_big_on);
                    viewPager.setCurrentItem(0);
                }else if(tab == tabLayout.getTabAt(1)){
                    tab.setIcon(android.R.drawable.btn_star_big_on);
                    viewPager.setCurrentItem(1);
                }else if(tab == tabLayout.getTabAt(2)){
                    tab.setIcon(android.R.drawable.btn_star_big_on);
                    viewPager.setCurrentItem(2);
                }else if(tab == tabLayout.getTabAt(3)){
                    tab.setIcon(android.R.drawable.btn_star_big_on);
                    viewPager.setCurrentItem(3);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(android.R.drawable.btn_star_big_off);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabOne = tabLayout.getTabAt(0);
        tabTwo = tabLayout.getTabAt(1);
        tabThree = tabLayout.getTabAt(2);
        tabFour = tabLayout.getTabAt(3);

        tabOne.setIcon(android.R.drawable.btn_star_big_off);
        tabTwo.setIcon(android.R.drawable.btn_star_big_off);
        tabThree.setIcon(android.R.drawable.btn_star_big_off);
        tabFour.setIcon(android.R.drawable.btn_star_big_off);

    }


}
