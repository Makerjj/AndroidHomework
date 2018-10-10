package es.source.code.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.scos.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment {

    private ListView listView;
    private FoodAdapter adapter;
    private List<Food> item;
   // private List<String> item;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        initListView(view);
        return  view;

    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.wei_xin);
        item = new ArrayList<>();

        Food food1 = new Food("凉拌黄瓜",8.00, R.drawable.huanggua,0);
        item.add(food1);
        Food food2 = new Food("杂蔬冷盘",10.00,R.drawable.shucai,1);
        item.add(food2);
        Food food3 = new Food("什锦冷盘",10.00, R.drawable.shijin,2);
        item.add(food3);

        adapter = new FoodAdapter(getContext(),R.layout.content,item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = item.get(position);
                Intent intent = new Intent(getContext(), FoodDetailed.class);
                intent.putExtra("id",food.getId());
                startActivity(intent);
            }
        });
    }
}
