package es.source.code.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.scos.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {

    private ListView listView;
    private FoodAdapter adapter;
    private List<Food> item;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        initListView(view);
        return  view;

    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.contact);
        item = new ArrayList<>();

        Food recai1 = new Food("烧豆腐",15.00 , R.drawable.shaodoufu,3);
        item.add(recai1);
        Food recai2 = new Food("香菇超萝卜", 15.00, R.drawable.xiangguchaoluobo ,4);
        item.add(recai2);
        Food recai3 = new Food("香煎鱼", 15.00, R.drawable.xiangjianyu ,5);
        item.add(recai2);
       // Fragment5.itemNotOrder.addAll(item);
        adapter = new FoodAdapter(getContext(),R.layout.content,item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

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
