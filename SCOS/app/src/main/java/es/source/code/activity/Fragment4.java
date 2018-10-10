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

public class Fragment4 extends Fragment {

    private ListView listView;
    private FoodAdapter adapter;
    private List<Food> item;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4,container,false);
        initListView(view);
        return  view;

    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.me);
        item = new ArrayList<>();

        Food jiushui1 = new Food("烧酒", 100.00 , R.drawable.shaojiu,9);
        item.add(jiushui1);
        Food jiushui2 = new Food("啤酒", 15.00 , R.drawable.pijiu,10);
        item.add(jiushui2);
        Food jiushui3 = new Food("红酒", 300.00, R.drawable.hongjiu ,11);
        item.add(jiushui3);

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
