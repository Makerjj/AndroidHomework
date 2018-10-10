package es.source.code.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scos.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment5 extends Fragment {
    private ListView listView;
    private FoodOrderAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5,container,false);
        initListView(view);
        return  view;

    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.fra5);
        TextView sumCnt = (TextView) view.findViewById(R.id.sum_cnt);
        TextView sumPrice = (TextView) view.findViewById(R.id.sum_price);
        Button orderButton = (Button) view.findViewById(R.id.dingdan);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                FoodView.listInOrder.addAll(FoodView.listNotInOrder);
                FoodView.listNotInOrder.clear();
                adapter.notifyDataSetChanged();
            }
        });
        //if(FoodView.listNotInOrder != null)
        {
            sumCnt.setText("菜品数量："+ FoodView.listNotInOrder.size());
            sumPrice.setText("订单总价："+ FoodView.zongjia);

            adapter = new FoodOrderAdapter(getContext(),R.layout.content2,FoodView.listNotInOrder);
            listView.setAdapter(adapter);
        }
    }
}
