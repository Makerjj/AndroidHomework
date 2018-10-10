package es.source.code.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scos.R;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.User;


public class Fragment6 extends Fragment {
    private ListView listView;
    private FoodOrderAdapter adapter;
    private  User user = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5,container,false);
        user = (User) getActivity().getIntent().getSerializableExtra("User");
        initListView(view);
        if(getArguments() != null) {
            User user = (User) getArguments().getSerializable("User");
        }
        return  view;
    }

    private void initListView(View view) {
        listView = (ListView) view.findViewById(R.id.fra5);

        TextView sumCnt = (TextView) view.findViewById(R.id.sum_cnt);
        TextView sumPrice = (TextView) view.findViewById(R.id.sum_price);
        Button orderButton = (Button) view.findViewById(R.id.dingdan);
        orderButton.setText("结账");
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user !=null && user.getOldUser()){
                    Toast.makeText(getContext(), "您好，老顾客，本次你可享受 7 折优惠", Toast.LENGTH_SHORT).show();
                }
             }
        });

        sumCnt.setText("菜品数量："+ FoodView.listNotInOrder.size());
        sumPrice.setText("订单总价："+ FoodView.zongjia);
        adapter = new FoodOrderAdapter(getContext(),R.layout.content2,FoodView.listInOrder);
        listView.setAdapter(adapter);

    }
}
