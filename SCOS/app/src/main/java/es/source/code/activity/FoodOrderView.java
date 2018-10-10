package es.source.code.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.scos.R;

import es.source.code.model.User;

public class FoodOrderView extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private TabLayout.Tab tabOne;
    private TabLayout.Tab tabTwo;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order_view);
        initView();
        initEvent();

        //从MainScreen跳转过来
      /*  Intent intent2 = getIntent();
        intent2.getSerializableExtra("User");
*/
        //从FoodView跳转过来
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("User");
        int tab = -1;
        intent.getIntExtra("tab", 0);
        if(tab != -1) {
            switch (tab) {
                case 0:
                    viewPager.setCurrentItem(0);
                break;
                case 1:
                    viewPager.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("User", user);
        Fragment fragobj = new Fragment();
        fragobj.setArguments(bundle);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager2);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout2);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            String[] mTitles = {"未下菜单","已下菜单"};

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:

                        return new Fragment5();
                    default:

                        return new Fragment6();

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

        tabOne.setIcon(android.R.drawable.btn_star_big_off);
        tabTwo.setIcon(android.R.drawable.btn_star_big_off);
    }

}
