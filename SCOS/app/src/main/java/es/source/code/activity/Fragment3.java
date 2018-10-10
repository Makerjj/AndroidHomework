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

public class Fragment3 extends Fragment {

    private ListView listView;
    private FoodAdapter adapter;
    private List<Food> item;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3,container,false);
        initListView(view);
        return  view;

    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.found);
        item = new ArrayList<>();
        Food haixian1 = new Food("螃蟹", 50.00 , R.drawable.pangxie,6);
        item.add(haixian1);
        Food haixian2 = new Food("八爪鱼", 50.00, R.drawable.bazhuayu ,7);
        item.add(haixian2);
        Food haixian3 = new Food("鱼翅", 100.00, R.drawable.yuchi ,8);
        item.add(haixian3);
        //Fragment5.itemNotOrder.addAll(item);

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
